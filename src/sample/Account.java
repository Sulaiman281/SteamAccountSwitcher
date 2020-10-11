package sample;

public class Account {
    private String nickname;
    private String username;
    private String password;

    public Account(){
        this.username = "";
        this.password = "";
    }
    public Account(String _username, String _password){

    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getParameters(){
        return "-login "+this.getUsername()+" "+this.getPassword();
    }

    @Override
    public String toString() {
        return "Account ,"+getNickname()+","+getUsername()+","+getPassword();
    }
}
