package cn.iocoder.yudao.module.erp.controller.admin.feed;


import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedSaveReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedOutbound;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedStorage;
import cn.iocoder.yudao.module.erp.service.feed.ErpFeedEnterService;
import cn.iocoder.yudao.module.erp.service.feed.ErpFeedOutEnterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 饲料谷出库管理")
@RestController
@RequestMapping("/erp/feed/out")
@Validated
public class ErpFeedOutController {

    @Resource
    private ErpFeedOutEnterService erpFeedOutEnterService;

    @PostMapping("/create")
    @Operation(summary = "饲料谷出库")
    @PreAuthorize("@ss.hasPermission('erp:feed:out:create')")
    public CommonResult<Long> createOutFeed(@Valid @RequestBody ErpFeedOutSaveReqVO createReqVO) {
        return success(erpFeedOutEnterService.createOutFeed(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改饲料谷信息")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:update')")
    public CommonResult<Boolean> updateFeed(@Valid @RequestBody ErpFeedOutSaveReqVO updateReqVO) {
        erpFeedOutEnterService.updateOutFeed(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除饲料谷信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:delete')")
    public CommonResult<Boolean> deleteFeed(@RequestParam("id") Long id) {
        erpFeedOutEnterService.deleteOutFeed(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得饲料谷信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:query')")
    public CommonResult<ErpFeedOutRespVO> getFeedEnter(@RequestParam("id") Long id) {
        ErpFeedOutbound feed = erpFeedOutEnterService.getFeedOut(id);
        return success(BeanUtils.toBean(feed, ErpFeedOutRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得饲料谷信息分页")
    @PreAuthorize("@ss.hasPermission('erp:feed:enter:query')")
    public CommonResult<PageResult<ErpFeedOutRespVO>> getVehiclePage(@Valid ErpFeedOutPageReqVO pageReqVO) {
        PageResult<ErpFeedOutbound> pageResult = erpFeedOutEnterService.getFeedOutPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ErpFeedOutRespVO.class));
    }
}
