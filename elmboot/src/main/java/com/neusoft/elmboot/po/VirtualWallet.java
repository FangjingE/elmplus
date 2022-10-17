package com.neusoft.elmboot.po;

import java.math.BigDecimal;

public class VirtualWallet {
  private long id;
  private long createTime = System.currentTimeMillis();
  private BigDecimal balance = BigDecimal.ZERO;

public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public long getCreateTime() {
    return createTime;
}
public void setCreateTime(long createTime) {
    this.createTime = createTime;
}
public BigDecimal getBalance() {
    return balance;
}
public void setBalance(BigDecimal balance) {
    this.balance = balance;
}
  
  
  

}
