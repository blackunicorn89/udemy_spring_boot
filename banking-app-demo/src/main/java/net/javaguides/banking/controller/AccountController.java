package net.javaguides.banking.controller;

import net.javaguides.banking.Dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.DoublePredicate;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Method to handle POST Api calls
    @PostMapping("/add")
    public ResponseEntity<AccountDto>addNewAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }

    //Get a bank account by id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto>GetAccountById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    //Get all bank accounts
    @GetMapping()
    public ResponseEntity<List<AccountDto>>GetAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }


//    Deposit API
    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto>deposit (@PathVariable("id") long id, @RequestBody Map<String, Double> amount) {
      return new ResponseEntity<>(accountService.deposit(id, amount.get("amount")), HttpStatus.OK);
    }

    //Withdraw Api
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto>withdraw (@PathVariable("id") long id, @RequestBody Map<String, Double> amount) {
        return new ResponseEntity<>(accountService.withDraw(id, amount.get("amount")), HttpStatus.OK);
    }

    //Withdraw Api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount (@PathVariable("id") long id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<>("The bank account with the id " + id +" successfully removed", HttpStatus.OK);
    }

}
