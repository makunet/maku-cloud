package net.maku.system.api;

import lombok.AllArgsConstructor;
import net.maku.api.module.system.StorageApi;
import net.maku.api.module.system.dto.StorageDTO;
import net.maku.framework.common.utils.Result;
import net.maku.storage.service.StorageService;
import org.apache.commons.io.FilenameUtils;
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
public class StorageApiImpl implements StorageApi {
    private final StorageService storageService;

    @Override
    public Result<StorageDTO> upload(MultipartFile file) throws IOException {
        // 是否为空
        if (file.isEmpty()) {
            return Result.error("文件不能为空");
        }

        // 上传文件
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String url = storageService.uploadSuffix(file.getBytes(), extension);

        // 上传信息
        StorageDTO storage = new StorageDTO();
        storage.setUrl(url);
        storage.setSize(file.getSize());

        return Result.ok(storage);
    }
}
