package iot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 访客随行者信息
 * @Author: zhangcq
 * @Time: 2020-9-29 14:59
 */
@Data
public class DeepeixEntourageInfo implements Serializable {

    private String visitorId;//随行人员ID
    private String visitorName;//随行人员姓名
    private String visitorMobile;//随行人员手机号
    private String visitorImgId;//随行人员人脸识别图片ID，由图片上传接口返回
}