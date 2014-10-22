/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NORE
 */
@Stateless
public class TblAdminFacade extends AbstractFacade<TblAdmin> {
    @PersistenceContext(unitName = "transelcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblAdminFacade() {
        super(TblAdmin.class);
    }
   public TblAdmin logIn(String usuario, String clave) {

        TblAdmin user = null;

        try {
           
            Query search = em.createQuery("SELECT u FROM TblAdmin u WHERE u.usuario=:usuario and u.contraseña=:clave");
            search.setParameter("usuario", usuario);
            search.setParameter("clave", clave);
            user = (TblAdmin) search.getSingleResult();
        } catch (Exception e) {
            System.out.println("");
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }

    }
    public Usuario logIn2(String usuario, String clave) {

        Usuario user = null;

        try {
           
            Query search = em.createQuery("SELECT u FROM Usuario u WHERE u.idTrabajador=:usuario and u.idTrabajador=:clave");
            search.setParameter("usuario", usuario);
            search.setParameter("clave", clave);
            user = (Usuario) search.getSingleResult();
        } catch (Exception e) {
            System.out.println("");
            return user;//System.out.println("ERROR IN Question FACADE:" + e.getMessage());
        } finally {
            return user;
        }

    }  
}
