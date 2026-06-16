package cn.iocoder.yudao.module.erp.service.feed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedStorage;

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
public interface ErpFeedEnterService {

    /**
     * 饲料谷入库
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeed(@Valid ErpFeedSaveReqVO createReqVO);

    /**
     * 更新饲料谷入库信息
     *
     * @param updateReqVO 更新信息
     */
    void updateFeed(@Valid ErpFeedSaveReqVO updateReqVO);

    /**
     * 删除饲料谷入库信息
     *
     * @param id 编号
     */
    void deleteFeed(Long id);

    /**
     * 获得饲料谷信息
     *
     * @param id 编号
     * @return 供应商
     */
    ErpFeedStorage getFeedEnter(Long id);

    /**
     * 校验饲料谷信息
     *
     * @param id 编号
     * @return 车辆信息
     */
    ErpFeedStorage validateFeedEnter(Long id);

    /**
     * 获得饲料谷信息列表
     *
     * @param ids 编号列表
     * @return 供应商列表
     */
    List<ErpFeedStorage> getFeedEnterList(Collection<Long> ids);

    /**
     * 获得饲料谷信息 Map
     *
     * @param ids 编号列表
     * @return 供应商 Map
     */
    default Map<Long, ErpFeedStorage> getFeedEnterMap(Collection<Long> ids) {
        return convertMap(getFeedEnterList(ids), ErpFeedStorage::getId);
    }

    /**
     * 获得饲料谷信息分页
     *
     * @param pageReqVO 分页查询
     * @return 供应商分页
     */
    PageResult<ErpFeedStorage> getFeedPage(ErpFeedPageReqVO pageReqVO);

    /**
     * 获得指定状态的供应商列表
     *
     * @return 供应商列表
     */
    List<ErpFeedStorage> getSupplierList();


}