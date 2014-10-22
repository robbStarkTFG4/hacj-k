/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByIdfamilia", query = "SELECT f FROM Familia f WHERE f.idfamilia = :idfamilia"),
    @NamedQuery(name = "Familia.findByDescripcion", query = "SELECT f FROM Familia f WHERE f.descripcion = :descripcion")})
public class Familia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfamilia")
    private Integer idfamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familiaIdfamilia")
    private List<SubFamilia> subFamiliaList;

    public Familia() {
    }

    public Familia(Integer idfamilia) {
        this.idfamilia = idfamilia;
    }

    public Familia(Integer idfamilia, String descripcion) {
        this.idfamilia = idfamilia;
        this.descripcion = descripcion;
    }

    public Integer getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(Integer idfamilia) {
        this.idfamilia = idfamilia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<SubFamilia> getSubFamiliaList() {
        return subFamiliaList;
    }

    public void setSubFamiliaList(List<SubFamilia> subFamiliaList) {
        this.subFamiliaList = subFamiliaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfamilia != null ? idfamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.idfamilia == null && other.idfamilia != null) || (this.idfamilia != null && !this.idfamilia.equals(other.idfamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Familia[ idfamilia=" + idfamilia + " ]";
    }
    
}
