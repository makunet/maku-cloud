package net.maku.system.feign;

import lombok.AllArgsConstructor;
import net.maku.api.feign.system.StorageFeign;
import net.maku.api.feign.system.dto.StorageDTO;
import net.maku.storage.service.StorageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传
 *
 *  @author 阿沐 babamu@126.com
 */
@RestController
@AllArgsConstructor
public class StorageFeignImpl implements StorageFeign {
    private final StorageService storageService;

    @Override
    public StorageDTO upload(MultipartFile file) throws IOException {
        // 是否为空
        if (file.isEmpty()) {
            return null;
        }

        // 上传路径
        String path = storageService.getPath(file.getOriginalFilename());
        // 上传文件
        String url = storageService.upload(file.getBytes(), path);

        // 上传信息
        StorageDTO storage = new StorageDTO();
        storage.setUrl(url);
        storage.setSize(file.getSize());

        return storage;
    }
}
