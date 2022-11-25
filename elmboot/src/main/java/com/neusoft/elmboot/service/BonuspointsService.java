package com.neusoft.elmboot.service;

import com.neusoft.elmboot.mapper.BonuspointsMapper;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.po.Bonuspoints;
import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.po.VirtualWalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BonuspointsService {
    @Autowired
    private BonuspointsMapper bonuspointsRepo;
    public Bonuspoints getBonuspointsbyuserId(String userId) {



        Bonuspoints bonuspointsEntity = bonuspointsRepo.getBonuspointsbyuserId(userId);

        return bonuspointsEntity;
    }
    @Transactional
    public void debit(String userId, BigDecimal amount) throws Exception {
        Bonuspoints bonuspoints = bonuspointsRepo.getBonuspointsbyuserId(userId);
        bonuspoints.debit(amount);
//        VirtualWalletTransaction transactionEntity = new VirtualWalletTransaction();
//        transactionEntity.setAmount(amount);
//        transactionEntity.setCreateTime(System.currentTimeMillis());
//        transactionEntity.setType("DEBIT");
//        transactionEntity.setFromWalletId(walletId);
//        transactionRepo.saveTransaction(transactionEntity);
        bonuspointsRepo.updateBalance(userId, bonuspoints.getBalance());
    }
    @Transactional
    public void credit(String userId, BigDecimal amount) throws Exception {
        Bonuspoints bonuspoints = bonuspointsRepo.getBonuspointsbyuserId(userId);
        bonuspoints.credit(amount);
//        VirtualWalletTransaction transactionEntity = new VirtualWalletTransaction();
//        transactionEntity.setAmount(amount);
//        transactionEntity.setCreateTime(System.currentTimeMillis());
//        transactionEntity.setType("CREDIT");
//        transactionEntity.setFromWalletId(userId);
//        transactionRepo.saveTransaction(transactionEntity);
        bonuspointsRepo.updateBalance(userId, bonuspoints.getBalance());
    }
}
