/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.named;

import com.entity.Material;
import com.entity.Transanciones;
import com.session.statefull.kart;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("pres")
@SessionScoped
public class PRestamos implements Serializable {

    @EJB
    kart kat;

    private List<Material> materiales;
    private List<Transanciones> trans;

    public PRestamos() {

    }

    @PostConstruct
    private void init() {
        createMateriales();
    }

    public List<Transanciones> getTrans() {
        
        return this.trans;
    }

    public void setTrans(List<Transanciones> trans) {
        this.trans = trans;
    }

    private void createMateriales() {
        materiales = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Material temp = new Material();
            temp.setNoParte(String.valueOf(i));
            temp.setNombre("pieza" + i);
            materiales.add(temp);
        }

        trans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Transanciones tp = new Transanciones();
            tp.setMaterialIdmaterial(materiales.get(i));
            tp.setCantidad(String.valueOf(i));
            trans.add(tp);
        }
    }

}
