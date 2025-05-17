package com.ljosh.demo.DesignParttern.strategy;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author joshlind
 * @date 2025/05/17
 */
@Service
@WhichVIPType(VIPType.DEFAULT)
public class DefaultUserService implements VIPService {

    @Override
    public String getVIP(int recharge) {
        return "普通用户";
    }
}
