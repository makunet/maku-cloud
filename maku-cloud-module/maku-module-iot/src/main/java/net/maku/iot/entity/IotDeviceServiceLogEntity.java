package net.maku.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.mybatis.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * 设备服务日志
 *
 * @author LSF maku_lsf@163.com
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("iot_device_service_log")
public class IotDeviceServiceLogEntity extends BaseEntity {

    /**
     * 设备id
     */
    private Long deviceId;

    /**
     * 服务类型
     */
    private Integer serviceType;

    /**
     * 服务标识id
     */
    private String serviceUid;

    /**
     * 服务数据
     */
    private String servicePayload;

    /**
     * 服务时间
     */
    private LocalDateTime serviceTime;

    /**
     * 租户ID
     */
    private Long tenantId;


}