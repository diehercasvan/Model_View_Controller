/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author DIEGO CASALLAS
 */
public class BusinessLogic extends ConnectionDataBase {

    private Connection cCon;
    private DtoUser user;

    public BusinessLogic() {
        this.cCon = null;
    }

    public DtoUser searchLogin(DtoUser objUser) throws Exception {
        this.cCon = super.connect();
        user = new DtoUser();
        try {
            DaoUser objDao=new DaoUser(this.cCon);
            user=objDao.validateLogin(objUser);
        } catch (Exception e) {
            throw e;
        } finally {
            super.disconnect();
        }

        return user;

    }
    public DtoUser searchUser(DtoUser objUser) throws Exception {
        this.cCon = super.connect();
        user = new DtoUser();
        try {
            DaoUser objDao=new DaoUser(this.cCon);
            user=objDao.validateLogin(objUser);
        } catch (Exception e) {
            throw e;
        } finally {
            super.disconnect();
        }

        return user;

    }

}
