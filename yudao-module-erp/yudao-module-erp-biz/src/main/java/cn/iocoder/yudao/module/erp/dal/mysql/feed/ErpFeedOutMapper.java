package cn.iocoder.yudao.module.erp.dal.mysql.feed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutPageReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedOutbound;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedStorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 供应商 Mapper
 *
 */
@Mapper
public interface ErpFeedOutMapper extends BaseMapperX<ErpFeedOutbound> {

    default PageResult<ErpFeedOutbound> selectPage(ErpFeedOutPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpFeedOutbound>()
                .likeIfPresent(ErpFeedOutbound::getContractNo, reqVO.getContractNo())
                .likeIfPresent(ErpFeedOutbound::getCustomerName, reqVO.getCustomerName())
                .likeIfPresent(ErpFeedOutbound::getIsPaid, reqVO.getIsPad())
                .orderByDesc(ErpFeedOutbound::getId));
    }

    default List<ErpFeedOutbound> selectListByStatus() {
        return selectList();
    }

}