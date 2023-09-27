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
/*
@RestController是@Controller 的衍生注解。相当于@Controller+@ResponseBody
@Controller: This is a Spring Framework annotation typically used to mark a class as a controller component.
Controllers handle incoming HTTP requests and provide responses. 
By including this annotation, classes annotated with @RestController are treated as Spring controllers.
@ResponseBody: This Spring annotation is often used in combination with @Controller. It indicates that the return value of methods in the annotated class should be serialized directly to the HTTP response body. This is commonly used for building RESTful web services where the response is typically in JSON or XML format.
*/
@RestController
//用于将任意HTTP请求映射到控制器方法上
@RequestMapping("/VirtualWalletController")
public class VirtualWalletController {

    // @Autowired可以标注在属性上、方法上和构造器上，来完成自动装配。通过构造函数或者 IOC 框架注入,默认byType，如找到多个，再用byName
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
