package com.neusoft.elmboot.mapper;


import com.neusoft.elmboot.po.VirtualWalletTransaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface VirtualWalletTransactionMapper {

    @Select("insert into transaction values(#{id},#{amount},#{CreateTime},#{Type},#{FromWalletId},#{ToWalletId});")
    public void saveTransaction(VirtualWalletTransaction Transaction);

    @Select("select * from transaction;")
    public List<VirtualWalletTransaction> listtransactionbyid(long userid);

}
