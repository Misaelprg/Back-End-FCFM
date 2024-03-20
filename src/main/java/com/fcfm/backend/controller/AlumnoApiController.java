package com.fcfm.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @GetMapping("/")
    ResponseEntity<String> getName();

    @GetMapping("/{nombreAlumno}")
    ResponseEntity<String> getName(@PathVariable String nombreAlumno);
}
