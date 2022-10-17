package com.neusoft.elmboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.neusoft.elmboot.po.VirtualWallet;

@Mapper
public interface VirtualWalletMapper {
    @Select("select * from user where userId=#{userId} and password=#{password}")
    public VirtualWallet getWalletbywalletId(long walletId);
}
