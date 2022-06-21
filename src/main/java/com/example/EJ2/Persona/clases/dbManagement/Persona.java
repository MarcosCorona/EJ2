package com.example.EJ2.Persona.clases.dbManagement;

import com.example.EJ2.Persona.clases.dto.PersonaInputDTO;
import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;

    @Column(name="Usuario")
    private String usuario;

    @NonNull
    @Column(name="Password")
    private String password;

    @NonNull
    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @NonNull
    @Column(name="Company_Email")
    private String company_email;

    @NonNull
    @Column(name="Personal_Email")
    private String personal_email;

    @NonNull
    @Column(name="City")
    private String city;

    @NonNull
    @Column(name="Active")
    private Boolean active;

    @NonNull
    @Column(name="Created_Date")
    private Date created_date;

    @Column(name="Image_url")
    private String image_url;

    @Column(name="Termination_Date")
    private Date termination_date;


    public Persona(PersonaInputDTO persona) {
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
