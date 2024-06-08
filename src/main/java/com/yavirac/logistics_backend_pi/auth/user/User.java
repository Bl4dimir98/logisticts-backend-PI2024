package com.yavirac.logistics_backend_pi.auth.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yavirac.logistics_backend_pi.core.entities.Tour;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(nullable = false)
    private String fullnames;
    @Column(nullable = false)
    private String lastnames;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_tour", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = {@JoinColumn(name = "tour_id") })
    @Builder.Default
    private Set<Tour> tours = new HashSet<>();

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
