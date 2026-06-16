package cn.iocoder.yudao.module.erp.service.feed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedOutbound;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

/**
 * ERP 飼料谷管理 Service 接口
 *
 * @author
 */
public interface ErpFeedOutEnterService {

    /**
     * 饲料谷入库
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createOutFeed(@Valid ErpFeedOutSaveReqVO createReqVO);

    /**
     * 更新饲料谷入库信息
     *
     * @param updateReqVO 更新信息
     */
    void updateOutFeed(@Valid ErpFeedOutSaveReqVO updateReqVO);

    /**
     * 删除饲料谷入库信息
     *
     * @param id 编号
     */
    void deleteOutFeed(Long id);

    /**
     * 获得饲料谷信息
     *
     * @param id 编号
     * @return 供应商
     */
    ErpFeedOutbound getFeedOut(Long id);

    /**
     * 校验饲料谷信息
     *
     * @param id 编号
     * @return 车辆信息
     */
    ErpFeedOutbound validateFeedOut(Long id);

    /**
     * 获得饲料谷信息列表ErpFeedOutMapper
     *
     * @param ids 编号列表
     * @return 供应商列表
     */
    List<ErpFeedOutbound> getFeedOutList(Collection<Long> ids);

    /**
     * 获得饲料谷信息 Map
     *
     * @param ids 编号列表
     * @return 供应商 Map
     */
    default Map<Long, ErpFeedOutbound> getFeedOutMap(Collection<Long> ids) {
        return convertMap(getFeedOutList(ids), ErpFeedOutbound::getId);
    }

    /**
     * 获得饲料谷信息分页
     *
     * @param pageReqVO 分页查询
     * @return 供应商分页
     */
    PageResult<ErpFeedOutbound> getFeedOutPage(ErpFeedOutPageReqVO pageReqVO);

    /**
     * 获得指定状态的供应商列表
     *
     * @return 供应商列表
     */
    List<ErpFeedOutbound> getSupplierList();


}