package cn.iocoder.yudao.module.erp.dal.redis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalCacheUtil {
    // 静态全局缓存容器 线程安全
    private static final Map<String, Object> CACHE_MAP = new ConcurrentHashMap<>();

    /**
     * 存入缓存
     */
    public static void set(String key, Object value) {
        CACHE_MAP.put(key, value);
    }

    /**
     * 获取缓存
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) CACHE_MAP.get(key);
    }

    /**
     * 删除缓存
     */
    public static void remove(String key) {
        CACHE_MAP.remove(key);
    }

    /**
     * 清空全部缓存
     */
    public static void clear() {
        CACHE_MAP.clear();
    }

    /**
     * 判断key是否存在
     */
    public static boolean containsKey(String key) {
        return CACHE_MAP.containsKey(key);
    }
}
