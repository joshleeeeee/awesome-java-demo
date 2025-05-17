package com.ljosh.demo.DesignParttern.strategy;

import org.springframework.stereotype.Service;

/**
 * @author joshlind
 * @date 2025/05/17
 */
@Service
public interface VIPService {

    String getVIP(int recharge);

}
