/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm_interface;

import java.util.Scanner;

/**
 *
 * @author vishu
 */
class Bank_Detail{
    int Acct_no;
    float Balance;
    int PIN = 5674;     
}
class ATM extends Bank_Detail{
   
    ATM(){
        System.out.println("Welcome To Bank ATM!!!");
        System.out.println("Insert Your ATM/Debit Card in the slot!!!");
        insertCard();
    }
    public void insertCard(){
        System.out.println("Card is scanning!!\n wait!!");
        System.out.println("Card scanned successfully!!!");
    }
    
    public void checkPin(){
        System.out.println("Enter your PIN: ");
        Scanner sc = new Scanner(System.in);
        int enterPin=sc.nextInt();
        if(enterPin==PIN){
            menu();
        }
        else{
            System.out.println("Enter a valid PIN: ");
        }
    }
    public void menu(){
        System.out.println("Enter Your Choice: ");
        System.out.println("1. Check A/c Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();
        if(opt==1){
            checkBalance();
        }
        else if(opt==2){
            withdrawMoney();
        }
        else if(opt==3){
            depositMoney();
        }
        else if(opt==4){
            return ;
            //System.exit(0);
        }
        else{
            System.out.println("Enter a valid choice!!!!");
        }
    }
    public void checkBalance(){
        System.out.println("Balance: "+Balance);
        menu();        
    }
    public void withdrawMoney(){
        System.out.println("Enter the Amount of Money: ");
        Scanner sc=new Scanner(System.in);
        float amt=sc.nextFloat();
        if(amt>Balance){
            System.out.println("Insufficient Balance");
        }
        else{
            Balance-=amt;
            System.out.println("Money Withdrawl Successful!!");
        }
        menu();        
    }
    public void depositMoney(){
        System.out.println("Enter the Amount of Money: ");
        Scanner sc=new Scanner(System.in);
        float amt=sc.nextFloat();
        Balance+=amt;
        System.out.println("Money Deposited Successfully!!!");
        menu();        
    }   
}
public class ATM_Interface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    ATM obj = new ATM();
    obj.checkPin();
    }
    
}
