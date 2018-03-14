/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it255.dz03;

/**
 *
 * @author sm
 */
public class User {

    private String fullName;
    private String email;
    private String password;
    private boolean emailConfirmed;
    private String emailConfirmationCode;

    public User(String fullName, String email, String password, boolean emailConfirmed, String emailConfirmationCode) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.emailConfirmed = emailConfirmed;
        this.emailConfirmationCode = emailConfirmationCode;
    }

    public User() {
    }
    
    

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getEmailConfirmationCode() {
        return emailConfirmationCode;
    }

    public void setEmailConfirmationCode(String emailConfirmationCode) {
        this.emailConfirmationCode = emailConfirmationCode;
    }
}

