package net.javaguides.banking.mapper;

import net.javaguides.banking.Dto.AccountDto;
import net.javaguides.banking.entity.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto  = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }
}
