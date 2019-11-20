package make_consume.v1;

/**
 * @Description: No Description
 * @Time: 2019/2/11 16:29
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {

        Library library = new Library();
        Make make = new Make(library);
//        Make make2 = new Make(library);
//        Make make3 = new Make(library);
        Consume consume = new Consume(library);
//        Consume consume2 = new Consume(library);
//        Consume consume3 = new Consume(library);

        make.start();
//        make2.start();
//        make3.start();

        consume.start();
//        consume2.start();
//        consume3.start();


    }

}