package com.ljosh.demo.DesignParttern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 方法论：
 * 1. 逻辑抽象
 * 2. 要实现具体的逻辑策略
 * 3. 选择一个不同的策略
 * 4. 调用策略具体的逻辑
 * <a href="https://www.bilibili.com/video/BV1HA7RzDEuz">原视频</a>
 *
 * @author joshlind
 * @date 2025/05/17
 */
@RestController
public class VIPController {

    private Map<VIPType, VIPService> vipServiceMap;

    @GetMapping("getVip/{recharge}")
    public String getVip(@PathVariable(value = "recharge") int recharge) {
        VIPType vipType = VIPType.typeOf(recharge);
        if (vipServiceMap.containsKey(vipType)) {
            return vipServiceMap.get(vipType).getVIP(recharge);
        }
        throw new IllegalArgumentException("充值金额错误");
    }

    @Autowired
    private void initVIPServiceMap(List<VIPService> vipServices) {
        vipServiceMap = vipServices.stream()
                .filter(vipService -> vipService.getClass().isAnnotationPresent(WhichVIPType.class))
                .collect(Collectors.toMap(this::findVIPTypeFromService, Function.identity()));
        if (this.vipServiceMap.size() != VIPType.values().length) {
            throw new IllegalStateException("不对等");
        }
    }

    private VIPType findVIPTypeFromService(VIPService vipService) {
        WhichVIPType annotation = vipService.getClass().getAnnotation(WhichVIPType.class);
        return annotation.value();
    }


}
