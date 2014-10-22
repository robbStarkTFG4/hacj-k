/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.named;

import com.entity.Prestamos;
import com.entity.PrestamosFacade;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("history")
@SessionScoped
public class Historial implements Serializable {

    @EJB
    PrestamosFacade pres;

    private List<Prestamos> presi;
    private String usuario_id;

    public Historial() {

    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public List<Prestamos> getPresi() {
        return presi;
    }

    public void setPresi(List<Prestamos> presi) {
        this.presi = presi;
    }

    public void busca() {
        presi = pres.findBy(usuario_id);
    }

}
