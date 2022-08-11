package net.maku.module.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.mybatis.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 新增模块演示
*
* @author 阿沐 babamu@126.com
*/
@RestController
@Tag(name="新增模块演示")
@AllArgsConstructor
public class TestController {

    @GetMapping("test")
    public Result<String> test(){

        return Result.ok("新增模块演示。。。");
    }

}