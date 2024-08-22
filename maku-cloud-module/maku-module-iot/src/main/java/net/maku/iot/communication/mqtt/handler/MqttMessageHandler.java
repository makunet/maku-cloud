package net.maku.iot.communication.mqtt.handler;

/**
 * MQTT订阅消息处理接口
 *
 * @author LSF maku_lsf@163.com
 */
public interface MqttMessageHandler {
    /**
     * 是否支持处理指定的topic
     *
     * @param topic
     * @return
     */
    boolean supports(String topic);

    /**
     * mqtt消息处理接口
     *
     * @param topic
     * @param message
     */
    void handle(String topic, String message);
}