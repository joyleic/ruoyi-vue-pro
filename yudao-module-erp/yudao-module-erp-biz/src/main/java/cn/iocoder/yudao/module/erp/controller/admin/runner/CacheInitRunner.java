package cn.iocoder.yudao.module.erp.controller.admin.runner;

import cn.iocoder.yudao.framework.tenant.core.context.TenantContextHolder;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpSupplierDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;
import cn.iocoder.yudao.module.erp.dal.mysql.purchase.ErpSupplierMapper;
import cn.iocoder.yudao.module.erp.dal.mysql.purchase.ErpVehicleMapper;
import cn.iocoder.yudao.module.erp.dal.redis.GlobalCacheUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CacheInitRunner implements ApplicationRunner {
    // 注入你的Service、Mapper
    private ErpSupplierMapper supplierMapper;
    private ErpVehicleMapper vehicleMapper;

    public CacheInitRunner(ErpSupplierMapper supplierMapper,ErpVehicleMapper vehicleMapper) {
        this.supplierMapper = supplierMapper;
        this.vehicleMapper = vehicleMapper;
    }
    // 全局静态Map 常驻内存
    public static final Map<String, String> GRAIN_TYPE_MAP = new HashMap<>();


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========== 开始初始化全局缓存 ==========");
        try {
                    TenantContextHolder.setTenantId(1l);
        // 1. 预加载所有农户基础数据
        List<ErpSupplierDO> farmerList = supplierMapper.selectList();
        for (ErpSupplierDO dto:farmerList){
            GlobalCacheUtil.set("sup"+dto.getName(), dto);
        }


        // 2. 预加载司机
        List<ErpVehliceDO> dtoList = vehicleMapper.selectList();
        for (ErpVehliceDO dto:dtoList){
            GlobalCacheUtil.set("ve"+dto.getLicPlateNumber(), dto);
        }
        } catch (Exception e) {
            // 捕获异常，不让项目启动失败
            System.err.println("=== 加载缓存失败，但项目继续启动 ===");
            e.printStackTrace();
        }
        GRAIN_TYPE_MAP.put("A1","普杂");
        GRAIN_TYPE_MAP.put("A2","泰优");
        GRAIN_TYPE_MAP.put("A3","398");
        GRAIN_TYPE_MAP.put("A4","天龙");
        GRAIN_TYPE_MAP.put("A5","丝苗");

        GRAIN_TYPE_MAP.put("B1","湿稻谷");
        GRAIN_TYPE_MAP.put("B2","干稻谷");

        GRAIN_TYPE_MAP.put("C1","早稻");
        GRAIN_TYPE_MAP.put("C2","中稻");
        GRAIN_TYPE_MAP.put("C3","晚稻");

        System.out.println("========== 全局缓存初始化完成 ==========");
    }
}
