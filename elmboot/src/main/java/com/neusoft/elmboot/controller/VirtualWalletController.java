package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.po.Business;
import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.service.VirtualWalletService;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/VirtualWalletController")
public class VirtualWalletController {

    // 通过构造函数或者 IOC 框架注入
    @Autowired
    private VirtualWalletService virtualWalletService;

    @RequestMapping("/getWalletbyuserId")
    public VirtualWallet getWalletbyuserId(String userid){
        return virtualWalletService.getWalletbyuserId(userid);
    }
    @RequestMapping("/getBalance")
    public BigDecimal getBalance(String userid) {
        return virtualWalletService.getBalance(userid);  } // 查询余额

    @RequestMapping("/debit")
    public void debit(String userId, BigDecimal amount) throws Exception {
        virtualWalletService.debit(userId,amount);
    } // 出账

    public void credit(Long walletId, BigDecimal amount) {  } // 入账

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) { } // 转账

    public void listtransactionbyid(long userid){

    }//查询流水

}
