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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Robert
 */
@Entity
@Table(name = "EDITORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editorstb.findAll", query = "SELECT e FROM Editorstb e"),
    @NamedQuery(name = "Editorstb.findById", query = "SELECT e FROM Editorstb e WHERE e.id = :id"),
    @NamedQuery(name = "Editorstb.findByUsername", query = "SELECT e FROM Editorstb e WHERE e.username = :username"),
    @NamedQuery(name = "Editorstb.findByDateofbirth", query = "SELECT e FROM Editorstb e WHERE e.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Editorstb.findByIsadmin", query = "SELECT e FROM Editorstb e WHERE e.isadmin = :isadmin"),
    @NamedQuery(name = "Editorstb.findByTotallogins", query = "SELECT e FROM Editorstb e WHERE e.totallogins = :totallogins")})
public class Editorstb implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Column(name = "ISADMIN")
    private Boolean isadmin;
    @Column(name = "TOTALLOGINS")
    private Integer totallogins;
    @OneToMany(mappedBy = "editorstb", cascade=CascadeType.REMOVE)
    private List<Productstb> productstbList;

    public Editorstb() {
    }

    public Editorstb(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        Date oldDateofbirth = this.dateofbirth;
        this.dateofbirth = dateofbirth;
        changeSupport.firePropertyChange("dateofbirth", oldDateofbirth, dateofbirth);
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        Boolean oldIsadmin = this.isadmin;
        this.isadmin = isadmin;
        changeSupport.firePropertyChange("isadmin", oldIsadmin, isadmin);
    }

    public Integer getTotallogins() {
        return totallogins;
    }

    public void setTotallogins(Integer totallogins) {
        Integer oldTotallogins = this.totallogins;
        this.totallogins = totallogins;
        changeSupport.firePropertyChange("totallogins", oldTotallogins, totallogins);
    }

    @XmlTransient
    public List<Productstb> getProductstbList() {
        return productstbList;
    }

    public void setProductstbList(List<Productstb> productstbList) {
        this.productstbList = productstbList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorstb)) {
            return false;
        }
        Editorstb other = (Editorstb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
