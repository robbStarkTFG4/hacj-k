/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.named;

import com.entity.Material;
import com.entity.PrestamosFacade;
import com.entity.Transanciones;
import com.session.statefull.kart;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("res")
@SessionScoped
public class Results implements Serializable {

    @EJB
    kart kt;

    @Inject
    PRestamos prs;

    @EJB
    PrestamosFacade prFacade;

    private List<Material> mats;
    private Material agregar;
    private int quantity;

    public Results() {
      //mats=new ArrayList<>();
    }

    public List<Material> getMats() {
        return mats;
    }

    public void setMats(List<Material> mats) {
        this.mats = mats;
    }

    private void createResults() {
        mats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Material temp = new Material();
            temp.setNoParte(String.valueOf(i));
            temp.setNombre("pieza" + i);
            temp.setMarca("dasdas");
            temp.setNoParte("21321");
            temp.setMaterialcol("selyR.jpg");
            mats.add(temp);
        }
    }

    public Material getAgregar() {
        return agregar;
    }

    public void setAgregar(Material agregar) {
        this.agregar = agregar;
    }

    public String cambia() {
        Transanciones tran = new Transanciones();
        tran.setCantidad(String.valueOf(quantity));
        tran.setMaterialIdmaterial(agregar);
        tran.setPrestamosIdprestamos(prFacade.create());
        kt.add(agregar, tran);
        return "pedidos";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
