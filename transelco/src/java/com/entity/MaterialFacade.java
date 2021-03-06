/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class MaterialFacade extends AbstractFacade<Material> {
    @PersistenceContext(unitName = "transelcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialFacade() {
        super(Material.class);
    }
     public boolean agregar(String nombre, String noparte, String descripcion, String stock,String marca, String  sf, TblAdmin admin, String imagen) {
     try{   
        Material mat = new Material();
      SubFamilia subf =new SubFamilia();
      subf.setIdsubFamilia(Integer.parseInt(sf));
     mat.setNombre(nombre);
     mat.setDescripcion(descripcion);
     mat.setNoParte(noparte);
     mat.setMarca(marca);
     mat.setStock(stock);
     mat.setMaterialcol(imagen);
     mat.setSubFamiliaIdsubFamilia(subf);
     mat.setTblAdminIdtblAdmin(admin);
        em.persist(mat);
        return true;
     }catch(Exception e){
     
     return false;
     }
      

    } 
     
      public List<Material> autoQueryName(String patron) {

        TypedQuery<Material> query = em.createQuery("SELECT c FROM Material c WHERE c.nombre LIKE :patron", Material.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<Material> res = query.getResultList();

        return res;

    }

    public List<Material> autoQueryPartNumber(String patron) {
        //
        TypedQuery<Material> query = em.createQuery("SELECT c FROM Material c WHERE c.noParte LIKE :patron", Material.class);
        query.setParameter("patron", patron.toLowerCase() + "%");

        List<Material> res = query.getResultList();

        return res;
    }
     
    
}
