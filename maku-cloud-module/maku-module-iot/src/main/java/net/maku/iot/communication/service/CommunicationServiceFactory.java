package net.maku.iot.communication.service;

import lombok.AllArgsConstructor;
import net.maku.framework.common.exception.ServerException;
import org.springframework.stereotype.Service;

/**
 * 设备协议服务工厂
 *
 * @author LSF maku_lsf@163.com
 */
@Service
@AllArgsConstructor
public class CommunicationServiceFactory {

    private final MQTTService mqttService;
    private final TCPService tcpService;

    public BaseCommunication getProtocol(String protocolType) {
        if (protocolType == null) {
            new ServerException("协议不存在！");
        }
        switch (protocolType) {
            case "MQTT":
                return mqttService;
            case "TCP":
                return tcpService;
//            case "Modbus":
//                return tcpService;
            default:
                return null;
        }
    }


}
