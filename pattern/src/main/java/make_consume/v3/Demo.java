package make_consume.v3;

/**
 * @Description: No Description
 * @Time: 2019/2/11 16:29
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        Library library = new Library();
        //生产者线程
        Make p = new Make(library);
        //多个消费者
        Consume c1 = new Consume(library);
        Consume c2 = new Consume(library);
        Consume c3 = new Consume(library);

        p.start();
        c1.start();
        c2.start();
        c3.start();
    }

}