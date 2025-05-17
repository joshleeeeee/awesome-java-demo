package com.ljosh.demo.DesignParttern.strategy;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author joshlind
 * @date 2025/05/17
 */
@Service
@WhichVIPType(VIPType.VIP1)
public class VIP1Service implements VIPService {

    @Override
    public String getVIP(int recharge) {
        return "VIP1";
    }

}
