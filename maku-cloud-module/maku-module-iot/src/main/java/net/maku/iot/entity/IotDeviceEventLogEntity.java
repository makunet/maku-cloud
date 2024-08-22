package net.maku.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.mybatis.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * 设备事件日志
 *
 * @author LSF maku_lsf@163.com
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("iot_device_event_log")
public class IotDeviceEventLogEntity extends BaseEntity {

    /**
     * 设备id
     */
    private Long deviceId;

    /**
     * 事件类型
     */
    private Integer eventType;

    /**
     * 事件标识id
     */
    private String eventUid;

    /**
     * 事件数据
     */
    private String eventPayload;

    /**
     * 事件时间
     */
    private LocalDateTime eventTime;

    /**
     * 租户ID
     */
    private Long tenantId;


}