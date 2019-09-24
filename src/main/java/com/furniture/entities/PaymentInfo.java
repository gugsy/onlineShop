/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariona
 */
@Entity
@Table(name = "paymentInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentInfo.findAll", query = "SELECT p FROM PaymentInfo p")
    , @NamedQuery(name = "PaymentInfo.findById", query = "SELECT p FROM PaymentInfo p WHERE p.id = :id")
    , @NamedQuery(name = "PaymentInfo.findByName", query = "SELECT p FROM PaymentInfo p WHERE p.name = :name")
    , @NamedQuery(name = "PaymentInfo.findBySurame", query = "SELECT p FROM PaymentInfo p WHERE p.surame = :surame")
    , @NamedQuery(name = "PaymentInfo.findByCompanyName", query = "SELECT p FROM PaymentInfo p WHERE p.companyName = :companyName")
    , @NamedQuery(name = "PaymentInfo.findByEmail", query = "SELECT p FROM PaymentInfo p WHERE p.email = :email")
    , @NamedQuery(name = "PaymentInfo.findByPhoneNumber", query = "SELECT p FROM PaymentInfo p WHERE p.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "PaymentInfo.findByAmount", query = "SELECT p FROM PaymentInfo p WHERE p.amount = :amount")
    , @NamedQuery(name = "PaymentInfo.findByPollurl", query = "SELECT p FROM PaymentInfo p WHERE p.pollurl = :pollurl")
    , @NamedQuery(name = "PaymentInfo.findByBrowseurl", query = "SELECT p FROM PaymentInfo p WHERE p.browseurl = :browseurl")
    , @NamedQuery(name = "PaymentInfo.findByResulturl", query = "SELECT p FROM PaymentInfo p WHERE p.resulturl = :resulturl")
    , @NamedQuery(name = "PaymentInfo.findByPaynowReference", query = "SELECT p FROM PaymentInfo p WHERE p.paynowReference = :paynowReference")
    , @NamedQuery(name = "PaymentInfo.findByAddress", query = "SELECT p FROM PaymentInfo p WHERE p.address = :address")
    , @NamedQuery(name = "PaymentInfo.findByComment", query = "SELECT p FROM PaymentInfo p WHERE p.comment = :comment")})
public class PaymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "surame")
    private String surame;
    @Size(max = 50)
    @Column(name = "companyName")
    private String companyName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Size(max = 50)
    @Column(name = "amount")
    private String amount;
    @Size(max = 50)
    @Column(name = "pollurl")
    private String pollurl;
    @Size(max = 50)
    @Column(name = "browseurl")
    private String browseurl;
    @Size(max = 50)
    @Column(name = "resulturl")
    private String resulturl;
    @Size(max = 50)
    @Column(name = "paynowReference")
    private String paynowReference;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "comment")
    private String comment;

    public PaymentInfo() {
    }

    public PaymentInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurame() {
        return surame;
    }

    public void setSurame(String surame) {
        this.surame = surame;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPollurl() {
        return pollurl;
    }

    public void setPollurl(String pollurl) {
        this.pollurl = pollurl;
    }

    public String getBrowseurl() {
        return browseurl;
    }

    public void setBrowseurl(String browseurl) {
        this.browseurl = browseurl;
    }

    public String getResulturl() {
        return resulturl;
    }

    public void setResulturl(String resulturl) {
        this.resulturl = resulturl;
    }

    public String getPaynowReference() {
        return paynowReference;
    }

    public void setPaynowReference(String paynowReference) {
        this.paynowReference = paynowReference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof PaymentInfo)) {
            return false;
        }
        PaymentInfo other = (PaymentInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furniture.entities.PaymentInfo[ id=" + id + " ]";
    }
    
}
