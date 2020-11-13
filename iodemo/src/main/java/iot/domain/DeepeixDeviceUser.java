package iot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-29 16:08
 */
@Data
public class DeepeixDeviceUser implements Serializable {

    private String deviceId;//设备ID

    private List<String> userList;//用户ID数组


}