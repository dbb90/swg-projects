/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbb09
 */


/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package com.sg.dvdlibrary;

 

import com.sg.dvdlibrary.controller.DVDLibraryController;

import com.sg.dvdlibrary.dao.DVDLibraryDao;

import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;

import com.sg.dvdlibrary.ui.DVDLibraryView;

import com.sg.dvdlibrary.ui.UserIO;

import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

 

/**

 *

 * @author dbb09-

 */

public class App {

   

   public static void main(String[] args) {

   

   UserIO myIO = new UserIOConsoleImpl();

   DVDLibraryView myView = new DVDLibraryView(myIO);

   DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();

   DVDLibraryController controller = new DVDLibraryController(myView , myDao);

   

   controller.run();

   }

}

