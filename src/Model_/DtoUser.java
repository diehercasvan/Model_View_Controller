/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_;

/**
 *
 * @author DIEGO CASALLAS
 */
public class DtoUser {

    private String sName;
    private String sSurname;
    private String sDocument;
    private String sPassword;
    private String sUser;

    public DtoUser() {
        this.sName = "";
        this.sSurname = "";
        this.sDocument = "";
        this.sPassword = "";
        this.sUser = "";
    }

    public String getsUser() {
        return sUser;
    }

    public void setsUser(String sUser) {
        this.sUser = sUser;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSurname() {
        return sSurname;
    }

    public void setsSurname(String sSurname) {
        this.sSurname = sSurname;
    }

    public String getsDocument() {
        return sDocument;
    }

    public void setsDocument(String sDocument) {
        this.sDocument = sDocument;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

}
