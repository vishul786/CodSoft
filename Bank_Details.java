/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_machine;

import javax.swing.JOptionPane;

/**
 *
 * @author vishu
 */
public class Bank_Details {
    private String customerName;
    private int balance;
    private final int cardNumber;
    private int pin;

    public Bank_Details() {
        cardNumber = 55552222;
        pin = 1234;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void messg() {
        System.out.println("Fill your Card Details!!!");
        //JOptionPane.showMessageDialog("Fill your Card Details!!");
    }
    public static void main (String arg[]){
        new Bank_Details();
    }
    
    
}
