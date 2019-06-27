package make_consume.v1;

/**
 * @Description: 卖家
 * @Time: 2019/2/11 16:17
 * @Version 1.0
 */
public class Make extends Thread{

    private Library library;

    public Make(Library library) {
        this.library = library;
    }
    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            library.add();
        }
    }
}