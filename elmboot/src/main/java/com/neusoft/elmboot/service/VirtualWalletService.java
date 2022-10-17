package com.neusoft.elmboot.service;

import  com.neusoft.elmboot.po.VirtualWallet;

import java.math.BigDecimal;


public interface VirtualWalletService {
   //通过构造函数或者IOC框架注入
   public VirtualWallet getVirtualWallet(long wallerId);
   public BigDecimal getBalance (long walletId);
   public void transfer (long fromWalletId,long towalletId, BigDecimal amount);
   public void credit (long walletId, BigDecimal amount);
   public void debit (long walletId, BigDecimal amount);

   
   /*
	private VirtualWalletMapper walletRepo;
	private VirtualWalletTransactionRepository transactionRepo;
    
	public VirtualWallet getVirtualWallet(long wallerId) {
		VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
		VirtualWallet wallet = convert(walletEntity);
		return wallet;
	}
	public BigDecimal getBalance (long walletId) {
		return walletRepo.getBalance(walletId);
	}
	public void transfer (long fromWalletId,long towalletId, BigDecimal amount) {
		VirtualWalletTransactionEntity VirtualWalletTransactionEntity = new VirtualWalletTranscationEntity=
		new VirtualWalletTransactionEntity();
		transactionEntity.setAmount(amount);
		transactionEntity.setCreateTime(System.currentTimeMillis());
		transactionEntity.setFromWalletId(fromWalletId);
		transactionEntity.setToWalletId(towalletId);
		transactionEntity.setStatus(Status.TO_BE_EXECUTED);
		long transcationId= transactionRepo.saveTransaction(transactionEntity);
		try{
			debit(fromWalletId,amount);
			credit(toWalletId,amount);
		}
		catch(InsufficientBalanceException e){
			transactionRepo.updateStatus(transactionId, Status.CLOSED);
			...rethrow exception e...			
		}catch (Exception e){
			transcationRepo.updateStatus(transactionId,status.FAILED);
			...rethrow execption e...
		}
		transcationRepo.updateStatus(transcationId,Status.EXECUTED)
	}
	*/
}
