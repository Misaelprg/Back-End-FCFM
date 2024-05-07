package com.fcfm.backend.repository;

import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.utils.AlumnoMapper;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insertar(Alumno alumno) { em.persist(alumno); }

    @Override
    public Alumno getAlumnoById(Long id) { return em.find(Alumno.class, id); }

    @Override
    public List<Alumno> getAlumnoList() {
        TypedQuery<Alumno> query = em.createNamedQuery("getAllAlumnos", Alumno.class);
        return query.getResultList();
    }

    @Transactional
    public com.fcfm.backend.model.Alumno updateAlumnoById(Alumno alumno) {
        return AlumnoMapper.alumnoEntityToAlumnoModel(em.merge(alumno));
    }

    @Transactional
    public String deleteAlumnoById(Long id) {
        Alumno alumno = em.find(Alumno.class, id);
        if(alumno != null) {
            em.remove(alumno);
            return "Alumno " + id + " eliminado correctamente.";
        } else {
            return "Alumno " + id + " no existe.";
        }

    }
}
