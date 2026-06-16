package cn.iocoder.yudao.module.erp.dal.mysql.feed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehiclePageReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedStorage;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 供应商 Mapper
 *
 */
@Mapper
public interface ErpFeedEnterMapper extends BaseMapperX<ErpFeedStorage> {

    default PageResult<ErpFeedStorage> selectPage(ErpFeedPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpFeedStorage>()
                .likeIfPresent(ErpFeedStorage::getContractNo, reqVO.getContractNo())
                .likeIfPresent(ErpFeedStorage::getCustomerName, reqVO.getCustomerName())
                .likeIfPresent(ErpFeedStorage::getPlateNumber, reqVO.getPlateNumber())
                .orderByDesc(ErpFeedStorage::getId));
    }

    default List<ErpFeedStorage> selectListByStatus() {
        return selectList();
    }

}