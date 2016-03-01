package Controller;

import Model_.BusinessLogic;
import Model_.DtoUser;
import View.JFHome;
import View.JFLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author DIEGO CASALLAS
 */
public class ControllerLogin implements ActionListener {

    JFLogin viewLogin = new JFLogin();
    BusinessLogic modelLogin = new BusinessLogic();
    DtoUser user = new DtoUser();
    DtoUser userResult = new DtoUser();

    public ControllerLogin(JFLogin viewLogin, BusinessLogic daoUserModel) {
        this.viewLogin = viewLogin;
        this.modelLogin = daoUserModel;
        this.viewLogin.BtnLogin.addActionListener(this);
    }

    public void startLogin() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
      
        String sUser = viewLogin.TxtUser.getText();
        String sPassword = String.valueOf(viewLogin.TxtPassword.getPassword());
        userResult = new DtoUser();
        userResult.setsUser(sUser);
        userResult.setsPassword(sPassword);

        try {
            user = modelLogin.searchLogin(userResult);

            if (user == null) {
                JOptionPane.showMessageDialog(viewLogin, "The data entered is incorrect");
            } else {
                JFHome viewSuperUser = new JFHome();
                JOptionPane.showMessageDialog(viewLogin, "Correct data");
                CotrollerSuperUser controller = new CotrollerSuperUser(viewSuperUser, modelLogin);
                controller.startSuperUser(sUser, sPassword);
                viewSuperUser.setVisible(true);
                viewSuperUser.setLocationRelativeTo(null);
                viewLogin.dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
