/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.pojo;

import java.io.Serializable;
import java.util.Set;
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
 * @author DELL
 */
@Entity
@Table(name = "criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criteria.findAll", query = "SELECT c FROM Criteria c"),
    @NamedQuery(name = "Criteria.findByCriteriaId", query = "SELECT c FROM Criteria c WHERE c.criteriaId = :criteriaId"),
    @NamedQuery(name = "Criteria.findByCriteriaDescription", query = "SELECT c FROM Criteria c WHERE c.criteriaDescription = :criteriaDescription")})
public class Criteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "criteria_id")
    private Integer criteriaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "criteria_description")
    private String criteriaDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriaId")
    private Set<ThesisCriteria> thesisCriteriaSet;

    public Criteria() {
    }

    public Criteria(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Criteria(Integer criteriaId, String criteriaDescription) {
        this.criteriaId = criteriaId;
        this.criteriaDescription = criteriaDescription;
    }

    public Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

    @XmlTransient
    public Set<ThesisCriteria> getThesisCriteriaSet() {
        return thesisCriteriaSet;
    }

    public void setThesisCriteriaSet(Set<ThesisCriteria> thesisCriteriaSet) {
        this.thesisCriteriaSet = thesisCriteriaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriaId != null ? criteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criteria)) {
            return false;
        }
        Criteria other = (Criteria) object;
        if ((this.criteriaId == null && other.criteriaId != null) || (this.criteriaId != null && !this.criteriaId.equals(other.criteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbn.pojo.Criteria[ criteriaId=" + criteriaId + " ]";
    }
    
}
