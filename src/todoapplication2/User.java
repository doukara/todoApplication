package todoapplication2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    
private String userName , passWord;
Scanner input = new Scanner(System.in);
ArrayList<String> contactInfo = new ArrayList<String>() ;
    
    void userData(String userName ,String passWord ){
        this.userName = userName;
        this.passWord = passWord;
        contactInfo.add(passWord);
        contactInfo.add(userName);
    }
    
    void chekUserData(String passWord, String userName) {
        this.passWord = passWord;
        this.userName = userName;
        if(contactInfo.get(0).contentEquals(passWord) && contactInfo.get(1).contentEquals(userName)){
            System.out.println("Welcome");
            new Do().displayMenuOptions();
        }
        else
            System.out.println("Wrong user name or password please try again"); 
        
        }
    


}
    

