package iot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-29 14:57
 */
@Data
public class DeepeixUserInfo implements Serializable {

    private Integer id;//记录id
    private String userId;//人员ID
    private String name;//人员姓名
    private String mobile;//手机号
    private String companyName;//人员所属公司名称
    private String imgId;//人脸识别图片ID，由图片上传接口返回
    private Long beginTime;//门禁权限开始时间，时间戳精确到毫秒
    private Long endTime;//门禁权限结束时间，时间戳精确到毫秒
    private Set<String> deviceList;//门禁设备ID列表，字符串数组

}