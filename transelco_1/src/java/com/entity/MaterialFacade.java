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
