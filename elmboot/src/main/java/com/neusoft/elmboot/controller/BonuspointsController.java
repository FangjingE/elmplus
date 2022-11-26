package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.po.*;
import com.neusoft.elmboot.service.BonuspointsService;
import com.neusoft.elmboot.service.VirtualWalletService;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BonuspointsController")
public class BonuspointsController {

    // 通过构造函数或者 IOC 框架注入
    @Autowired
    private BonuspointsService bonuspointsService;

    @RequestMapping("/getBonuspointsbyuserId")
    public Bonuspoints getBonuspointsbyuserId(String userid){
        return bonuspointsService.getBonuspointsbyuserId(userid);
    }

    @RequestMapping("/debit")
    public void debit(String userId, BigDecimal amount) throws Exception {
        bonuspointsService.debit(userId,amount);
    } // 提现、出账
    @RequestMapping("/credit")
    public void credit(String userId, BigDecimal amount) throws Exception {
        bonuspointsService.credit(userId,amount);
    }
    @RequestMapping("/listtransactionbyid")
    public List<BonuspointsTranscation> listtransactionbyid(String userid){
        return bonuspointsService.listtransactionbyid(userid);
    }//查询流水

}
