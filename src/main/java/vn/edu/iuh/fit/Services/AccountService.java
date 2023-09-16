package vn.edu.iuh.fit.Services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.Optional;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    public Optional<Account> isLogin(String username, String password) {
        return accountRepository.isLogin(username, password);
    }
}
