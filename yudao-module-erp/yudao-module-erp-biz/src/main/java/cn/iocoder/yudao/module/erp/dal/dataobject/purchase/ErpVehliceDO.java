package cn.iocoder.yudao.module.erp.dal.dataobject.purchase;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * ERP 供应商 DO
 *
 * @author 芋道源码
 */
@TableName("erp_vehicle")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpVehliceDO extends BaseDO {

    /**
     * 供应商编号
     */
    @TableId
    private Long id;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 备注
     */
    private String remark;
    /**
     * 车牌号
     */
    private String licPlateNumber;


    /**
     * 身份证号
     */
    private String idCard;
}