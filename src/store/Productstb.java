/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robert
 */
@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productstb.findAll", query = "SELECT p FROM Productstb p"),
    @NamedQuery(name = "Productstb.findBySku", query = "SELECT p FROM Productstb p WHERE p.sku = :sku"),
    @NamedQuery(name = "Productstb.findByProductname", query = "SELECT p FROM Productstb p WHERE p.productname = :productname"),
    @NamedQuery(name = "Productstb.findByDescription", query = "SELECT p FROM Productstb p WHERE p.description = :description"),
    @NamedQuery(name = "Productstb.findByDateadded", query = "SELECT p FROM Productstb p WHERE p.dateadded = :dateadded"),
    @NamedQuery(name = "Productstb.findByIsdigital", query = "SELECT p FROM Productstb p WHERE p.isdigital = :isdigital"),
    @NamedQuery(name = "Productstb.findByPrice", query = "SELECT p FROM Productstb p WHERE p.price = :price")})
public class Productstb implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SKU")
    private Integer sku;
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.DATE)
    private Date dateadded;
    @Column(name = "ISDIGITAL")
    private Boolean isdigital;
    @Column(name = "PRICE")
    private Integer price;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "ID")
    @ManyToOne
    private Editorstb editorstb;

    public Productstb() {
    }

    public Productstb(Integer sku) {
        this.sku = sku;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        Integer oldSku = this.sku;
        this.sku = sku;
        changeSupport.firePropertyChange("sku", oldSku, sku);
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        String oldProductname = this.productname;
        this.productname = productname;
        changeSupport.firePropertyChange("productname", oldProductname, productname);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        Date oldDateadded = this.dateadded;
        this.dateadded = dateadded;
        changeSupport.firePropertyChange("dateadded", oldDateadded, dateadded);
    }

    public Boolean getIsdigital() {
        return isdigital;
    }

    public void setIsdigital(Boolean isdigital) {
        Boolean oldIsdigital = this.isdigital;
        this.isdigital = isdigital;
        changeSupport.firePropertyChange("isdigital", oldIsdigital, isdigital);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        Integer oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Editorstb getEditorstb() {
        return editorstb;
    }

    public void setEditorstb(Editorstb editorstb) {
        Editorstb oldEditorstb = this.editorstb;
        this.editorstb = editorstb;
        changeSupport.firePropertyChange("editorstb", oldEditorstb, editorstb);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sku != null ? sku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productstb)) {
            return false;
        }
        Productstb other = (Productstb) object;
        if ((this.sku == null && other.sku != null) || (this.sku != null && !this.sku.equals(other.sku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "store.Productstb[ sku=" + sku + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
