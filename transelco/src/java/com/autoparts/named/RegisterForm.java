/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.named;

import com.autoparts.models.Register;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("reg")
@SessionScoped
public class RegisterForm implements Serializable {
    private Register register;

    public RegisterForm() {
        register=new Register();
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
    
    
}
