package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.po.Business;
import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.po.VirtualWalletTransaction;
import com.neusoft.elmboot.service.VirtualWalletService;
import java.math.BigDecimal;
import java.util.List;

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
    } // 提现、出账
    @RequestMapping("/credit")
    public void credit(String userId, BigDecimal amount) throws Exception {
        virtualWalletService.credit(userId,amount);
    } // 充值、入账
    @RequestMapping("/transfer")
    public void transfer(String fromUserId, String toUserId, BigDecimal amount) throws Exception {
        virtualWalletService.transfer(fromUserId,toUserId,amount);
    } // 转账
    @RequestMapping("/listtransactionbyid")
    public List<VirtualWalletTransaction> listtransactionbyid(String userid){
        return virtualWalletService.listtransactionbyid(userid);
    }//查询流水

}
