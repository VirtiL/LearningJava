package iot;

import lombok.extern.slf4j.Slf4j;

/**
 * @author description: 服务地址配置样例
 * @version 2.0
 */
@Slf4j
public class CommonConfigConstant {

    //------------------- IOT相关接口---------------------------------------

    //人脸识别图片上传  FormData格式参数
    public static String deepeixFileUpload() {
        return "/api/saas/deepeix/file/upload";
    }

    // 保存员工人脸信息(普通员工、访客）
    public static String deepeixUserSave() {
        return "/api/saas/deepeix/user/add";
    }

    public static String deepeixUserEdit() {
        return "/api/saas/deepeix/user/edit";
    }

    //删除人脸信息
    public static String deepeixUserDelete() {
        return "/api/saas/deepeix/user/delete";
    }

    //保存访客信息
    public static String deepeixVisitorSave() {
        return "/api/saas/deepeix/visitor/save";
    }

    //门禁列表查询
    public static String deepeixDeviceList() {
        return "/api/saas/deepeix/device/list";
    }

    // 根据设备ID查询绑定人员
    public static String deepeixDeviceBindList() {
        return "/api/saas/deepeix/device/bind/list";
    }

    // 根据设备ID修改绑定人员
    public static String deepeixDeviceBindSave() {
        return "/api/saas/deepeix/device/bind/save";
    }

    // 会议预约
    public static String deepeixMeetingBind() {
        return "/api/saas/deepeix/meeting/bind";
    }

    // 取消会议
    public static String deepeixMeetingCancel() {
        return "/api/saas/deepeix/meeting/cancel";
    }

    //删除设备
    public static String removeDevice() {
        return "/api/saas/deepeix/device/unbindAll";
    }

    //替换设备
    public static String replaceDevice() {
        return "/api/saas/deepeix/device/replace";
    }

    //批量增减某个用户的设备权限
    public static String changeDeviceAuth() {
        return "/api/saas/deepeix/user/bind/change";
    }

    //------------------- IOT相关接口结束---------------------------------------

}
