package com.spring.banking.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    public List<BankAccount> findAll(){
        return bankAccountRepository.findAll();
    }
    public void save(BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }
}
