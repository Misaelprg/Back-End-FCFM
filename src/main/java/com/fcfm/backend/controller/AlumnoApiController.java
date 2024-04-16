package com.fcfm.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fcfm.backend.model.Alumno;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @PostMapping("/")
    ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumnoNuevo);
    @GetMapping("/")
    ResponseEntity<List<Alumno>> getAlumnoList();

    @GetMapping({"/{idAlumno}"})
    ResponseEntity<Alumno> getAlumnoById(@PathVariable int idAlumno);

    @PutMapping("/{idAlumno}")
    ResponseEntity<Alumno> updateAlumnoById(@PathVariable int idAlumno, @RequestBody Alumno alumno);

    @DeleteMapping("/{idAlumno}")
    ResponseEntity<String> deleteAlumnoById(@PathVariable int idAlumno);


}
