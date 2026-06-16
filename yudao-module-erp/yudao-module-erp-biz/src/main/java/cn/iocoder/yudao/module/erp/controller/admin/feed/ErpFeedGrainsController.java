package cn.iocoder.yudao.module.erp.controller.admin.feed;


import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedStorage;
import cn.iocoder.yudao.module.erp.service.feed.ErpFeedEnterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 饲料谷管理")
@RestController
@RequestMapping("/erp/feed/enter")
@Validated
public class ErpFeedGrainsController {

    @Resource
    private ErpFeedEnterService erpFeedEnterService;

    @PostMapping("/create")
    @Operation(summary = "饲料谷入库")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:create')")
    public CommonResult<Long> createFeed(@Valid @RequestBody ErpFeedSaveReqVO createReqVO) {
        return success(erpFeedEnterService.createFeed(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改饲料谷信息")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:update')")
    public CommonResult<Boolean> updateFeed(@Valid @RequestBody ErpFeedSaveReqVO updateReqVO) {
        erpFeedEnterService.updateFeed(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除饲料谷信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:delete')")
    public CommonResult<Boolean> deleteFeed(@RequestParam("id") Long id) {
        erpFeedEnterService.deleteFeed(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得饲料谷信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:query')")
    public CommonResult<ErpFeedRespVO> getFeedEnter(@RequestParam("id") Long id) {
        ErpFeedStorage feed = erpFeedEnterService.getFeedEnter(id);
        return success(BeanUtils.toBean(feed, ErpFeedRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得饲料谷信息分页")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:query')")
    public CommonResult<PageResult<ErpFeedRespVO>> getVehiclePage(@Valid ErpFeedPageReqVO pageReqVO) {
        PageResult<ErpFeedStorage> pageResult = erpFeedEnterService.getFeedPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ErpFeedRespVO.class));
    }
}
