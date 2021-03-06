/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

/**
 *
 * @author dbb09
 */

public class Change {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    

    public Change(int totalPennies) {

       this.quarters = Math.floorDiv(totalPennies, 25);
       int penniesLeft = totalPennies - (this.quarters * 25);
       
       this.dimes = Math.floorDiv(penniesLeft, 10);
       penniesLeft -= (this.dimes * 10);
       
       this.nickels = Math.floorDiv(penniesLeft, 5);
       penniesLeft -= (this.nickels * 5);
       
       this.pennies = penniesLeft;
   }


    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
}
