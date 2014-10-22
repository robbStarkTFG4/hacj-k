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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "sub_familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubFamilia.findAll", query = "SELECT s FROM SubFamilia s"),
    @NamedQuery(name = "SubFamilia.findByIdsubFamilia", query = "SELECT s FROM SubFamilia s WHERE s.idsubFamilia = :idsubFamilia"),
    @NamedQuery(name = "SubFamilia.findByDescripcion", query = "SELECT s FROM SubFamilia s WHERE s.descripcion = :descripcion")})
public class SubFamilia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsub_familia")
    private Integer idsubFamilia;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subFamiliaIdsubFamilia")
    private List<Material> materialList;
    @JoinColumn(name = "familia_idfamilia", referencedColumnName = "idfamilia")
    @ManyToOne(optional = false)
    private Familia familiaIdfamilia;

    public SubFamilia() {
    }

    public SubFamilia(Integer idsubFamilia) {
        this.idsubFamilia = idsubFamilia;
    }

    public Integer getIdsubFamilia() {
        return idsubFamilia;
    }

    public void setIdsubFamilia(Integer idsubFamilia) {
        this.idsubFamilia = idsubFamilia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public Familia getFamiliaIdfamilia() {
        return familiaIdfamilia;
    }

    public void setFamiliaIdfamilia(Familia familiaIdfamilia) {
        this.familiaIdfamilia = familiaIdfamilia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubFamilia != null ? idsubFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubFamilia)) {
            return false;
        }
        SubFamilia other = (SubFamilia) object;
        if ((this.idsubFamilia == null && other.idsubFamilia != null) || (this.idsubFamilia != null && !this.idsubFamilia.equals(other.idsubFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.SubFamilia[ idsubFamilia=" + idsubFamilia + " ]";
    }
    
}
