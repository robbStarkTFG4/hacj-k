/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.named;

import com.entity.Material;
import com.entity.MaterialFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("sear")
@SessionScoped
public class AutoComplete implements Serializable {

    private @EJB
    MaterialFacade mtl;

    @Inject
    Results re;
    private List<Material> results;

    private Material caja;

    public AutoComplete() {
    }

    public List<Material> autoComplete(String patron) { // metodo del buscador 
        System.out.println("sigo funcionando autoComplete METODO");
        if (patron.matches("^[a-zA-Z0]*$")) {
            System.out.println("busqueda por nombre");
            results = mtl.autoQueryName(patron);
        } else {
            System.out.println("busqueda por numero de parte");
            results = mtl.autoQueryPartNumber(patron);
        }

        // System.out.println(patron);
        return results;
    }

    public String forward() {
        re.setMats(results);
        return "resultados";
    }

    public List<Material> getResults() {
        return results;
    }

    public Material getCaja() {
        return caja;
    }

    public void setCaja(Material caja) {
        this.caja = caja;
    }
}
