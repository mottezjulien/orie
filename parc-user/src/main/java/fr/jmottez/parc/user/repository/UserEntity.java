package fr.jmottez.parc.user.repository;

import fr.jmottez.parc.generic.entity.AbstractEntityUuId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity extends AbstractEntityUuId {

    @Column(name = "LOGIN")
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
