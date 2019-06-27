package abstract_factory.logs_demo.factory;

import abstract_factory.logs_demo.product.AbstractOtherProduct;
import abstract_factory.logs_demo.product.AbstractSpecifcProduct;
import abstract_factory.logs_demo.product.other_groups.OtherProductOne;
import abstract_factory.logs_demo.product.other_groups.OtherProductTwo;

/**
 * @author zhangcq
 * @Description: 其他工厂
 * @Time: 2019/3/8 13:36
 * @Version 1.0
 */
public class OtherFactory implements LogsFactory {

    @Override
    public AbstractOtherProduct createProductOne() {
        return new OtherProductOne();
    }

    @Override
    public AbstractSpecifcProduct createProductTwo() {
        return new OtherProductTwo();
    }
}