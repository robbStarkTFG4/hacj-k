/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "transanciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transanciones.findAll", query = "SELECT t FROM Transanciones t"),
    @NamedQuery(name = "Transanciones.findByIdTransanciones", query = "SELECT t FROM Transanciones t WHERE t.idTransanciones = :idTransanciones"),
    @NamedQuery(name = "Transanciones.findByCantidad", query = "SELECT t FROM Transanciones t WHERE t.cantidad = :cantidad")})
public class Transanciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transanciones")
    private Integer idTransanciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "material_idmaterial", referencedColumnName = "idmaterial")
    @ManyToOne(optional = false)
    private Material materialIdmaterial;
    @JoinColumn(name = "prestamos_idprestamos", referencedColumnName = "idprestamos")
    @ManyToOne(optional = false)
    private Prestamos prestamosIdprestamos;

    public Transanciones() {
    }

    public Transanciones(Integer idTransanciones) {
        this.idTransanciones = idTransanciones;
    }

    public Transanciones(Integer idTransanciones, String cantidad) {
        this.idTransanciones = idTransanciones;
        this.cantidad = cantidad;
    }

    public Integer getIdTransanciones() {
        return idTransanciones;
    }

    public void setIdTransanciones(Integer idTransanciones) {
        this.idTransanciones = idTransanciones;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Material getMaterialIdmaterial() {
        return materialIdmaterial;
    }

    public void setMaterialIdmaterial(Material materialIdmaterial) {
        this.materialIdmaterial = materialIdmaterial;
    }

    public Prestamos getPrestamosIdprestamos() {
        return prestamosIdprestamos;
    }

    public void setPrestamosIdprestamos(Prestamos prestamosIdprestamos) {
        this.prestamosIdprestamos = prestamosIdprestamos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransanciones != null ? idTransanciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transanciones)) {
            return false;
        }
        Transanciones other = (Transanciones) object;
        if ((this.idTransanciones == null && other.idTransanciones != null) || (this.idTransanciones != null && !this.idTransanciones.equals(other.idTransanciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Transanciones[ idTransanciones=" + idTransanciones + " ]";
    }
    
}
