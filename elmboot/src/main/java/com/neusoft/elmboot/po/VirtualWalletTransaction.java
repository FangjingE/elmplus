package com.neusoft.elmboot.po;

import com.neusoft.elmboot.TransactionType;

import java.math.BigDecimal;

public class VirtualWalletTransaction {
   private BigDecimal amount;
   private long CreateTime;
   private long id ;

   private  long ToWalletId;

   private TransactionType Type;

   private long FromWalletId;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return Type;
    }

    public void setType(TransactionType type) {
        Type = type;
    }

    public long getFromWalletId() {
        return FromWalletId;
    }

    public void setFromWalletId(long fromWalletId) {
        FromWalletId = fromWalletId;
    }

    public long getToWalletId() {
        return ToWalletId;
    }

    public void setToWalletId(long toWalletId) {
        ToWalletId = toWalletId;
    }
}
