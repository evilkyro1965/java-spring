package com.wiley.beginningspring.ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Administrator on 9/29/15.
 */

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    @Qualifier(value = "accountDaoBasic")
    public void setAccountDao(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(long sourceAccountId, long targetAccountId, double amount){
        Account sourceAccount = accountDao.find(sourceAccountId);
        Account targetAccount = accountDao.find(targetAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountDao.update(sourceAccount);
        accountDao.update(targetAccount);
    }

    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account account = accountDao.find(accountId);
        account.setBalance(account.getBalance() + amount);
        accountDao.update(account);
    }

    @Override
    public Account getAccount(long accountId){
        return accountDao.find(accountId);
    }
}
