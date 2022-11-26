package com.neusoft.elmboot.service;

import com.neusoft.elmboot.mapper.BonuspointsMapper;
import com.neusoft.elmboot.mapper.BonuspointsTransactionMapper;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.po.Bonuspoints;
import com.neusoft.elmboot.po.BonuspointsTranscation;
import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.po.VirtualWalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BonuspointsService {
    @Autowired
    private BonuspointsMapper bonuspointsRepo;
    @Autowired
    private BonuspointsTransactionMapper bonuspointstranscationRepo;
    public Bonuspoints getBonuspointsbyuserId(String userId) {



        Bonuspoints bonuspointsEntity = bonuspointsRepo.getBonuspointsbyuserId(userId);

        return bonuspointsEntity;
    }
    @Transactional
    public void debit(String userId, BigDecimal amount) throws Exception {
        Bonuspoints bonuspoints = bonuspointsRepo.getBonuspointsbyuserId(userId);
        bonuspoints.debit(amount);
        BonuspointsTranscation transactionEntity = new BonuspointsTranscation();
        transactionEntity.setAmount(amount);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        transactionEntity.setCreateTime(dateformat.format(System.currentTimeMillis()));
        transactionEntity.setType("使用");
        transactionEntity.setUserid(userId);
       // transactionEntity.setExpiredTime();
        bonuspointstranscationRepo.saveTransaction(transactionEntity);
        bonuspointsRepo.updateBalance(userId, bonuspoints.getBalance());
    }
    @Transactional
    public void credit(String userId, BigDecimal amount) throws Exception {
        Bonuspoints bonuspoints = bonuspointsRepo.getBonuspointsbyuserId(userId);
        bonuspoints.credit(amount);
        BonuspointsTranscation transactionEntity = new BonuspointsTranscation();
        transactionEntity.setAmount(amount);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        transactionEntity.setCreateTime(dateformat.format(System.currentTimeMillis()));
        transactionEntity.setExpiredTime(dateformat.format(System.currentTimeMillis()+2592000000L));//2592000000是一个月的时间戳，积分一个月后失效。
        transactionEntity.setType("获得");
        transactionEntity.setUserid(userId);
        bonuspointstranscationRepo.saveTransaction(transactionEntity);
        bonuspointsRepo.updateBalance(userId, bonuspoints.getBalance());
    }

    public List<BonuspointsTranscation> listtransactionbyid (String userId){
        return  bonuspointstranscationRepo.listtransactionbyid(userId);
    }


}
