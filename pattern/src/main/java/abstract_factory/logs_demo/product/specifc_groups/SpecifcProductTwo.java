package abstract_factory.logs_demo.product.specifc_groups;

import abstract_factory.logs_demo.product.AbstractSpecifcProduct;

/**
 * @Description: 具体产品2
 * @author: zhangcq
 * @Time: 2019/3/15 17:29
 * @Version 1.0
 */
public class SpecifcProductTwo implements AbstractSpecifcProduct {
    @Override
    public void print() {
        System.out.println("具体产品2");
    }
}