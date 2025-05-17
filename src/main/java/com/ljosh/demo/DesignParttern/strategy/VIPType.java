package com.ljosh.demo.DesignParttern.strategy;

import java.util.function.IntPredicate;

/**
 * @author joshlind
 * @date 2025/05/17
 */
public enum VIPType {

    COMMON(recharge -> (recharge > 0 && recharge <= 100)),
    VIP1(recharge -> recharge > 100 && recharge < 1000),
    VIP2(recharge -> recharge >= 1000 && recharge < 5000),
    VIP3(recharge -> recharge > 5000),
    DEFAULT(recharge -> true);

    private final IntPredicate isVIP;


    VIPType(IntPredicate predicate) {
        this.isVIP = predicate;
    }

    public static VIPType typeOf(int recharge) {
        for (VIPType vipType : values()) {
            boolean test = vipType.isVIP.test(recharge);
            if (test) {
                return vipType;
            }
        }
        return DEFAULT;
    }
}
