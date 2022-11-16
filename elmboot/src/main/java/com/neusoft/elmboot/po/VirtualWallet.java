package com.neusoft.elmboot.po;

import java.math.BigDecimal;
import java.lang.Exception;
public class VirtualWallet {
  private long userid;
//  private long createTime = System.currentTimeMillis();
  private BigDecimal balance = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId) {
        this.userid = preAllocatedId;
    }

    public BigDecimal balance() {
        return this.balance;
    }
//     提现
    public void debit(BigDecimal amount) throws Exception {
        if (this.balance.compareTo(amount) < 0) {
            throw new Exception("余额不足");
        }
        this.balance = this.balance.subtract(amount);
    }
//      充值
    public void credit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("存款值不合规");
        }
        this.balance = this.balance.add(amount);
    }

//    public long getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(long createTime) {
//        this.createTime = createTime;
//    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
