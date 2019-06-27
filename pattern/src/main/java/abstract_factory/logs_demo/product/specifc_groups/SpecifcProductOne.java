package abstract_factory.logs_demo.product.specifc_groups;

import abstract_factory.logs_demo.product.AbstractOtherProduct;

/**
 * @Description: 具体产品1
 * @author: zhangcq
 * @Time: 2019/3/15 17:29
 * @Version 1.0
 */
public class SpecifcProductOne implements AbstractOtherProduct {
    @Override
    public void print() {
        System.out.println("具体产品1");
    }
}