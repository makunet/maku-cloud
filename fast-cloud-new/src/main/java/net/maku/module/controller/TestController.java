package net.maku.module.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.api.module.system.StorageApi;
import net.maku.api.module.system.dto.StorageDTO;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
* 新增模块演示
*
* @author 阿沐 babamu@126.com
*/
@RestController
@Tag(name="新增模块演示")
@AllArgsConstructor
public class TestController {
    private final StorageApi storageApi;

    @GetMapping("test")
    public Result<String> test(){

        return Result.ok("新增模块演示。。。");
    }

    @PostMapping("upload")
    public Result<StorageDTO> upload(@RequestParam("file") MultipartFile file) throws Exception {

        return storageApi.upload(file);
    }

}