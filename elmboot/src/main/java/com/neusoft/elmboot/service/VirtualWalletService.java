package com.neusoft.elmboot.service;

import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.mapper.VirtualWalletTransactionMapper;
import com.neusoft.elmboot.po.VirtualWalletTransaction;
import com.neusoft.elmboot.TransactionType;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


public class VirtualWalletService {
   // 通过构造函数或者IOC框架注入
   private VirtualWalletMapper walletRepo;
   private VirtualWalletTransactionMapper transactionRepo;

   public VirtualWallet getWalletbyuserId(Long userId) {
      VirtualWallet walletEntity = walletRepo.getWalletbyuserId(userId);

      return walletEntity;
   }

   public BigDecimal getBalance(Long walletId) {
      return walletRepo.getBalance(walletId);
   }

//
   @Transactional
   public void debit(Long walletId, BigDecimal amount) throws Exception {
      VirtualWallet wallet = walletRepo.getWalletbyuserId(walletId);
      wallet.debit(amount);
      VirtualWalletTransaction transactionEntity = new VirtualWalletTransaction();
      transactionEntity.setAmount(amount);
      transactionEntity.setCreateTime(System.currentTimeMillis());
      transactionEntity.setType(TransactionType.DEBIT);
      transactionEntity.setFromWalletId(walletId);
      transactionRepo.saveTransaction(transactionEntity);
      walletRepo.updateBalance(walletId, wallet.balance());
   }

//
   @Transactional
   public void credit(Long walletId, BigDecimal amount) throws Exception {
      VirtualWallet wallet = walletRepo.getWalletbyuserId(walletId);
      wallet.credit(amount);
      VirtualWalletTransaction transactionEntity = new VirtualWalletTransaction();
      transactionEntity.setAmount(amount);
      transactionEntity.setCreateTime(System.currentTimeMillis());
      transactionEntity.setType(TransactionType.CREDIT);
      transactionEntity.setFromWalletId(walletId);
      transactionRepo.saveTransaction(transactionEntity);
      walletRepo.updateBalance(walletId, wallet.balance());
   }

   @Transactional
   public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) throws Exception {
      VirtualWalletTransaction transactionEntity = new VirtualWalletTransaction();
      transactionEntity.setAmount(amount);
      transactionEntity.setCreateTime(System.currentTimeMillis());
      transactionEntity.setType(TransactionType.TRANSFER);
      transactionEntity.setFromWalletId(fromWalletId);
      transactionEntity.setToWalletId(toWalletId);
      transactionRepo.saveTransaction(transactionEntity);
      debit(fromWalletId, amount);
      credit(toWalletId, amount);
   }
   @Transactional
   public List<VirtualWalletTransaction>  listtransactionbyid (long userid){
      return transactionRepo.listtransactionbyid(userid);
   };
}

