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
@Table(name = "tbl_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmin.findAll", query = "SELECT t FROM TblAdmin t"),
    @NamedQuery(name = "TblAdmin.findByIdtblAdmin", query = "SELECT t FROM TblAdmin t WHERE t.idtblAdmin = :idtblAdmin"),
    @NamedQuery(name = "TblAdmin.findByNombre", query = "SELECT t FROM TblAdmin t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblAdmin.findByApellidoPaterno", query = "SELECT t FROM TblAdmin t WHERE t.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "TblAdmin.findByApellidoMaterno", query = "SELECT t FROM TblAdmin t WHERE t.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "TblAdmin.findByUsuario", query = "SELECT t FROM TblAdmin t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TblAdmin.findByContrase\u00f1a", query = "SELECT t FROM TblAdmin t WHERE t.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "TblAdmin.findByEmail", query = "SELECT t FROM TblAdmin t WHERE t.email = :email"),
    @NamedQuery(name = "TblAdmin.findByTelefono", query = "SELECT t FROM TblAdmin t WHERE t.telefono = :telefono")})
public class TblAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbl_admin")
    private Integer idtblAdmin;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Size(max = 45)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAdminIdtblAdmin")
    private List<Material> materialList;
    @JoinColumn(name = "tbl_tipo_admin_idtbl_tipo_admin", referencedColumnName = "idtbl_tipo_admin")
    @ManyToOne(optional = false)
    private TblTipoAdmin tblTipoAdminIdtblTipoAdmin;

    public TblAdmin() {
    }

    public TblAdmin(Integer idtblAdmin) {
        this.idtblAdmin = idtblAdmin;
    }

    public TblAdmin(Integer idtblAdmin, String usuario, String contraseña, String email) {
        this.idtblAdmin = idtblAdmin;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    public Integer getIdtblAdmin() {
        return idtblAdmin;
    }

    public void setIdtblAdmin(Integer idtblAdmin) {
        this.idtblAdmin = idtblAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public TblTipoAdmin getTblTipoAdminIdtblTipoAdmin() {
        return tblTipoAdminIdtblTipoAdmin;
    }

    public void setTblTipoAdminIdtblTipoAdmin(TblTipoAdmin tblTipoAdminIdtblTipoAdmin) {
        this.tblTipoAdminIdtblTipoAdmin = tblTipoAdminIdtblTipoAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblAdmin != null ? idtblAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmin)) {
            return false;
        }
        TblAdmin other = (TblAdmin) object;
        if ((this.idtblAdmin == null && other.idtblAdmin != null) || (this.idtblAdmin != null && !this.idtblAdmin.equals(other.idtblAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.TblAdmin[ idtblAdmin=" + idtblAdmin + " ]";
    }
    
}
