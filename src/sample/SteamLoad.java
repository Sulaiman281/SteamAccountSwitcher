package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SteamLoad {

    public SteamLoad(){

    }

    public boolean isSteamRunning(){
        String line;
        try {
            Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if(line.contains("steam.exe")) return true;
            }
            input.close();
        }catch (Exception err) {
            err.printStackTrace();
        }
        return false;
    }
    public boolean closeSteam(){
        String line = "";
        int code = -1;
        try {
            Process p = Runtime.getRuntime().exec("taskkill /F /IM steam.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line = input.readLine()) != null){
                System.out.println(line);
            }
            input.close();
            code = p.exitValue();
            }catch (IOException e) {
                e.printStackTrace();
            }
        return (code == 1 ? false : true);
    }
    public void openAccount(Account _account){
        String steamPath = "C:\\Program Files (x86)\\Steam\\steam.exe";
        try {
            Process p = Runtime.getRuntime().exec(steamPath+" "+_account.getParameters());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
