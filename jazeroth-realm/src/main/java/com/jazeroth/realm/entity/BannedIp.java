package com.jazeroth.realm.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BannedIp {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 32, nullable = false)
    private String ip;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date banDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date unbanDate;

    @Column(length = 50, nullable = false)
    private String banedBy;

    @Column(nullable = false)
    private String banedReason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getBanDate() {
        return banDate;
    }

    public void setBanDate(Date banDate) {
        this.banDate = banDate;
    }

    public Date getUnbanDate() {
        return unbanDate;
    }

    public void setUnbanDate(Date unbanDate) {
        this.unbanDate = unbanDate;
    }

    public String getBanedBy() {
        return banedBy;
    }

    public void setBanedBy(String banedBy) {
        this.banedBy = banedBy;
    }

    public String getBanedReason() {
        return banedReason;
    }

    public void setBanedReason(String banedReason) {
        this.banedReason = banedReason;
    }
}