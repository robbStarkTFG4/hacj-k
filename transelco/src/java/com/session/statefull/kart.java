/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session.statefull;

import com.entity.Material;
import com.entity.Transanciones;
import com.entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORE
 */
@Stateful
public class kart {

    @PersistenceContext(unitName = "transelcoPU")
    private EntityManager em;

    private final int idPrestario = 0;
    private final int idUsuario = 0;
    private List<Material> mtl;
    private List<Transanciones> dtl;

    @PostConstruct
    private void load() {
        mtl = new ArrayList<>();
        dtl = new ArrayList<>();

    }

    public kart() {
    }

    public void init() {// Objeto usuario con cosas basicas principalmente id, igual con el prestario.
    }

    public boolean verify() { //verifica que exista un usuario instanciado "que no sea 0".
        return false;
    }

    public boolean add(Material tbl, Transanciones tram) { /// al agregar revisar si hay stock REGRESAR BOOLEANO
        mtl.add(tbl);
        dtl.add(tram);
        return false;

    }

    public List<Transanciones> getDtl() {
        return dtl;
    }

    @Remove
    public void remove() {

    }

    public void modify() {

    }

    public void removeItem(Material mt) {
        Material temp = null;

        for (Material tblMaterial : mtl) {
            if (tblMaterial.getNoParte().equals(mt.getNoParte())) {
                temp = tblMaterial;
            }
        }
        if (temp != null) {
            mtl.remove(temp);

        }
    }

    public void clearList() {
        mtl.clear();

    }

    public boolean persistLoan(Usuario pro) {//cDASDASDASDASDAS AGREGAR EL USUARIO COMO PARAMETRO DEL METODO Y METERLO EN "1"
        if (!mtl.isEmpty()) {
            //   Prestamos pr = pres.createPres(pro); //  staless facade de prestamos
            Map<String, Integer> quantity = new HashMap<>();

        }
        return false;
    }

}
