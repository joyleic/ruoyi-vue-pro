package cn.iocoder.yudao.module.erp.controller.admin.purchase;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.supplier.ErpSupplierRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehiclePageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehicleRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehicleSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;
import cn.iocoder.yudao.module.erp.service.purchase.ErpVehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "管理后台 - 产后服务中心车辆管理")
@RestController
@RequestMapping("/erp/vehicle")
@Validated
public class ErpVehicleController {

    @Resource
    private ErpVehicleService vehicleService;

    @PostMapping("/create")
    @Operation(summary = "创建车辆信息")
    @PreAuthorize("@ss.hasPermission('erp:supplier:create')")
    public CommonResult<Long> createVehicle(@Valid @RequestBody ErpVehicleSaveReqVO createReqVO) {
        return success(vehicleService.createVehlice(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新车辆信息")
    @PreAuthorize("@ss.hasPermission('erp:supplier:update')")
    public CommonResult<Boolean> updateVehlice(@Valid @RequestBody ErpVehicleSaveReqVO updateReqVO) {
        vehicleService.updateVehlice(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除车辆信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('erp:supplier:delete')")
    public CommonResult<Boolean> deleteVehlice(@RequestParam("id") Long id) {
        vehicleService.deleteVehlice(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得车辆信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:vehlice:query')")
    public CommonResult<ErpVehicleRespVO> getSupplier(@RequestParam("id") Long id) {
        ErpVehliceDO vehlice = vehicleService.getVehicle(id);
        return success(BeanUtils.toBean(vehlice, ErpVehicleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得车辆信息分页")
    @PreAuthorize("@ss.hasPermission('erp:vehlice:query')")
    public CommonResult<PageResult<ErpVehicleRespVO>> getVehiclePage(@Valid ErpVehiclePageReqVO pageReqVO) {
        PageResult<ErpVehliceDO> pageResult = vehicleService.getVehlicePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ErpVehicleRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "获得车辆信息精简列表")
    public CommonResult<List<ErpVehicleRespVO>> getSupplierSimpleList() {
        List<ErpVehliceDO> list = vehicleService.getSupplierList();
        return success(convertList(list, supplier -> new ErpVehicleRespVO().setId(supplier.getId()).setLicPlateNumber(supplier.getLicPlateNumber())));
    }

 /*   @GetMapping("/export-excel")
    @Operation(summary = "导出供应商 Excel")
    @PreAuthorize("@ss.hasPermission('erp:supplier:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSupplierExcel(@Valid ErpSupplierPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpSupplierDO> list = supplierService.getSupplierPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "供应商.xls", "数据", ErpSupplierRespVO.class,
                        BeanUtils.toBean(list, ErpSupplierRespVO.class));
    }*/

}