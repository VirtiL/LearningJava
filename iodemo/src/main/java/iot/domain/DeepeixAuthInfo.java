package iot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-10-12 17:09
 */
@Data
public class DeepeixAuthInfo implements Serializable {

    private String userId;//会员id
    private Integer id;//记录id
    private String deviceId;//设备id


}