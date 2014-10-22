/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author NORE
 */
@Stateless
public class PrestamosFacade extends AbstractFacade<Prestamos> {

    @EJB
    UsuarioFacade user;

    @PersistenceContext(unitName = "transelcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamosFacade() {
        super(Prestamos.class);
    }

    public List<Prestamos> findBy(String userId) {
        TypedQuery<Prestamos> query = em.createQuery("SELECT c FROM Prestamos c WHERE c.usuario.idTrabajador = :id", Prestamos.class);
        query.setParameter("id", userId);

        return query.getResultList();
    }

    public Prestamos create() {
        Prestamos temp = new Prestamos();
        temp.setFechaPrestamo(new Date());
        temp.setUsuario(user.find(new UsuarioPK(1, "marco isaac")));
        this.create();
        return temp;
    }

}
