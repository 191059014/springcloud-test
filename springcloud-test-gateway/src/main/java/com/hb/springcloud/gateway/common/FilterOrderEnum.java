package com.hb.springcloud.gateway.common;

import com.hb.springcloud.gateway.filter.CustomerFilter1;
import com.hb.springcloud.gateway.filter.CustomerFilter2;
import com.hb.springcloud.gateway.filter.CustomerFilter3;

/**
 * desc
 *
 * @version v0.1, 2021/5/20 11:48, create by huangbiao.
 */
public enum FilterOrderEnum {

    FILTER_1(CustomerFilter1.class.getName(), 1),
    FILTER_2(CustomerFilter2.class.getName(), 2),
    FILTER_3(CustomerFilter3.class.getName(), 3),
    ;

    /**
     * 类名
     */
    private String className;

    /**
     * 过滤器的order
     */
    private int order;

    FilterOrderEnum(String className, int order) {
        this.className = className;
        this.order = order;
    }

    /**
     * 获取order
     *
     * @param className 类名
     * @return order值
     */
    public static int getOrder(String className) {
        for (FilterOrderEnum filterOrderEnum : FilterOrderEnum.values()) {
            if (filterOrderEnum.className.equals(className)) {
                return filterOrderEnum.order;
            }
        }
        return 0;
    }

}
