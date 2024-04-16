package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlumnoServiceImpl implements AlumnoService {

    List<Alumno> alumnoList = new ArrayList<>();
    public List<Alumno> getAlumnoList() { return alumnoList; }
    public void createAlumno(Alumno newAlumno) { alumnoList.add(newAlumno); }
    public Alumno getAlumnoById(int id) { return alumnoList.get(id); }
    public void updateAlumnoById(int id, Alumno alumno) { alumnoList.set(id, alumno); }
    public void deleteAlumnoById(int id) { alumnoList.remove(id); }
    public Boolean existsById(int id) {
        if(alumnoList.size()<=id) {
            return false;
        } else {
            Alumno alumno = alumnoList.get(id);
            return alumnoList.contains(alumno);
        }
    }
}
