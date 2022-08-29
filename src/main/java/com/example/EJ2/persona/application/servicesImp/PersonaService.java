package com.example.EJ2.persona.application.servicesImp;

import com.example.EJ2.persona.application.services.PersonaInterface;
import com.example.EJ2.persona.domain.Persona;
import com.example.EJ2.persona.infraestructure.PersonaRepositorio;
import com.example.EJ2.persona.infraestructure.dto.PersonaInputDTO;
import com.example.EJ2.persona.infraestructure.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements PersonaInterface{
    @Autowired
    PersonaRepositorio personaRepositorio;

    @PersistenceContext
    private EntityManager em;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception {
        if (personaDTO == null) {
            throw new Exception("No está seleccionando ningúna persona.");
        }else {
            //pasamos la entidad persona a personaDTO
            Persona persona = new Persona(personaDTO);
            //lo guardamos
            personaRepositorio.save(persona);
            //guardamos el output
            //devolvemos el output dto en el controller.
            return new PersonaOutputDTO(persona);
        }
    }

    @Override
    public PersonaOutputDTO findPersonById(int id) {
        Optional<Persona> p = personaRepositorio.findById(id);

        return new PersonaOutputDTO(p);
    }


    @Override
    public List<PersonaOutputDTO> findPersonsByName(String name) {
        return personaRepositorio.findByName(name);
    }


    @Override
    public Page<Persona> getAllPersons(PageRequest pageable) {
        return personaRepositorio.findAll(pageable);
    }


    @Override
    public List<Persona> findByGreaterDate(@DateTimeFormat(pattern="yyyy-MM-dd") Date date ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> configConsulta = cb.createQuery(Persona.class);
        Root<Persona> root =  configConsulta.from(Persona.class);
        configConsulta.select(root).where(cb.greaterThan(root.get("created_date"), date));
        SimpleDateFormat date2 = new SimpleDateFormat("dd/MM/yyyy");
        date2.format(date);
        return em.createQuery(configConsulta).getResultList();
    }

    @Override
    public List<Persona> findByLowerDate(Date date) throws ParseException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> configConsulta = cb.createQuery(Persona.class);
        Root<Persona> root =  configConsulta.from(Persona.class);
        configConsulta.select(root).where(cb.lessThan(root.get("created_date"), date));
        return em.createQuery(configConsulta).getResultList();
    }

    @Override
    public List<Persona> findByEqualsDate(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> configConsulta = cb.createQuery(Persona.class);
        Root<Persona> root =  configConsulta.from(Persona.class);
        configConsulta.select(root).where(cb.equal(root.get("created_date"),date));
        return em.createQuery(configConsulta).getResultList();
    }


}

