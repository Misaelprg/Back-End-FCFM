package com.fcfm.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fcfm.backend.model.Alumno;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @GetMapping("/")
    ResponseEntity<String> getName();

    @GetMapping({"/{nombreAlumno}"})
    ResponseEntity<String> getName(@PathVariable String nombreAlumno);

    @PostMapping("/")
    ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumnoNuevo);
}
