package iot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Description: 访客信息
 * @Author: zhangcq
 * @Time: 2020-9-29 14:57
 */
@Data
public class DeepeixVisitorInfo implements Serializable {

    private String recordId;//访客记录ID
    private String visitPlace;//到访地点
    private String visitorId;//访客ID
    private String visitorName;//访客姓名
    private String visitorMobile;//访客手机号
    private String visitorImgId;//访客人脸识别图片ID，由图片上传接口返回
    private Long visitTime;//到访时间，时间戳精确到毫秒
    private Long beginTime;//门禁权限开始时间，时间戳精确到毫秒
    private Long endTime;//门禁权限结束时间，时间戳精确到毫秒
    private Set<String> deviceList;//门禁设备ID列表，随行人员门禁权限与访客一致
    private Boolean isEntourageExist;//是否存在随行人员
    private List<DeepeixEntourageInfo> entourageList;//随行人员，isEntourageExist为true必填，对象实体数组


    public Boolean getEntourageExist() {
        return isEntourageExist;
    }

    public void setEntourageExist(Boolean entourageExist) {
        isEntourageExist = entourageExist;
    }
}