package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.framework.common.validation.Telephone;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(description = "管理后台 - ERP 车辆信息新增/修改 Request VO")
@Data
public class ErpVehicleSaveReqVO {

    @Schema(description = "车辆信息编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    private Long id;

    @Schema(description = "车牌号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666666")
    @NotEmpty(message = "车牌号不能为空")
    private String licPlateNumber;

    @Schema(description = "司机姓名", example = "张山")
    private String name;

    @Schema(description = "手机号码", example = "15601691300")
    @Mobile
    private String phone;

    @Schema(description = "身份证号", example = "431103199612063655")
    private String idCard;


    @Schema(description = "备注", example = "你猜")
    private String remark;



}