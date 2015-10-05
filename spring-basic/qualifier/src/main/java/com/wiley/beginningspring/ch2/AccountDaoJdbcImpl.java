package com.wiley.beginningspring.ch2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoJdbcImpl implements AccountDao {

    private Map<Long,Account> accountsMap = new HashMap<>();

    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setOwnerName("John");
        account1.setBalance(10.0);

        Account account2 = new Account();
        account2.setId(2L);
        account2.setOwnerName("Mary");
        account2.setBalance(20.0);

        accountsMap.put(account1.getId(), account1);
        accountsMap.put(account2.getId(), account2);

    }

    @Override
    public void insert(Account account) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Account account) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(List<Account> accounts) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(long accountId) {
        // TODO Auto-generated method stub

    }

    @Override
    public Account find(long accountId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Account> find(List<Long> accountIds) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Account> find(String ownerName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Account> find(boolean locked) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
