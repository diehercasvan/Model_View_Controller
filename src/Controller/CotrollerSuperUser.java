package Controller;

import Model_.BusinessLogic;
import Model_.DtoUser;
import View.JFHome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO CASALLAS
 */
public class CotrollerSuperUser implements ActionListener {

    JFHome viewHome = new JFHome();
    BusinessLogic modelSuperUser = new BusinessLogic();
    DtoUser user = new DtoUser();
    DtoUser userResult = new DtoUser();
    String sUser, sPassword;

    public CotrollerSuperUser(JFHome viewSuperUser, BusinessLogic daoSuperUser) {
        this.viewHome = viewSuperUser;
        this.modelSuperUser = daoSuperUser;
        this.viewHome.BtnMyData.addActionListener(this);
        this.viewHome.BtnSingOff.addActionListener(this);
        this.userResult = null;
    }

    public void startSuperUser(String sUser, String sPassword) {
        this.sUser = sUser;
        this.sPassword = sPassword;
        user.setsUser(sUser);
        user.setsPassword(sPassword);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getActionCommand().equals("Sing Off")) {
            viewHome.dispose();
        } else {
            try {
                userResult = new DtoUser();
                userResult = modelSuperUser.searchLogin(user);
                JOptionPane.showMessageDialog(viewHome, "Data of User");
                this.viewHome.LblName.setText(userResult.getsName());
                this.viewHome.LblSurname.setText(userResult.getsSurname());
            } catch (Exception ex) {
                Logger.getLogger(CotrollerSuperUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
