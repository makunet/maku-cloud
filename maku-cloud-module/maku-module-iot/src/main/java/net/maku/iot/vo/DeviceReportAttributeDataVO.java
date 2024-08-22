package net.maku.iot.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 设备上报属性数据
 *
 * @author LSF maku_lsf@163.com
 */
@Data
@Schema(description = "设备上报属性数据VO")
public class DeviceReportAttributeDataVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备ID")
    private Long deviceId;

    @Schema(description = "设备属性类型")
    private String propertyType;

    @Schema(description = "属性数据")
    private String payload;

}
