package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController {

    private AlumnoService alumnoService;

    @Autowired
    AlumnoApiControllerImpl(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @Override
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumnoNuevo) {
        alumnoService.createAlumno(alumnoNuevo);
        return ResponseEntity.ok().body(alumnoNuevo);
    }

//    @Override
//    public ResponseEntity<List<Alumno>> getAlumnoList() {
//        return ResponseEntity.ok().body(alumnoService.getAlumnoList());
//    }

    @Override
    public ResponseEntity<com.fcfm.backend.model.Alumno> getAlumnoById(@PathVariable int idAlumno) {
        return ResponseEntity.ok().body(alumnoService.getAlumnoById(idAlumno));
    }

//    @Override
//    public ResponseEntity<Alumno> updateAlumnoById(@PathVariable int idAlumno, @RequestBody Alumno alumnoActualizado) {
//        alumnoService.updateAlumnoById(idAlumno, alumnoActualizado);
//        return ResponseEntity.ok().body(alumnoService.getAlumnoById(idAlumno));
//    }
//
//    @Override
//    public ResponseEntity<String> deleteAlumnoById(@PathVariable int idAlumno) {
//
//        if (!alumnoService.existsById(idAlumno)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        alumnoService.deleteAlumnoById(idAlumno);
//        return ResponseEntity.ok().body("Alumno con id " + idAlumno + " ha sido eliminado correctamente.");
//    }




}
