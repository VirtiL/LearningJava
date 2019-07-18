package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-5 10:17
 * @Version 1.0
 */
public class NioServer {

    private int port = 5555;
    private InetSocketAddress inetAddress = null;
    private Selector selector;

    public NioServer(int port) {
        try {
            this.port = port;
            inetAddress = new InetSocketAddress(port);
            ServerSocketChannel server = ServerSocketChannel.open();
            System.out.println("通道已开启...");
            server.bind(inetAddress);
            System.out.println("通道地址已绑定...");
            //默认为阻塞,手动开启非阻塞
            server.configureBlocking(false);
            System.out.println("通道非阻塞已开启...");

            selector = Selector.open();
            System.out.println("selector已开启...");

            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("通道启动完成...  开始接受请求!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new NioServer(5555).listen();
    }

    private void listen() {
        System.out.println("开始轮训监听请求...");
        while (true){
            try {
                int wait = this.selector.select();
                System.out.println("当前有"+wait+"个请求在排队等待!");
                if(wait == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    System.out.println("开始叫号...");

                    System.out.println("开始处理请求...");
                    process(key);

                    iterator.remove();
                    System.out.println("废除号码...");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void process(SelectionKey key) throws IOException {
        System.out.println("处理请求开始...");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        if(key.isAcceptable()){
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel accept = server.accept();
            accept.configureBlocking(false);
            accept.register(selector,SelectionKey.OP_READ);
            System.out.println("链接");
        }else if(key.isReadable()){
            System.out.println("读");
            SelectableChannel channel = key.channel();
            channel.configureBlocking(false);
            channel.register(selector,SelectionKey.OP_WRITE);

        }else if(key.isWritable()){
            System.out.println("写");

        }
        System.out.println("处理请求开始...");
    }

}