package cn.iocoder.yudao.module.erp.dal.mysql.purchase;


import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in.ErpPurchaseInPageReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpPurchaseInDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 采购入库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ErpPurchaseInMapper extends BaseMapperX<ErpPurchaseInDO> {

    default PageResult<ErpPurchaseInDO> selectPage(ErpPurchaseInPageReqVO reqVO) {
        return selectPage(reqVO,new LambdaQueryWrapperX<ErpPurchaseInDO>()
                .likeIfPresent(ErpPurchaseInDO::getSellerName, reqVO.getSellerName())
                .likeIfPresent(ErpPurchaseInDO::getGrainType, reqVO.getGrainType())
                .likeIfPresent(ErpPurchaseInDO::getIsFinish, reqVO.getIsFinish())
                .betweenIfPresent(ErpPurchaseInDO::getPurchaseTime, reqVO.getInTime())
                .orderByDesc(ErpPurchaseInDO::getId));
    }

    default int updateByIdAndStatus(Long id, Integer status, ErpPurchaseInDO updateObj) {
        return 0;
    }

    default ErpPurchaseInDO selectByNo(String no) {
        return null;
    }

    default List<ErpPurchaseInDO> selectListByOrderId(Long orderId) {
        return null;
    }

}