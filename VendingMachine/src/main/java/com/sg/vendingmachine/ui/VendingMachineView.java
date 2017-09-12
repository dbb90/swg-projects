/*
 	 * To change this license header, choose License Headers in Project Properties.
 	 * To change this template file, choose Tools | Templates
 	 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Products;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dbb09
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayChoicePrompt() {
        io.print("The following products are in stock: ");
    }

    public int displayProducts(List<Products> listOfStockedProducts) {

        for (int i = 0; i < listOfStockedProducts.size(); i++) {
            Products product = listOfStockedProducts.get(i);
            io.print((i+ 1) + ": " + product.getProductName() + " - $" + product.getProductPrice());
        }

        io.print("\nSelect a number to the left of the product, or "
                + "enter 0 to quit.");

        return io.readInt("\nEnter selection: ", 0, (listOfStockedProducts.size()));
    }
    
    public Products displayUserProductChoice(int userChoice, List<Products> products) {
        Products product = products.get(userChoice);
        io.print("\nSELECTION: " + product.getProductName());
        io.print("\n");
        return product;
    }

    public String getCashInput() {
        return io.readString("Insert bill/coins at this time!");
    }

    public void displayRemainingProductInv(Products product) {
        product.setNumberOfProducts((product.getNumOfProductsStocked() - 1));
        io.readString(product.getNumOfProductsStocked() + " " + product.getProductName() + "(s) remaining."
        + "\n\n Please press enter.\n");
    }

    public void displayChange(BigDecimal change) {
        
        if (change.compareTo(new BigDecimal(0.00)) == 0) {
            io.print("");
            io.print("\n No change owed!  Have a good day.");
        } else {
            BigDecimal toPennies = change.multiply(new BigDecimal(100));
            BigDecimal setScaleToPennies = toPennies.setScale(0);
            Change changeBackToUser = new Change(setScaleToPennies);
            io.print("Quarter(s): " + changeBackToUser.getQuarters());
            io.print("Dime(s): " + changeBackToUser.getDimes());
            io.print("Nickel(s): " + changeBackToUser.getNickels());
            io.print("Penny(s): " + changeBackToUser.getPennies());
        }
    }

    public void displaySuccessBanner() {
        io.print("Enjoy your purchase!\n\n");
    }

    public void displayIntroBanner() {
        io.print("-----VENDING MACHINE-----\n\n"); }

    public void displayErrorMessage(String errorMsg) {
        io.print("Error:" + errorMsg);
        io.readString("Press enter to continue, or enter 0 to quit.");
 
    }
    
  //  public void checkErrorResponse() {
  //
  //  }
    
    
    public void displayExitBanner() {
        io.print("Thank you for your patronage!");
    }
}
