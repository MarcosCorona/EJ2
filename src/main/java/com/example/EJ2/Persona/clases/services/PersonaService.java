package com.example.EJ2.Persona.clases.services;

import com.example.EJ2.Persona.clases.dbManagement.Persona;
import com.example.EJ2.Persona.clases.dbManagement.PersonaRepositorio;
import com.example.EJ2.Persona.clases.dto.PersonaInputDTO;
import com.example.EJ2.Persona.clases.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements PersonaInterface {
    @Autowired
    PersonaRepositorio personaRepositorio;


    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception {
        if (personaDTO == null) {
            throw new Exception("No está seleccionando ningúna persona.");
        }else if (personaDTO.getUsuario() == null) {
            throw new Exception("El campo usuario está vacío.");
        } else if (personaDTO.getPassword() == null) {
            throw new Exception("El campo password está vacío.");
        } else if (personaDTO.getName() == null) {
            throw new Exception("El campo nombre está vacío.");
        } else if (personaDTO.getSurname() == null) {
            throw new Exception("El campo apellidos está vacío.");
        } else if (personaDTO.getCompany_email() == null) {
            throw new Exception("El campo email de la compañía está vacío.");
        } else if (personaDTO.getPersonal_email() == null) {
            throw new Exception("El campo email personal está vacío.");
        } else if (personaDTO.getCity() == null) {
            throw new Exception("El campo ciudad está vacío.");
        } else if (personaDTO.getCreated_date() == null) {
            throw new Exception("El campo fecha de creación está vacío.");
        } else if (personaDTO.getImage_url() == null) {
            throw new Exception("El campo imagen url está vacío.");
        } else if (personaDTO.getTermination_date() == null) {
            throw new Exception("El campo fecha de terminación está vacío.");
        } else if (personaDTO.getUsuario().length() < 6) {
            throw new Exception("La longitud de la contraseña es demasiado corta.\n" +
                    "Pruebe a escribir más de 6 carácteres.");
        } else {
            //pasamos la entidad persona a personaDTO
            Persona persona = new Persona(personaDTO);
            //lo guardamos
            personaRepositorio.save(persona);
            //guardamos el output
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(persona);
            //devolvemos el output dto en el controller.
            return saveOutputDTO;
        }
    }

    @Override
    public Optional<Persona> findPersonById(int id){
        return  personaRepositorio.findById(String.valueOf(id));
    }

    @Override
    public List<PersonaOutputDTO> findPersonsByUsuario(String usuario) {
        return null;
    }


    @Override
    public List<Persona> getAllPersons() {

        return personaRepositorio.findAll();
    }

}

