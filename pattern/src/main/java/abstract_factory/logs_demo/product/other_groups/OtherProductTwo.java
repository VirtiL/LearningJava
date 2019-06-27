package abstract_factory.logs_demo.product.other_groups;

import abstract_factory.logs_demo.product.AbstractSpecifcProduct;

/**
 * @Description: 其他产品2
 * @author: zhangcq
 * @Time: 2019/3/15 17:29
 * @Version 1.0
 */
public class OtherProductTwo implements AbstractSpecifcProduct {
    @Override
    public void print() {
        System.out.println("其他产品2");
    }
}