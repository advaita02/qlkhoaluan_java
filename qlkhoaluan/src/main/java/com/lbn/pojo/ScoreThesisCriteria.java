/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "score_thesis_criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScoreThesisCriteria.findAll", query = "SELECT s FROM ScoreThesisCriteria s"),
    @NamedQuery(name = "ScoreThesisCriteria.findByScoreThesisCriteriaId", query = "SELECT s FROM ScoreThesisCriteria s WHERE s.scoreThesisCriteriaId = :scoreThesisCriteriaId"),
    @NamedQuery(name = "ScoreThesisCriteria.findByScore", query = "SELECT s FROM ScoreThesisCriteria s WHERE s.score = :score")})
public class ScoreThesisCriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "score_thesis_criteria_id")
    private Integer scoreThesisCriteriaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private float score;
    @Lob
    @Size(max = 65535)
    @Column(name = "description_score")
    private String descriptionScore;
    @JoinColumn(name = "score_by_committee_members", referencedColumnName = "committee_member_id")
    @ManyToOne(optional = false)
    private CommitteeMember scoreByCommitteeMembers;
    @JoinColumn(name = "thesis_criteria_id", referencedColumnName = "thesis_criteria_id")
    @ManyToOne(optional = false)
    private ThesisCriteria thesisCriteriaId;

    public ScoreThesisCriteria() {
    }

    public ScoreThesisCriteria(Integer scoreThesisCriteriaId) {
        this.scoreThesisCriteriaId = scoreThesisCriteriaId;
    }

    public ScoreThesisCriteria(Integer scoreThesisCriteriaId, float score) {
        this.scoreThesisCriteriaId = scoreThesisCriteriaId;
        this.score = score;
    }

    public Integer getScoreThesisCriteriaId() {
        return scoreThesisCriteriaId;
    }

    public void setScoreThesisCriteriaId(Integer scoreThesisCriteriaId) {
        this.scoreThesisCriteriaId = scoreThesisCriteriaId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getDescriptionScore() {
        return descriptionScore;
    }

    public void setDescriptionScore(String descriptionScore) {
        this.descriptionScore = descriptionScore;
    }

    public CommitteeMember getScoreByCommitteeMembers() {
        return scoreByCommitteeMembers;
    }

    public void setScoreByCommitteeMembers(CommitteeMember scoreByCommitteeMembers) {
        this.scoreByCommitteeMembers = scoreByCommitteeMembers;
    }

    public ThesisCriteria getThesisCriteriaId() {
        return thesisCriteriaId;
    }

    public void setThesisCriteriaId(ThesisCriteria thesisCriteriaId) {
        this.thesisCriteriaId = thesisCriteriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scoreThesisCriteriaId != null ? scoreThesisCriteriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScoreThesisCriteria)) {
            return false;
        }
        ScoreThesisCriteria other = (ScoreThesisCriteria) object;
        if ((this.scoreThesisCriteriaId == null && other.scoreThesisCriteriaId != null) || (this.scoreThesisCriteriaId != null && !this.scoreThesisCriteriaId.equals(other.scoreThesisCriteriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbn.pojo.ScoreThesisCriteria[ scoreThesisCriteriaId=" + scoreThesisCriteriaId + " ]";
    }
    
}
