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
 * @author DELL
 */
@Entity
@Table(name = "thesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thesis.findAll", query = "SELECT t FROM Thesis t"),
    @NamedQuery(name = "Thesis.findByThesisId", query = "SELECT t FROM Thesis t WHERE t.thesisId = :thesisId"),
    @NamedQuery(name = "Thesis.findByTitle", query = "SELECT t FROM Thesis t WHERE t.title = :title"),
    @NamedQuery(name = "Thesis.findByYearThesis", query = "SELECT t FROM Thesis t WHERE t.yearThesis = :yearThesis"),
    @NamedQuery(name = "Thesis.findByStatus", query = "SELECT t FROM Thesis t WHERE t.status = :status"),
    @NamedQuery(name = "Thesis.findByAverageScore", query = "SELECT t FROM Thesis t WHERE t.averageScore = :averageScore"),
    @NamedQuery(name = "Thesis.findByTotalScore", query = "SELECT t FROM Thesis t WHERE t.totalScore = :totalScore")})
public class Thesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "thesis_id")
    private Integer thesisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Column(name = "year_thesis")
    private Integer yearThesis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "average_score")
    private Float averageScore;
    @Column(name = "total_score")
    private Float totalScore;
    @JoinColumn(name = "committee_id", referencedColumnName = "committee_id")
    @ManyToOne
    private Committee committeeId;
    @JoinColumn(name = "adviser_1_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users adviser1Id;
    @JoinColumn(name = "adviser_2_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users adviser2Id;
    @JoinColumn(name = "student_1_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users student1Id;
    @JoinColumn(name = "student_2_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users student2Id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thesisId")
    private Set<ThesisCriteria> thesisCriteriaSet;

    public Thesis() {
    }

    public Thesis(Integer thesisId) {
        this.thesisId = thesisId;
    }

    public Thesis(Integer thesisId, String title, String status) {
        this.thesisId = thesisId;
        this.title = title;
        this.status = status;
    }

    public Integer getThesisId() {
        return thesisId;
    }

    public void setThesisId(Integer thesisId) {
        this.thesisId = thesisId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearThesis() {
        return yearThesis;
    }

    public void setYearThesis(Integer yearThesis) {
        this.yearThesis = yearThesis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    public Committee getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Committee committeeId) {
        this.committeeId = committeeId;
    }

    public Users getAdviser1Id() {
        return adviser1Id;
    }

    public void setAdviser1Id(Users adviser1Id) {
        this.adviser1Id = adviser1Id;
    }

    public Users getAdviser2Id() {
        return adviser2Id;
    }

    public void setAdviser2Id(Users adviser2Id) {
        this.adviser2Id = adviser2Id;
    }

    public Users getStudent1Id() {
        return student1Id;
    }

    public void setStudent1Id(Users student1Id) {
        this.student1Id = student1Id;
    }

    public Users getStudent2Id() {
        return student2Id;
    }

    public void setStudent2Id(Users student2Id) {
        this.student2Id = student2Id;
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
        hash += (thesisId != null ? thesisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thesis)) {
            return false;
        }
        Thesis other = (Thesis) object;
        if ((this.thesisId == null && other.thesisId != null) || (this.thesisId != null && !this.thesisId.equals(other.thesisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbn.pojo.Thesis[ thesisId=" + thesisId + " ]";
    }
    
}
