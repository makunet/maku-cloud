package net.maku.iot.communication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * tcp通讯数据包
 *
 * @author LSF maku_lsf@163.com
 */
@Data
@Schema(description = "tcp通讯数据包装类")
public class TcpMsgDTO {
    private String topic;
    private Object msg;
}
