package net.maku.api.module.system;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import net.maku.api.ServerNames;
import net.maku.api.module.system.dto.StorageDTO;
import net.maku.framework.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传
 *
 *  @author 阿沐 babamu@126.com
 */
@FeignClient(name = ServerNames.SYSTEM_SERVER_NAME)
public interface StorageApi {

    /**
     * 文件上传
     */
    @PostMapping(value = "api/storage/upload", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<StorageDTO> upload(@RequestPart("file") MultipartFile file) throws IOException;

    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
