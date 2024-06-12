package com.yavirac.logistics_backend_pi.auth.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yavirac.logistics_backend_pi.core.entities.Tour;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    @Column(nullable = false)
    private String username;
    private String fullnames;
    private String lastnames;
    private String dni;
    private Integer phone;
    private String email;
    @Column(nullable = false)
    private String password;
    private String address;
    private String genre;
    private String bloodType;
    private String birthday;
    private String maritalState;
    private String emergencyContact;
    private Integer emergencyPhone;
    private String disease;
    private String disability;
    @Enumerated(EnumType.STRING)
    Role role;
    private Boolean enable;

    // * Relations*/
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_tour", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = {@JoinColumn(name = "tour_id") })
    private List<Tour> tours;

    // * Methods*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
