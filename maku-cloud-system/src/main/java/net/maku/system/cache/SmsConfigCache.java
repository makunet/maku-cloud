package net.maku.system.cache;

import lombok.AllArgsConstructor;
import net.maku.framework.common.cache.RedisCache;
import net.maku.sms.config.SmsConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信平台 Cache
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SmsConfigCache {
    private final RedisCache redisCache;

    /**
     * 短信平台轮询KEY
     */
    private final String SMS_ROUND_KEY = "sys:sms:round";
    private final String SMS_ROUND_CODE_KEY = "sys:sms:round:code";

    /**
     * 短信平台列表KEY
     */
    private final String SMS_PLATFORM_KEY = "sys:sms:platform";

    /**
     * 获取短信轮询值
     */
    public Long getRoundValue() {
        return redisCache.increment(SMS_ROUND_KEY);
    }

    /**
     * 获取短信编码轮询值
     */
    public Long getRoundCodeValue() {
        return redisCache.increment(SMS_ROUND_CODE_KEY);
    }

    public List<SmsConfig> list() {
        return (List<SmsConfig>) redisCache.get(SMS_PLATFORM_KEY);
    }

    public void save(List<SmsConfig> list) {
        redisCache.set(SMS_PLATFORM_KEY, list);
    }

    public void delete() {
        redisCache.delete(SMS_PLATFORM_KEY);
    }
}
