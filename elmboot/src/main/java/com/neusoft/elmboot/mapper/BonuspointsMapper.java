package com.neusoft.elmboot.mapper;

import com.neusoft.elmboot.po.Bonuspoints;
import com.neusoft.elmboot.po.VirtualWallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BonuspointsMapper {
    @Select("select * from bonuspoints where userid=#{userId}")
    public Bonuspoints getBonuspointsbyuserId(String userId);

}
