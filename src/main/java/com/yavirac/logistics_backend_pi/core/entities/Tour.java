package com.yavirac.logistics_backend_pi.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;

import java.util.Date;
import java.util.Set;

import com.yavirac.logistics_backend_pi.auth.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer days_duration;
    @Column(nullable = false)
    private String sector;
    @Column(nullable = false)
    private Integer capacity_quotes;
    @Column(nullable = false)
    // private image
    private Date start_date;
    @Column(nullable = false)
    private Boolean enable;

    // * Relations*/
    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Transport transport;

    @ManyToMany(mappedBy = "tours", cascade = CascadeType.ALL)
    private Set<User> users;

}
