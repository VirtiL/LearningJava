package make_consume.v2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description: 栈库房
 * @Time: 2019/2/11 16:26
 * @Version 1.0
 */
public class Library {

    private Lock lock;
    private Condition makecon;
    private Condition concon;

    public Library(Lock lock,Condition makecon,Condition concon) {
        this.lock = lock;
        this.makecon = makecon;
        this.concon = concon;
    }

    /**
     * 当前库存数
     */
    public int current = 0;


    /**
     * 总容量
     */
    public int capacity = 20;



    public void add(){
        lock.lock();
        if(current < capacity){
            current = current+1;
            System.out.println("放进去一个，当前库存大小" + current);
            concon.signalAll();
        }else{
            try {
                System.out.println("放满了！等待消耗");
                makecon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
               lock.unlock();
            }

        }

    }


    public void remove(){
        lock.lock();
        if(current > 0){
            current = current-1;
            System.out.println("消耗了一个，当前库存大小" + current);
            makecon.signalAll();
        }else{
            try {
                System.out.println("消费完了！等待生产");
                concon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }


    }



}