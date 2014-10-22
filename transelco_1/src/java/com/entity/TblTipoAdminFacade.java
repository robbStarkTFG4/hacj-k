/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NORE
 */
@Stateless
public class TblTipoAdminFacade extends AbstractFacade<TblTipoAdmin> {
    @PersistenceContext(unitName = "transelcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblTipoAdminFacade() {
        super(TblTipoAdmin.class);
    }
    
}
