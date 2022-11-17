package com.neusoft.elmboot.service;

import com.neusoft.elmboot.TransactionType;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.mapper.VirtualWalletTransactionMapper;
import  com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.po.VirtualWalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class VirtualWalletService {
   //通过构造函数或者IOC框架注入
   @Autowired
   private VirtualWalletTransactionMapper transactionRepo;
   @Autowired
   private VirtualWalletMapper walletRepo;
   public VirtualWallet getWalletbyuserId(String userId) {



      VirtualWallet walletEntity = walletRepo.getWalletbyuserId(userId);

      return walletEntity;
   }

   public BigDecimal getBalance (String walletId){
      return walletRepo.getBalance(walletId);
   };
   @Transactional
   public void debit(String walletId, BigDecimal amount) throws Exception {
      VirtualWallet wallet = walletRepo.getWalletbyuserId(walletId);
      wallet.debit(amount);
      VirtualWalletTransaction transactionEntity = new VirtualWalletTransaction();
      transactionEntity.setAmount(amount);
      transactionEntity.setCreateTime(System.currentTimeMillis());
      transactionEntity.setType("DEBIT");
      transactionEntity.setFromWalletId(walletId);
      transactionRepo.saveTransaction(transactionEntity);
      walletRepo.updateBalance(walletId, wallet.getBalance());
   }

   public void transfer (long fromWalletId,long towalletId, BigDecimal amount){};
   public void credit (long walletId, BigDecimal amount){};


   

}
