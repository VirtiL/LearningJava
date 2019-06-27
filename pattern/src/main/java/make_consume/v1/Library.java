package make_consume.v1;

/**
 * @Description: 库房
 * @Time: 2019/2/11 16:26
 * @Version 1.0
 */
public class Library {

    /**
     * 当前库存数
     */
    public int current = 0;


    /**
     * 总容量
     */
    public int capacity = 20;



    public synchronized void add(){
        if(current < capacity){
            current = current+1;
            System.out.println("放进去一个，当前库存大小" + current);
            notifyAll();
        }else{
            try {
                System.out.println("放满了！等待消耗");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public synchronized void remove(){
        if(current > 0){
            current = current-1;
            System.out.println("消耗了一个，当前库存大小" + current);
            notifyAll();
        }else{
            try {
                System.out.println("消费完了！等待生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}