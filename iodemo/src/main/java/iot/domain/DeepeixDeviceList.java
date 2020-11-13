package iot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-29 15:08
 */
@Data
public class DeepeixDeviceList implements Serializable {

    private String deviceId;//设备ID
    private String deviceName;//设备名称
    private Integer onLineStatus;//设备状态，-1所有，0离线，1在线
    private String place;//设备安装地点
    private String city;//城市
    private String building;//所在大厦
    private Integer deviceTypeNum;//设备类型 0门禁
    private String deviceType;//设备类型中文描述
}