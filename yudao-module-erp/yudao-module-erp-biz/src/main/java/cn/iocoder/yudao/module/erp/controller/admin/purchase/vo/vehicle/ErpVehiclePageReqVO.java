package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - ERP 车辆信息管理 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpVehiclePageReqVO extends PageParam {

    @Schema(description = "司机姓名", example = "张三")
    private String name;

    @Schema(description = "手机号码", example = "15601691300")
    private String phone;

    @Schema(description = "车牌号", example = "18818288888")
    private String licPlateNumber;

    @Schema(description = "身份证号", example = "431103199612063655")
    private String idCard;

}