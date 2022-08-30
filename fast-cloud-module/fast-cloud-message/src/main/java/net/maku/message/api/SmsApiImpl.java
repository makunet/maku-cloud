package net.maku.message.api;

import lombok.AllArgsConstructor;
import net.maku.api.module.message.SmsApi;
import net.maku.framework.common.utils.Result;
import net.maku.message.cache.SmsSendCache;
import net.maku.message.sms.service.SmsService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信服务API
 *
 *  @author 阿沐 babamu@126.com
 */
@RestController
@AllArgsConstructor
public class SmsApiImpl implements SmsApi {
    private final SmsService smsService;
    private final SmsSendCache smsSendCache;

    @Override
    public Result<Boolean> send(String mobile, Map<String, String> params) {
        boolean flag = smsService.send(mobile, params);
        return Result.ok(flag);
    }

    @Override
    public Result<Boolean> sendCode(String mobile, String key, String value) {
        // 短信参数
        Map<String, String> params = new HashMap<>();
        params.put(key, value);

        // 发送短信
        boolean flag = smsService.send(mobile, params);
        if (flag) {
            smsSendCache.saveCode(mobile, value);
        }
        return Result.ok(flag);
    }

    @Override
    public Result<Boolean> verifyCode(String mobile, String code) {
        boolean flag = false;

        String value = smsSendCache.getCode(mobile);
        if (value != null) {
            // 删除短信验证码
            smsSendCache.deleteCode(mobile);

            // 效验
            flag = value.equalsIgnoreCase(code);
        }

        return Result.ok(flag);
    }
}
