/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.models;

import com.entity.TblAdmin;
import com.entity.TblAdminFacade;
import com.entity.TblTipoAdmin;
import com.entity.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("users")
public class Register implements Serializable {
    private String nameInput;
    private  String passInput;
private String tipo;
private String nombreU;
private String idTrabajadorU;
private String apaternoU;
private String amaternoU;
private String email;
private String telU;

private String nombreA;
private String pass;
private String apaternoA;
private String amaternoA;
private String emailA;
private String telA;
private String usuario;
private TblTipoAdmin tad;
TblAdmin administrador;
Usuario user;
@EJB TblAdminFacade adminFac;

    public TblAdmin getAdministrador() {
        return administrador;
    }

    public void setAdministrador(TblAdmin administrador) {
        this.administrador = administrador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getIdTrabajadorU() {
        return idTrabajadorU;
    }

    public void setIdTrabajadorU(String idTrabajadorU) {
        this.idTrabajadorU = idTrabajadorU;
    }

    public String getApaternoU() {
        return apaternoU;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getPassInput() {
        return passInput;
    }

    public void setPassInput(String passInput) {
        this.passInput = passInput;
    }

    public void setApaternoU(String apaternoU) {
        this.apaternoU = apaternoU;
    }

    public String getAmaternoU() {
        return amaternoU;
    }

    public void setAmaternoU(String amaternoU) {
        this.amaternoU = amaternoU;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelU() {
        return telU;
    }

    public void setTelU(String telU) {
        this.telU = telU;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApaternoA() {
        return apaternoA;
    }

    public void setApaternoA(String apaternoA) {
        this.apaternoA = apaternoA;
    }

    public String getAmaternoA() {
        return amaternoA;
    }

    public void setAmaternoA(String amaternoA) {
        this.amaternoA = amaternoA;
    }

    public String getEmailA() {
        return emailA;
    }

    public void setEmailA(String emailA) {
        this.emailA = emailA;
    }

    public String getTelA() {
        return telA;
    }

    public void setTelA(String telA) {
        this.telA = telA;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TblTipoAdmin getTad() {
        return tad;
    }

    public void setTad(TblTipoAdmin tad) {
        this.tad = tad;
    }


 public String login(){

 
 if(nameInput.equals(passInput)){
     tipo="usuario";
 user=adminFac.logIn2(nameInput, passInput);
 if(user!=null){
     
    return "/super.xhtml";
     //System.out.println("USUARIO ENTRO");
 }else {System.out.println("errror usuario");
 
 
 
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o contraseña invalido"));
 return null;
 }
 
 
 
 
 }
             else{
                     
          tipo="admin"   ;   
         administrador= adminFac.logIn(nameInput, passInput);
         
         if(administrador!=null){
                 return "/super.xhtml";

     //System.out.println("ADMINISTRADOR ENTRO");
 }else {System.out.println("errror ADMIN");
         
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o contraseña invalido"));
         return null;
         }
                     }
            
 
 
 
 
 
 
 } 
 

}
