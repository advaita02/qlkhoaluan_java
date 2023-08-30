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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author DELL
 */
@Entity
@Table(name = "thesis_criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisCriteria.findAll", query = "SELECT t FROM ThesisCriteria t"),
    @NamedQuery(name = "ThesisCriteria.findByThesisCriteriaId", query = "SELECT t FROM ThesisCriteria t WHERE t.thesisCriteriaId = :thesisCriteriaId")})
public class ThesisCriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "thesis_criteria_id")
    private Integer thesisCriteriaId;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisCriteriaId")
    private Set<ScoreThesisCriteria> scoreThesisCriteriaSet;
    @JoinColumn(name = "criteria_id", referencedColumnName = "criteria_id")
    @ManyToOne(optional = false)
    private Criteria criteriaId;
    @JoinColumn(name = "thesis_id", referencedColumnName = "thesis_id")
    @ManyToOne(optional = false)
    private Thesis thesisId;

    public ThesisCriteria() {
    }

    public ThesisCriteria(Integer thesisCriteriaId) {
        this.thesisCriteriaId = thesisCriteriaId;
    }

    public Integer getThesisCriteriaId() {
        return thesisCriteriaId;
    }

    public void setThesisCriteriaId(Integer thesisCriteriaId) {
        this.thesisCriteriaId = thesisCriteriaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Set<ScoreThesisCriteria> getScoreThesisCriteriaSet() {
        return scoreThesisCriteriaSet;
    }

    public void setScoreThesisCriteriaSet(Set<ScoreThesisCriteria> scoreThesisCriteriaSet) {
        this.scoreThesisCriteriaSet = scoreThesisCriteriaSet;
    }

    public Criteria getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Criteria criteriaId) {
        this.criteriaId = criteriaId;
    }

    public Thesis getThesisId() {
        return thesisId;
    }

    public void setThesisId(Thesis thesisId) {
        this.thesisId = thesisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thesisCriteriaId != null ? thesisCriteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThesisCriteria)) {
            return false;
        }
        ThesisCriteria other = (ThesisCriteria) object;
        if ((this.thesisCriteriaId == null && other.thesisCriteriaId != null) || (this.thesisCriteriaId != null && !this.thesisCriteriaId.equals(other.thesisCriteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbn.pojo.ThesisCriteria[ thesisCriteriaId=" + thesisCriteriaId + " ]";
    }
    
}
