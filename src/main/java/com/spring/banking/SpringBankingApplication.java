package com.spring.banking;

import com.spring.banking.account.BankAccount;
import com.spring.banking.account.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BankAccountService service) {
		return (args) -> {
			// save a few accounts
			service.save(new BankAccount(0));
			service.save(new BankAccount(0));
			service.save(new BankAccount(0));
			service.save(new BankAccount(0));
			service.save(new BankAccount(0));
		};
	}
}
