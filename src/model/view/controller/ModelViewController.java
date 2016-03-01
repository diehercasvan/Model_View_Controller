/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view.controller;

import Controller.ControllerLogin;
import Model_.BusinessLogic;
import Model_.ConnectionDataBase;
import View.JFLogin;

/**
 *
 * @author Sistemas2
 */
public class ModelViewController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFLogin objLogin=new JFLogin();
        objLogin.setVisible(true);
        objLogin.setLocationRelativeTo(null);
        BusinessLogic BL=new BusinessLogic();
        ControllerLogin controller=new ControllerLogin(objLogin,BL);
        
        
    }
    
}
