package net.maku.iot.communication.mqtt.handler;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.maku.framework.common.utils.JsonUtils;
import net.maku.iot.communication.dto.DevicePropertyDTO;
import net.maku.iot.communication.mqtt.factory.DevicePropertyChangeHandlerFactory;
import net.maku.iot.enums.DeviceTopicEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 设备属性上报消息处理器
 *
 * @author LSF maku_lsf@163.com
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DevicePropertyMqttMessageHandler implements MqttMessageHandler {

    private final DevicePropertyChangeHandlerFactory statusChangeHandlerFactory;

    @Override
    public boolean supports(String topic) {
        return DeviceTopicEnum.startsWith(topic, DeviceTopicEnum.PROPERTY.getTopic());
    }

    @Override
    public void handle(String topic, String message) {
        DevicePropertyDTO devicePropertyDTO = parseStatusMessage(topic, message);
        Optional.ofNullable(devicePropertyDTO)
                .ifPresent(deviceProperty -> statusChangeHandlerFactory.getHandlers()
                        .forEach(h -> h.handle(topic, deviceProperty)));
    }

    private DevicePropertyDTO parseStatusMessage(String topic, String message) {
        try {
            return JsonUtils.parseObject(message, DevicePropertyDTO.class);
        } catch (Exception e) {
            log.error(StrUtil.format("将主题'{}'的消息解析为设备运行状态对象失败", topic), e);
            return null;
        }
    }


}
