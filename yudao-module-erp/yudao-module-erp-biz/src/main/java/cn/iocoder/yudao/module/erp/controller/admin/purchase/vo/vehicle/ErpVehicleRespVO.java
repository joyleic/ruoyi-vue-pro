package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 车辆信息管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpVehicleRespVO {

    @Schema(description = "车辆信息编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    @ExcelProperty("车辆信息编号")
    private Long id;

    @Schema(description = "司机名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("司机名称")
    private String name;

    @Schema(description = "手机号码", example = "15601691300")
    @ExcelProperty("手机号码")
    private String phone;

    @Schema(description = "车牌号", example = "车牌号")
    @ExcelProperty("车牌号")
    private String licPlateNumber;

    @Schema(description = "备注", example = "你猜")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "身份证号", example = "431103199612063655")
    @ExcelProperty("身份证号")
    private String idCard;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}