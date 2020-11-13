package iot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-29 16:14
 */
@Data
public class DeepeixMeetingBind implements Serializable {

    private String meetingId;//会议ID
    private String meetingRoomName;//会议名称
    private String bookingUser;//预订人姓名
    private String bookingCompanyName;//预订人公司名称
    private String bookingMobile;//预订人手机号
    private Long bookingTime;//创建时间
    private Long meetingDate;//会议日期，时间戳精确到毫秒
    private Long beginTime;//会议开始时间，时间戳精确到毫秒
    private Long endTime;//会议结束时间，时间戳精确到毫秒
    private Set<String> attendee;//与会人员ID列表
    private Set<String> deviceList;//门禁设备ID列表

}