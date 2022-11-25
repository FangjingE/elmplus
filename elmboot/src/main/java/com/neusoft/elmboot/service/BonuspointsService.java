package com.neusoft.elmboot.service;

import com.neusoft.elmboot.mapper.BonuspointsMapper;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.po.Bonuspoints;
import com.neusoft.elmboot.po.VirtualWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonuspointsService {
    @Autowired
    private BonuspointsMapper bonuspointsRepo;
    public Bonuspoints getBonuspointsbyuserId(String userId) {



        Bonuspoints bonuspointsEntity = bonuspointsRepo.getBonuspointsbyuserId(userId);

        return bonuspointsEntity;
    }
}
