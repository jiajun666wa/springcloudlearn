package com.whj.gof23.strategyMode.strategyMode2;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @description: 工厂模式
 * @author: whj
 * @createTime: 2021-12-26 12:21
 * @version: 1.0
 */
public class StrategyFactory {
    private static Map<String,Handler> strategyMap = Maps.newHashMap();
    public static Handler getInvokeStrategy(String str){
       return strategyMap.get(str);
    }

    public static void register(String name, Handler handler ) {
        if (name.isEmpty() || null==handler) {
            return;
        }
        strategyMap.put(name,handler);
    }
}
