package net.maku.iot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.iot.convert.IotDeviceEventLogConvert;
import net.maku.iot.entity.IotDeviceEventLogEntity;
import net.maku.iot.query.IotDeviceEventLogQuery;
import net.maku.iot.service.IotDeviceEventLogService;
import net.maku.iot.vo.IotDeviceEventLogVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备事件日志
 *
 * @author LSF maku_lsf@163.com
 */
@RestController
@RequestMapping("iot/device_event_log")
@Tag(name = "设备事件日志")
@AllArgsConstructor
public class IotDeviceEventLogController {
    private final IotDeviceEventLogService iotDeviceEventLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('iot:device_event_log:page')")
    public Result<PageResult<IotDeviceEventLogVO>> page(@ParameterObject @Valid IotDeviceEventLogQuery query) {
        PageResult<IotDeviceEventLogVO> page = iotDeviceEventLogService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('iot:device_event_log:info')")
    public Result<IotDeviceEventLogVO> get(@PathVariable("id") Long id) {
        IotDeviceEventLogEntity entity = iotDeviceEventLogService.getById(id);

        return Result.ok(IotDeviceEventLogConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('iot:device_event_log:save')")
    public Result<String> save(@RequestBody IotDeviceEventLogVO vo) {
        iotDeviceEventLogService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('iot:device_event_log:update')")
    public Result<String> update(@RequestBody @Valid IotDeviceEventLogVO vo) {
        iotDeviceEventLogService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('iot:device_event_log:delete')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        iotDeviceEventLogService.delete(idList);

        return Result.ok();
    }
}