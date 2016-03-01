/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_;

import java.sql.*;

/**
 *
 * @author DIEGO CASALLAS
 */
public class DaoUser {

    private final Connection cConnection;
    private PreparedStatement pLoad;
    private String sSQL;
    private ResultSet rResultSet;
    private final String sWhere;
    private DtoUser ObjUser;

    public DaoUser(Connection cCont) {
        this.cConnection = cCont;
        this.ObjUser = null;
        this.sWhere = null;
        this.rResultSet = null;
        this.sSQL = null;
        this.pLoad = null;

    }
   
    public DtoUser searchUser(DtoUser dtoUser) throws SQLException {

        ObjUser = new DtoUser();
        sSQL = "SELECT * FROM User WHERE Email='" + dtoUser.getsUser();
        pLoad=(PreparedStatement)cConnection.prepareStatement(sSQL);
        rResultSet=pLoad.executeQuery();
        
        while(rResultSet.next()){
            ObjUser.setsName(rResultSet.getString("Name"));
            ObjUser.setsSurname(rResultSet.getString("Surname"));
            ObjUser.setsDocument(rResultSet.getString("Document"));
            ObjUser.setsUser(rResultSet.getString("Email"));
        }

        return ObjUser;
    }

    public DtoUser validateLogin(DtoUser dtoUser) throws SQLException {
        ObjUser = new DtoUser();
        sSQL = "SELECT * FROM User WHERE Email='" + dtoUser.getsUser() + "' AND Password='" + dtoUser.getsPassword() + "'";
        pLoad=(PreparedStatement)cConnection.prepareStatement(sSQL);
        rResultSet=pLoad.executeQuery();
        
        while(rResultSet.next()){
            ObjUser.setsName(rResultSet.getString("Name"));
            ObjUser.setsSurname(rResultSet.getString("Surname"));
            ObjUser.setsDocument(rResultSet.getString("Document"));
            ObjUser.setsUser(rResultSet.getString("Email"));
        }

        return ObjUser;
    }
}
