package com.yavirac.logistics_backend_pi.auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String fullnames;
    private String lastnames;
    private String dni;
    private Integer phone;
    private String email;
    private String address;
    private String genre;
    private String bloodType;
    private String birthday;
    private String maritalState;
    private String emergencyContact;
    private Integer emergencyPhone;
    private String disease;
    private String disability;
    private Boolean enable;
}
