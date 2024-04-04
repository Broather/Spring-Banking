package com.spring.banking.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class BankAccountController {
    @GetMapping
    public List<BankAccount> allAccounts(){
        return List.of(
                new BankAccount(1234L),
                new BankAccount(4321L)
        );
    }
}
