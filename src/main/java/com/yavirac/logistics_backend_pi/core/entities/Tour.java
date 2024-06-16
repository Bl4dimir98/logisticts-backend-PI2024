package com.yavirac.logistics_backend_pi.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

import com.yavirac.logistics_backend_pi.auth.user.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tours")
public class Tour {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer days_duration;
    private String sector;
    private Integer capacity_quotes;
    private Date start_date;
    // private Boolean enable;

    // * Relations*/
    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Transport transport;

    @ManyToMany(mappedBy = "tours", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;

}
