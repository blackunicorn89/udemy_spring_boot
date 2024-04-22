package net.javaguides.banking.service;

import net.javaguides.banking.Dto.AccountDto;
import net.javaguides.banking.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withDraw(Long id, double amount);
    List <AccountDto> getAllAccounts();
    void deleteAccountById(Long id);
}
