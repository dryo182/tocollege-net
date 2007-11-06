package com.apress.progwt.client.domain.generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apress.progwt.client.domain.ProcessType;
import com.apress.progwt.client.domain.SchoolAndAppProcess;

// Generated Oct 31, 2006 9:16:47 AM by Hibernate Tools 3.1.0.beta5

/**
 * AbstractUser generated by hbm2java
 */
public abstract class AbstractUser implements java.io.Serializable {

    // Fields

    private String email;
    private boolean enabled;
    private long id;
    private int invitations;

    /**
     * don't serialize and pass around the hashed password
     */
    private transient String password;

    private Date dateCreated;

    private List<SchoolAndAppProcess> schoolRankings = new ArrayList<SchoolAndAppProcess>();

    private List<ProcessType> processTypes = new ArrayList<ProcessType>();

    private boolean supervisor;

    private String username;
    private String nickname;

    // Constructors

    /** default constructor */
    public AbstractUser() {
    }

    /** full constructor */
    public AbstractUser(String username, String password,
            boolean enabled, boolean supervisor) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.supervisor = supervisor;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof AbstractUser))
            return false;
        AbstractUser castOther = (AbstractUser) other;

        return ((this.getUsername() == castOther.getUsername()) || (this
                .getUsername() != null
                && castOther.getUsername() != null && this.getUsername()
                .equals(castOther.getUsername())));
    }

    // Property accessors
    public long getId() {
        return this.id;
    }

    public int getInvitations() {
        return invitations;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (getUsername() == null ? 0 : this.getUsername()
                        .hashCode());

        return result;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isSupervisor() {
        return this.supervisor;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInvitations(int invitations) {
        this.invitations = invitations;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSupervisor(boolean supervisor) {
        this.supervisor = supervisor;
    }

    public List<SchoolAndAppProcess> getSchoolRankings() {
        return schoolRankings;
    }

    public void setSchoolRankings(List<SchoolAndAppProcess> schoolRankings) {
        this.schoolRankings = schoolRankings;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<ProcessType> getProcessTypes() {
        return processTypes;
    }

    public void setProcessTypes(List<ProcessType> processTypes) {
        this.processTypes = processTypes;
    }

}
