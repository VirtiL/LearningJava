package abstract_factory.logs_demo.factory;

import abstract_factory.logs_demo.product.AbstractOtherProduct;
import abstract_factory.logs_demo.product.AbstractSpecifcProduct;
import abstract_factory.logs_demo.product.specifc_groups.SpecifcProductOne;
import abstract_factory.logs_demo.product.specifc_groups.SpecifcProductTwo;

/**
 * @author zhangcq
 * @Description: 具体工厂
 * @Time: 2019/3/8 13:36
 * @Version 1.0
 */
public class SpecificFactory implements LogsFactory {

    @Override
    public AbstractOtherProduct createProductOne() {
        return new SpecifcProductOne();
    }

    @Override
    public AbstractSpecifcProduct createProductTwo() {
        return new SpecifcProductTwo();
    }
}