package todoapplication2;

import org.apache.commons.validator.routines.EmailValidator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws InterruptedException{
        Do obj = new Do();
        obj.displayMenu();
        
        //obj.account();
        //obj.fun();
 
    }
}  
    
class Do extends Thread{

    ArrayList<String> contactInfo = new ArrayList<>() ;
    ArrayList<String> List = new ArrayList<String>() ;
    User user = new User();
    Scanner input = new Scanner(System.in);
    private boolean loopIstrue = true, taskDoesntexist = false, format = true ;
    private String userName,passWord;
    Do obj;

        void account() throws InterruptedException{
            
            EmailValidator email = EmailValidator.getInstance();
            System.out.print("Add email: ");
            //input.nextLine();
            String chekEmail = input.next();
            boolean valid = email.isValid(chekEmail);
            if(valid == true ){
                System.out.print("Add password: ");
                passWord = input.next(); 
                Thread.sleep(1000);
                System.out.println("cong! registered successfully \n Now log in to your account ");
                user.userData(chekEmail, passWord);
                format = true;
            }
            else{
                System.out.println("Wrong format, check your email please ");
                format = false;
            }
            
        }
        
        void creatAcount() throws InterruptedException {
           
            System.out.print("Enter a name: ");
            userName = input.next();
            System.out.print("Add password: ");
            passWord = input.next();
            Thread.sleep(1000);
            System.out.println("cong! registered successfully \n Now log in to your account ");
            user.userData(userName, passWord);
       }
       
       void logIn(){
           if(format == true){
            System.out.print("Enter a name: ");
            userName = input.next();
            System.out.print("Add password: ");
            passWord = input.next();
            user.chekUserData(passWord, userName);
           }
       }
       
       public void displayMenu() throws InterruptedException{
           
           while(loopIstrue){
            try{
                System.out.println("What do you want to do ? ");
                System.out.print("1. Add account  2. Log to your account 3. Exit \n > ");
                int option = input.nextInt();
                displayHomeOptions(option);                   
            }catch(Exception ex)
             {
                System.out.println("Input not found try again (excption1)");
                loopIstrue =false;
             }
           }
       }
       
       public void displayHomeOptions(int option) throws InterruptedException{
                switch(option){
                    case 1 : 
                        account();
                    case  2 :
                        logIn(); 
                        break;
                    case 3 : 
                        loopIstrue = false;
                        break;
                    default : 
                        System.out.println("Input not found try again");
                        break;
                }
       }
    
       public void displayMenuOptions(){
           while(loopIstrue){
           try{
                System.out.print("What you want do now ? \n");
                System.out.print("1. Add tasks for tody 2. Show tasks 3. Delet tasks 4. Home \n > ");
                toDo(input.nextInt());                   
                   
            }catch(InputMismatchException ex)
            {
                System.out.println("Input not found try again (excption)");
                loopIstrue = false;
            }
           displayMenuOptions();
           
           }
       }
       
       public void toDo(int option){
           
           switch(option){
               case 1 : 
                   addTask();
                   break;
               case 2 : 
                   showTasks();
                   break;
               case 3 :
                   deletTask();
                   break;
               case 4 :
                   loopIstrue = false;
                   break;
           }
       }
       
       public void addTask(){
            System.out.print("Writ your task: ");
            //for not skip the line after this below
            input.nextLine();
            List.add(input.nextLine());
            System.out.println("Task was aded");
       }
        
       public void showTasks(){

           System.out.println(List.size() + " TASKS FOR TODAY: ");
           System.out.println("-------------");           
           for(String val : List)
               System.out.println(val);
           System.out.println("-------------");
       }
    
       void TaskNotFoud(){
           if(taskDoesntexist == false)
               System.out.println("Error, Task not found please try again");
       }

       
       public void deletTask(){
           if(List.isEmpty())
               System.out.println("TODO LIST is empty");
           else{
                System.out.print("writ it: ");
                input.nextLine();
                String task = input.nextLine();               
                for(int val = 0; val<List.size(); val++){
                    if(List.get(val).contentEquals(task))
                    {
                          List.remove(task);
                          System.out.println("task it's removed");
                          taskDoesntexist = true;
                    }else
                        taskDoesntexist = false;
                }
                TaskNotFoud();
            }
       }
}
