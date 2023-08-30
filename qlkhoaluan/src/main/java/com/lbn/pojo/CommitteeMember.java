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
@Table(name = "committee_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommitteeMember.findAll", query = "SELECT c FROM CommitteeMember c"),
    @NamedQuery(name = "CommitteeMember.findByCommitteeMemberId", query = "SELECT c FROM CommitteeMember c WHERE c.committeeMemberId = :committeeMemberId"),
    @NamedQuery(name = "CommitteeMember.findByRole", query = "SELECT c FROM CommitteeMember c WHERE c.role = :role")})
public class CommitteeMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "committee_member_id")
    private Integer committeeMemberId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scoreByCommitteeMembers")
    private Set<ScoreThesisCriteria> scoreThesisCriteriaSet;
    @JoinColumn(name = "committee_id", referencedColumnName = "committee_id")
    @ManyToOne
    private Committee committeeId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public CommitteeMember() {
    }

    public CommitteeMember(Integer committeeMemberId) {
        this.committeeMemberId = committeeMemberId;
    }

    public CommitteeMember(Integer committeeMemberId, String role) {
        this.committeeMemberId = committeeMemberId;
        this.role = role;
    }

    public Integer getCommitteeMemberId() {
        return committeeMemberId;
    }

    public void setCommitteeMemberId(Integer committeeMemberId) {
        this.committeeMemberId = committeeMemberId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Set<ScoreThesisCriteria> getScoreThesisCriteriaSet() {
        return scoreThesisCriteriaSet;
    }

    public void setScoreThesisCriteriaSet(Set<ScoreThesisCriteria> scoreThesisCriteriaSet) {
        this.scoreThesisCriteriaSet = scoreThesisCriteriaSet;
    }

    public Committee getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Committee committeeId) {
        this.committeeId = committeeId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (committeeMemberId != null ? committeeMemberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommitteeMember)) {
            return false;
        }
        CommitteeMember other = (CommitteeMember) object;
        if ((this.committeeMemberId == null && other.committeeMemberId != null) || (this.committeeMemberId != null && !this.committeeMemberId.equals(other.committeeMemberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbn.pojo.CommitteeMember[ committeeMemberId=" + committeeMemberId + " ]";
    }
    
}
