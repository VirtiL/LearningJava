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
public class DeepeixChangeDeviceAuth implements Serializable {

    private List<DeepeixAuthInfo> addAuthList;//需新增授权的列表

    private List<DeepeixAuthInfo> deleteAuthList;//需删除授权的列表


}