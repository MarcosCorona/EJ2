package com.example.EJ2.Persona.clases.dto;

import com.example.EJ2.Persona.clases.dbManagement.Persona;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class PersonaOutputDTO {
    private Integer id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public PersonaOutputDTO(Persona persona) {
        setId(persona.getId());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImage_url(persona.getImage_url());
        setTermination_date(persona.getTermination_date());
    }

    public PersonaOutputDTO(Optional<Persona> persona) {
        setId(persona.get().getId());
        setUsuario(persona.get().getUsuario());
        setPassword(persona.get().getPassword());
        setName(persona.get().getName());
        setSurname(persona.get().getSurname());
        setCompany_email(persona.get().getCompany_email());
        setPersonal_email(persona.get().getPersonal_email());
        setCity(persona.get().getCity());
        setActive(persona.get().getActive());
        setCreated_date(persona.get().getCreated_date());
        setImage_url(persona.get().getImage_url());
        setTermination_date(persona.get().getTermination_date());
    }

    public PersonaOutputDTO(List<Persona> personas) {
        for ( Persona persona : personas) {
            setId(persona.getId());
            setUsuario(persona.getUsuario());
            setPassword(persona.getPassword());
            setName(persona.getName());
            setSurname(persona.getSurname());
            setCompany_email(persona.getCompany_email());
            setPersonal_email(persona.getPersonal_email());
            setCity(persona.getCity());
            setActive(persona.getActive());
            setCreated_date(persona.getCreated_date());
            setImage_url(persona.getImage_url());
            setTermination_date(persona.getTermination_date());
        }
    }
}
