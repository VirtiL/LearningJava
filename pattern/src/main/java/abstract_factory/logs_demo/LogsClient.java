package abstract_factory.logs_demo;

import abstract_factory.logs_demo.factory.SpecificFactory;
import abstract_factory.logs_demo.factory.OtherFactory;
import abstract_factory.logs_demo.factory.LogsFactory;
import abstract_factory.logs_demo.product.AbstractOtherProduct;
import abstract_factory.logs_demo.product.AbstractSpecifcProduct;

/**
 * @author zhangcq
 * @Description: 客户端
 * @Time: 2019/3/4 14:18
 * @Version 1.0
 */
public class LogsClient {

    public static void main(String[] args) {
        //抽象工厂
        LogsFactory logsFactory;
        //抽象产品1,产品族1
        AbstractOtherProduct abstractProductOne;
        //抽象产品2,产品族2
        AbstractSpecifcProduct abstractProductTwo;
        //其他工厂
        logsFactory = new OtherFactory();
        abstractProductOne = logsFactory.createProductOne();
        abstractProductOne.print();
        abstractProductTwo = logsFactory.createProductTwo();
        abstractProductTwo.print();

        //具体工厂
        logsFactory = new SpecificFactory();
        abstractProductOne = logsFactory.createProductOne();
        abstractProductOne.print();
        abstractProductTwo = logsFactory.createProductTwo();
        abstractProductTwo.print();

    }
}