package com.universidad.cruduniversidad.controllers;

import com.universidad.cruduniversidad.models.ProfesorModel;
import com.universidad.cruduniversidad.result.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.universidad.cruduniversidad.services.ProfesorService;

import java.util.ArrayList;

@RestController
@RequestMapping("/Profesor")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/Listar")
    public Respuesta<ArrayList<ProfesorModel>> Listar() {
        return profesorService.Listar();
    }

    @PostMapping("/Registrar")
    public Respuesta<String> Registrar(@RequestBody ProfesorModel profesorModel) {
        return profesorService.Registrar(profesorModel);
    }

    @DeleteMapping("/Eliminar/{id}")
    public Respuesta<String> Eliminar(@PathVariable("id") Integer id){
        return profesorService.Eliminar(id);
    }
}
