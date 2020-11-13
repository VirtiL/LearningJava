package iot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-29 16:08
 */
@Data
public class DeepeixDeleteUser implements Serializable {

    private String userId;//用户id

    private Integer id;//合同记录id


}