package sample;

import java.util.ArrayList;

public class AccountList {

    private ArrayList<Account> accounts = new ArrayList<>();

    public boolean add(Account account){
        if(accounts.contains(account)) return false;

        accounts.add(account);
        return true;
    }

    public boolean delete(Account _account){
        if(accounts.contains(_account)) {
            accounts.remove(_account);
            return true;
        }else return false;
    }

    @Override
    public String toString() {
        return accounts.toString();
    }
}