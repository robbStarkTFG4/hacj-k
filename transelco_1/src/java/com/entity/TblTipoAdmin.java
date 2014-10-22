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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "tbl_tipo_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoAdmin.findAll", query = "SELECT t FROM TblTipoAdmin t"),
    @NamedQuery(name = "TblTipoAdmin.findByIdtblTipoAdmin", query = "SELECT t FROM TblTipoAdmin t WHERE t.idtblTipoAdmin = :idtblTipoAdmin"),
    @NamedQuery(name = "TblTipoAdmin.findByDescripcion", query = "SELECT t FROM TblTipoAdmin t WHERE t.descripcion = :descripcion")})
public class TblTipoAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbl_tipo_admin")
    private Integer idtblTipoAdmin;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblTipoAdminIdtblTipoAdmin")
    private List<TblAdmin> tblAdminList;

    public TblTipoAdmin() {
    }

    public TblTipoAdmin(Integer idtblTipoAdmin) {
        this.idtblTipoAdmin = idtblTipoAdmin;
    }

    public Integer getIdtblTipoAdmin() {
        return idtblTipoAdmin;
    }

    public void setIdtblTipoAdmin(Integer idtblTipoAdmin) {
        this.idtblTipoAdmin = idtblTipoAdmin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TblAdmin> getTblAdminList() {
        return tblAdminList;
    }

    public void setTblAdminList(List<TblAdmin> tblAdminList) {
        this.tblAdminList = tblAdminList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblTipoAdmin != null ? idtblTipoAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoAdmin)) {
            return false;
        }
        TblTipoAdmin other = (TblTipoAdmin) object;
        if ((this.idtblTipoAdmin == null && other.idtblTipoAdmin != null) || (this.idtblTipoAdmin != null && !this.idtblTipoAdmin.equals(other.idtblTipoAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.TblTipoAdmin[ idtblTipoAdmin=" + idtblTipoAdmin + " ]";
    }
    
}
