package com.universidad.cruduniversidad.controllers;

import com.universidad.cruduniversidad.models.AlumnoModel;
import com.universidad.cruduniversidad.result.Respuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.universidad.cruduniversidad.services.AlumnoService;

import java.util.ArrayList;

@RestController
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/Listar")
    public Respuesta<ArrayList<AlumnoModel>> Listar() {
        return alumnoService.Listar();
    }

    @PostMapping("/Registrar")
    public Respuesta<String> Registrar(@RequestBody AlumnoModel alumnoModel) {
        return alumnoService.Registrar(alumnoModel);
    }

    @DeleteMapping("/Eliminar/{id}")
    public Respuesta<String> Eliminar(@PathVariable("id") Integer id){
        return alumnoService.Eliminar(id);
    }
}
