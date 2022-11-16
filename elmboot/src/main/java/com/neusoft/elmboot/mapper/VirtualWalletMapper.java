package com.neusoft.elmboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.neusoft.elmboot.po.VirtualWallet;

import java.math.BigDecimal;

@Mapper
public interface VirtualWalletMapper {


    //walletId就是userid
    @Select("select * from virtualwallet where userid=#{walletId}")
    public VirtualWallet getWalletbyuserId(long userId);
    @Select("select balance from virtualwallet where userid=#{walletId}")
    public BigDecimal getBalance(long walletId);
    @Select("UPDATE virtualwallet SET balance=#{balance} WHERE userid=#{walletId};")
    public void updateBalance(long walletId, BigDecimal balance);


}
