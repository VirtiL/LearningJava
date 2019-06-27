package make_consume.v3;

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
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            library.add();
        }
    }

}