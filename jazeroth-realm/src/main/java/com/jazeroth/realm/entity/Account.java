package com.jazeroth.realm.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @Column(length = 40, nullable = false)
    private String password;

    @Column(nullable = false)
    private byte gmLevel;

    @Column(columnDefinition = "TEXT")
    private String sessionKey;

    @Column(columnDefinition = "TEXT")
    private String v;

    @Column(columnDefinition = "TEXT")
    private String s;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(nullable = false)
    private boolean locked;

    @Column(length = 30)
    private String lastLogonIp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogonTime;

    @Column(nullable = false)
    private int activeRealmId;

    @Column(nullable = false)
    private byte locale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getGmLevel() {
        return gmLevel;
    }

    public void setGmLevel(byte gmLevel) {
        this.gmLevel = gmLevel;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getLastLogonIp() {
        return lastLogonIp;
    }

    public void setLastLogonIp(String lastLogonIp) {
        this.lastLogonIp = lastLogonIp;
    }

    public Date getLastLogonTime() {
        return lastLogonTime;
    }

    public void setLastLogonTime(Date lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }

    public int getActiveRealmId() {
        return activeRealmId;
    }

    public void setActiveRealmId(int activeRealmId) {
        this.activeRealmId = activeRealmId;
    }

    public byte getLocale() {
        return locale;
    }

    public void setLocale(byte locale) {
        this.locale = locale;
    }
}
