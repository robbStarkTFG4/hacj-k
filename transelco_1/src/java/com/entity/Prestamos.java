/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p"),
    @NamedQuery(name = "Prestamos.findByIdprestamos", query = "SELECT p FROM Prestamos p WHERE p.idprestamos = :idprestamos"),
    @NamedQuery(name = "Prestamos.findByFechaPrestamo", query = "SELECT p FROM Prestamos p WHERE p.fechaPrestamo = :fechaPrestamo")})
public class Prestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprestamos")
    private Integer idprestamos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPrestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamosIdprestamos")
    private List<Transanciones> transancionesList;
    @JoinColumns({
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario"),
        @JoinColumn(name = "usuario_nombre", referencedColumnName = "nombre")})
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Prestamos() {
    }

    public Prestamos(Integer idprestamos) {
        this.idprestamos = idprestamos;
    }

    public Prestamos(Integer idprestamos, Date fechaPrestamo) {
        this.idprestamos = idprestamos;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getIdprestamos() {
        return idprestamos;
    }

    public void setIdprestamos(Integer idprestamos) {
        this.idprestamos = idprestamos;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @XmlTransient
    public List<Transanciones> getTransancionesList() {
        return transancionesList;
    }

    public void setTransancionesList(List<Transanciones> transancionesList) {
        this.transancionesList = transancionesList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestamos != null ? idprestamos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.idprestamos == null && other.idprestamos != null) || (this.idprestamos != null && !this.idprestamos.equals(other.idprestamos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Prestamos[ idprestamos=" + idprestamos + " ]";
    }
    
}
