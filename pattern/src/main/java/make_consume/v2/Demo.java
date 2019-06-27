package make_consume.v2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: No Description
 * @Time: 2019/2/11 16:29
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition makecon = lock.newCondition();
        Condition concon = lock.newCondition();
        Library library = new Library(lock,makecon,concon);
        Make make = new Make(library);
        Make make2 = new Make(library);
        Make make3 = new Make(library);
        Consume consume = new Consume(library);
        Consume consume2 = new Consume(library);
        Consume consume3 = new Consume(library);

        make.start();
        make2.start();
        make3.start();

        consume.start();
        consume2.start();
        consume3.start();


    }

}