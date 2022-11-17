package com.neusoft.elmboot.po;

import com.neusoft.elmboot.TransactionType;

import java.math.BigDecimal;

public class VirtualWalletTransaction {
    private BigDecimal amount;
    private long CreateTime;
    private long id ;

    private String ToWalletId;

    private String Type;

    private String FromWalletId;

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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFromWalletId() {
        return FromWalletId;
    }

    public void setFromWalletId(String fromWalletId) {
        FromWalletId = fromWalletId;
    }

    public String getToWalletId() {
        return ToWalletId;
    }

    public void setToWalletId(String toWalletId) {
        ToWalletId = toWalletId;
    }
}
