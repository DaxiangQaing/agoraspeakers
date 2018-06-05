package org.agoraspeakers.cms.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users")
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column
    private String username;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @Column
    private String password;
    @Column
    private String pwdresettoken;
    @Column
    private String rememberme;
    @Column
    private Date remembermeexpiration;
    @Column
    private String authtoken;
    @Column
    private Date authtokenexpiration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdresettoken() {
        return pwdresettoken;
    }

    public void setPwdresettoken(String pwdresettoken) {
        this.pwdresettoken = pwdresettoken;
    }

    public String getRememberme() {
        return rememberme;
    }

    public void setRememberme(String rememberme) {
        this.rememberme = rememberme;
    }

    public Date getRemembermeexpiration() {
        return remembermeexpiration;
    }

    public void setRemembermeexpiration(Date remembermeexpiration) {
        this.remembermeexpiration = remembermeexpiration;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public Date getAuthtokenexpiration() {
        return authtokenexpiration;
    }

    public void setAuthtokenexpiration(Date authtokenexpiration) {
        this.authtokenexpiration = authtokenexpiration;
    }
}
