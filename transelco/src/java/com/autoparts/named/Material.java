/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.autoparts.named;

import com.autoparts.models.Register;
import com.entity.MaterialFacade;
import com.entity.SubFamilia;
import com.entity.SubFamiliaFacade;
import com.entity.TblAdmin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author cristian
 */
@SessionScoped
@Named("mat")

public class Material implements  Serializable{
 private String noparte;
 private String nombre;
 private String descripcion;
 private String marca;
 private String stock;
 private String  sf;
 private TblAdmin admin;
  private String imagen;
  private boolean disableguardar=true;
    private final String ruta = "C:\\Users\\NORE\\Documents\\GitHub\\baratheon\\almacen\\web\\resources\\imagenes\\";
   private UploadedFile file;
    List<SubFamilia> listSF;
@EJB MaterialFacade matfac;
@EJB SubFamiliaFacade subfac;
@Inject Register reg;


    public boolean isDisableguardar() {
        return disableguardar;
    }

    public void setDisableguardar(boolean disableguardar) {
        this.disableguardar = disableguardar;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<SubFamilia> getListSF() {
        this.listSF=subfac.findAll();
        return listSF;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

  

    public TblAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(TblAdmin admin) {
        this.admin = admin;
    }


    public String getNoparte() {
        return noparte;
    }

    public void setNoparte(String noparte) {
        this.noparte = noparte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    

    
 public void agregarmat() {
        boolean hecho;
admin=reg.getAdministrador();
             hecho = matfac.agregar(nombre,noparte,descripcion,stock,marca,this.sf,this.admin, imagen );


        if (hecho == true) {
    
            nombre = null;
            noparte = null;
            descripcion = null;
            marca = null;
            stock=null;
            marca=null;
            imagen=null;
            this.sf=null;
            this.admin=null;
            disableguardar=true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "El material se ha agregado con exito!!"));

            // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));
        }

    }   
    
  public void dialogimagen() {
      
        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 150);
        options.put("contentWidth", 400);
        RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml", options, null);

        // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");
    }
  
  public void imprime (){
      admin=reg.getAdministrador();
  
      System.out.println(nombre);
      System.out.println(noparte);
      System.out.println(descripcion);
      System.out.println(marca);
      System.out.println(stock);
      System.out.println(imagen);
      System.out.println(sf);
      System.out.println(admin);
      
  }
  
  
  
  public void upload() {
        if (file != null) {
            //FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + "is uploaded");
            //FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                guardarImagen(file.getFileName(), file.getInputstream());
                System.out.println(file.getFileName());
                //  RequestContext.getCurrentInstance().update("formadatos:tbw1");
                if (file.getFileName().equals("")) {
                    System.out.println("no img");
                } else {
                    disableguardar = false;
                    RequestContext.getCurrentInstance().update("formaMat:panel");
                    RequestContext.getCurrentInstance().closeDialog(null);
                }
            } catch (IOException ex) {
                //Logger.getLogger(Image.class.getName()).log(Level.SEVERE,null,ex));
            }
        }
    }

   public void guardarImagen(String nombre, InputStream in) {
        imagen = nombre;
       
        try {
            OutputStream out = new FileOutputStream(new File(ruta + nombre));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
            System.out.println("Archivo Guardado");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
   public void cerrar(){

 RequestContext.getCurrentInstance().closeDialog(null);
 }
}
