package cn.iocoder.yudao.module.erp.dal.mysql.purchase;


import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.pay.PurchasePayVo;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpPayOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * ERP 采购入库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ErpPurchasePayMapper extends BaseMapperX<ErpPayOrderDO> {

    default PageResult<ErpPayOrderDO> selectPage(PurchasePayVo reqVO) {
        return selectPage(reqVO,new LambdaQueryWrapperX<ErpPayOrderDO>()
                .likeIfPresent(ErpPayOrderDO::getOrderNo,reqVO.getOrderNo())
                .orderByDesc(ErpPayOrderDO::getId));
    }

    PageResult<ErpPayOrderDO> selectPage(PurchasePayVo reqVO, LambdaQueryWrapperX<ErpPayOrderDO> orderByDesc);



}