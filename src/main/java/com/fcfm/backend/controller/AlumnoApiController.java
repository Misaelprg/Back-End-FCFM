package com.fcfm.backend.controller;

import com.fcfm.backend.model.UserLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.fcfm.backend.repository.entity.Alumno;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @PostMapping("/")
    ResponseEntity<String> createAlumno(@RequestBody Alumno alumnoNuevo, BindingResult result);

    @GetMapping("/")
    ResponseEntity<List<Alumno>> getAlumnoList();

    @GetMapping({"/{idAlumno}"})
    ResponseEntity<com.fcfm.backend.model.Alumno> getAlumnoById(@PathVariable int idAlumno);

    @PutMapping("/")
    ResponseEntity<?> updateAlumnoById(@RequestBody Alumno alumno);

    @DeleteMapping("/{idAlumno}")
    ResponseEntity<String> deleteAlumnoById(@PathVariable int idAlumno);

    @PostMapping("/login")
    ResponseEntity<?> loginAlumno(@RequestBody UserLogin userLogin);

}
