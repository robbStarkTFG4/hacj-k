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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdmaterial", query = "SELECT m FROM Material m WHERE m.idmaterial = :idmaterial"),
    @NamedQuery(name = "Material.findByNoParte", query = "SELECT m FROM Material m WHERE m.noParte = :noParte"),
    @NamedQuery(name = "Material.findByNombre", query = "SELECT m FROM Material m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Material.findByMarca", query = "SELECT m FROM Material m WHERE m.marca = :marca"),
    @NamedQuery(name = "Material.findByDescripcion", query = "SELECT m FROM Material m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Material.findByStock", query = "SELECT m FROM Material m WHERE m.stock = :stock"),
    @NamedQuery(name = "Material.findByMaterialcol", query = "SELECT m FROM Material m WHERE m.materialcol = :materialcol")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmaterial")
    private Integer idmaterial;
    @Size(max = 45)
    @Column(name = "noParte")
    private String noParte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "stock")
    private String stock;
    @Size(max = 45)
    @Column(name = "materialcol")
    private String materialcol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialIdmaterial")
    private List<Transanciones> transancionesList;
    @JoinColumn(name = "tbl_admin_idtbl_admin", referencedColumnName = "idtbl_admin")
    @ManyToOne(optional = false)
    private TblAdmin tblAdminIdtblAdmin;
    @JoinColumn(name = "sub_familia_idsub_familia", referencedColumnName = "idsub_familia")
    @ManyToOne(optional = false)
    private SubFamilia subFamiliaIdsubFamilia;

    public Material() {
    }

    public Material(Integer idmaterial) {
        this.idmaterial = idmaterial;
    }

    public Material(Integer idmaterial, String nombre, String marca) {
        this.idmaterial = idmaterial;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Integer getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(Integer idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getMaterialcol() {
        return materialcol;
    }

    public void setMaterialcol(String materialcol) {
        this.materialcol = materialcol;
    }

    @XmlTransient
    public List<Transanciones> getTransancionesList() {
        return transancionesList;
    }

    public void setTransancionesList(List<Transanciones> transancionesList) {
        this.transancionesList = transancionesList;
    }

    public TblAdmin getTblAdminIdtblAdmin() {
        return tblAdminIdtblAdmin;
    }

    public void setTblAdminIdtblAdmin(TblAdmin tblAdminIdtblAdmin) {
        this.tblAdminIdtblAdmin = tblAdminIdtblAdmin;
    }

    public SubFamilia getSubFamiliaIdsubFamilia() {
        return subFamiliaIdsubFamilia;
    }

    public void setSubFamiliaIdsubFamilia(SubFamilia subFamiliaIdsubFamilia) {
        this.subFamiliaIdsubFamilia = subFamiliaIdsubFamilia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterial != null ? idmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idmaterial == null && other.idmaterial != null) || (this.idmaterial != null && !this.idmaterial.equals(other.idmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Material[ idmaterial=" + idmaterial + " ]";
    }
    
}
