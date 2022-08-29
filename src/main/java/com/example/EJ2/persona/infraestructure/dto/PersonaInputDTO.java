package com.example.EJ2.persona.infraestructure.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;


public record PersonaInputDTO(int idPersona, String usuario, String password,  String name, String surname,
                              String company_email,  String personal_email, String city, Boolean active,
                              Date created_date, String image_url, Date termination_date) { }
