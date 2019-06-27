package abstract_factory.logs_demo.factory;

import abstract_factory.logs_demo.product.AbstractOtherProduct;
import abstract_factory.logs_demo.product.AbstractSpecifcProduct;

/**
 * @author zhangcq
 * @Description: 抽象工厂
 * @Time: 2019/3/4 14:04
 * @Version 1.0
 */
public interface LogsFactory {

    public AbstractOtherProduct createProductOne();
    public AbstractSpecifcProduct createProductTwo();

}