package sample;

import FileHandling.FileHandling;

import java.util.ArrayList;

public class AccountList {

    private ArrayList<Account> accounts = new ArrayList<>();

    private String file_name = "Accounts";
    private String extension = "csv";
    private String path = "C:\\Users\\Public\\SAS\\";

    public boolean add(Account account){
        for(int i = 0; i< accounts.size(); i++){
            if(accounts.get(i).getUsername().equals(account.getUsername())) return false;
        }

        accounts.add(account);
        return true;
    }

    public boolean delete(Account _account){
        if(accounts.contains(_account)) {
            accounts.remove(_account);
            return true;
        }else return false;
    }

    public int size(){ return accounts.size(); }
    public Account get(int i){
        return accounts.get(i);
    }

    @Override
    public String toString() {
        return accounts.toString();
    }

    public void save_accounts(){
        System.out.println("this method has been called");
        FileHandling fileHandling = new FileHandling(file_name,path,extension);
        fileHandling.checkDir(path);
        System.out.println("saving file\n"+toString());
        fileHandling.write(toString());
    }

    public void load_accounts(){
        FileHandling fileHandling = new FileHandling(file_name,path,extension);
        while(fileHandling.hasNext()){
            String line = fileHandling.getLine();
            String[] ac = line.split(",");
            if(ac.length <= 1) return;
            Account account = new Account();
            account.setNickname(ac[0]);
            account.setUsername(ac[1]);
            account.setPassword(ac[2]);
            this.add(account);
        }
    }
}