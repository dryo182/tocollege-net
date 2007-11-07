package com.apress.progwt.client.domain;

//Generated Jul 18, 2006 12:44:47 PM by Hibernate Tools 3.1.0.beta4

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.apress.progwt.client.domain.generated.AbstractUser;

/**
 * User generated by hbm2java
 */

/**
 * Extended by ServerSideUser on the Server to implement UserDetails,
 * Since getting the acegisecurity jar into client side land was a no go.
 * 
 */
public class User extends AbstractUser implements Serializable, Loadable {

    public User() {
        setEnabled(true);
        setSupervisor(false);

    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    // @Override
    public String toString() {
        return "|" + getId() + ":" + getUsername() + "|";
    }

    /**
     * TODO PEND HIGH
     */
    public String getNickname() {
        if (isOpenID()) {
            String half = getUsername().replaceAll("http://", "");
            return half.replaceAll("/", "");
        }
        return getUsername();
    }

    private boolean isOpenID() {
        return getPassword() == null;
    }

    public void addRanked(SchoolAndAppProcess schoolAndAppProcess) {
        schoolAndAppProcess.setUser(this);
        getSchoolRankings().add(schoolAndAppProcess);
    }

    public void addRanked(int rank, SchoolAndAppProcess sap) {
        sap.setUser(this);
        getSchoolRankings().remove(sap);
        getSchoolRankings().add(rank, sap);
    }

    public List<RatingType> getRatingTypes() {
        ArrayList<RatingType> rtn = new ArrayList<RatingType>();
        rtn.add(new RatingType("Campus"));
        rtn.add(new RatingType("Location"));
        rtn.add(new RatingType("Sports"));
        rtn.add(new RatingType("Friendly"));
        rtn.add(new RatingType("Weather"));
        rtn.add(new RatingType("Teachers"));
        return rtn;
    }

}
