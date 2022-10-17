package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.service.VirtualWalletService;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

public class VirtualWalletController {

    // 通过构造函数或者 IOC 框架注入
    @Autowired
    private VirtualWalletService virtualWalletService;
  
  
    public BigDecimal getBalance(Long walletId) {
        return null;  } // 查询余额
  
    public void debit(Long walletId, BigDecimal amount) {  } // 出账
  
    public void credit(Long walletId, BigDecimal amount) {  } // 入账
  
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) { } // 转账
  
  }
