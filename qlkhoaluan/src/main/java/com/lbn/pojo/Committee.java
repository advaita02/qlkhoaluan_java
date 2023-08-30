/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "committee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Committee.findAll", query = "SELECT c FROM Committee c"),
    @NamedQuery(name = "Committee.findByCommitteeId", query = "SELECT c FROM Committee c WHERE c.committeeId = :committeeId"),
    @NamedQuery(name = "Committee.findByNameCommitee", query = "SELECT c FROM Committee c WHERE c.nameCommitee = :nameCommitee"),
    @NamedQuery(name = "Committee.findByLockCommittee", query = "SELECT c FROM Committee c WHERE c.lockCommittee = :lockCommittee")})
public class Committee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "committee_id")
    private Integer committeeId;
    @Size(max = 255)
    @Column(name = "name_commitee")
    private String nameCommitee;
    @Column(name = "lock_committee")
    private Boolean lockCommittee;
    @Lob
    @Size(max = 65535)
    @Column(name = "description_commitee")
    private String descriptionCommitee;
    @OneToMany(mappedBy = "committeeId")
    private Set<Thesis> thesisSet;
    @OneToMany(mappedBy = "committeeId")
    private Set<CommitteeMember> committeeMemberSet;

    public Committee() {
    }

    public Committee(Integer committeeId) {
        this.committeeId = committeeId;
    }

    public Integer getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Integer committeeId) {
        this.committeeId = committeeId;
    }

    public String getNameCommitee() {
        return nameCommitee;
    }

    public void setNameCommitee(String nameCommitee) {
        this.nameCommitee = nameCommitee;
    }

    public Boolean getLockCommittee() {
        return lockCommittee;
    }

    public void setLockCommittee(Boolean lockCommittee) {
        this.lockCommittee = lockCommittee;
    }

    public String getDescriptionCommitee() {
        return descriptionCommitee;
    }

    public void setDescriptionCommitee(String descriptionCommitee) {
        this.descriptionCommitee = descriptionCommitee;
    }

    @XmlTransient
    public Set<Thesis> getThesisSet() {
        return thesisSet;
    }

    public void setThesisSet(Set<Thesis> thesisSet) {
        this.thesisSet = thesisSet;
    }

    @XmlTransient
    public Set<CommitteeMember> getCommitteeMemberSet() {
        return committeeMemberSet;
    }

    public void setCommitteeMemberSet(Set<CommitteeMember> committeeMemberSet) {
        this.committeeMemberSet = committeeMemberSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (committeeId != null ? committeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Committee)) {
            return false;
        }
        Committee other = (Committee) object;
        if ((this.committeeId == null && other.committeeId != null) || (this.committeeId != null && !this.committeeId.equals(other.committeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lbn.pojo.Committee[ committeeId=" + committeeId + " ]";
    }
    
}
