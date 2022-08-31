package net.maku.api.module.message;

import net.maku.api.ServerNames;
import net.maku.framework.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 短信服务API
 *
 * @author 阿沐 babamu@126.com
 */
@FeignClient(name = ServerNames.MESSAGE_SERVER_NAME)
public interface SmsApi {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 参数
     * @return 是否发送成功
     */
    @PostMapping(value = "api/message/sms/send")
    Result<Boolean> send(@RequestParam("mobile") String mobile, @RequestParam("params") Map<String, String> params);

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param key    参数KEY
     * @param value  参数Value
     * @return 是否发送成功
     */
    @PostMapping(value = "api/message/sms/sendCode")
    Result<Boolean> sendCode(@RequestParam("mobile") String mobile, @RequestParam("key") String key, @RequestParam("value") String value);

    /**
     * 效验短信验证码
     *
     * @param mobile 手机号
     * @param code   验证码
     * @return 是否效验成功
     */
    @PostMapping(value = "api/message/sms/verifyCode")
    Result<Boolean> verifyCode(@RequestParam("mobile") String mobile, @RequestParam("code") String code);
}
