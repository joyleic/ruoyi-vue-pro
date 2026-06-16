package cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 饲料谷管理 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpFeedPageReqVO extends PageParam {

    @Schema(description = "合同编号", example = "张三")
    private String contractNo;

    @Schema(description = "客户名称", example = "15601691300")
    private String customerName;

    @Schema(description = "车牌号", example = "18818288888")
    private String plateNumber;

    @Schema(description = "入库时间", example = "2025-12-15")
    private LocalDateTime storageTime;

}