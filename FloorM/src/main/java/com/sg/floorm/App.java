/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.floorm;

 

import com.sg.floorm.controller.FloorMController;
import com.sg.floorm.service.InvalidProductException;
import com.sg.floorm.service.InvalidTaxRateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

   

   public static void main(String[] args) throws InvalidProductException, InvalidTaxRateException {
       
      ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       FloorMController controller = ctx.getBean("controller" , FloorMController.class);
       controller.run();
   }}