package com.universidad.cruduniversidad.services;

import com.universidad.cruduniversidad.models.AlumnoModel;
import com.universidad.cruduniversidad.result.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universidad.cruduniversidad.repository.AlumnoRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    public Optional<AlumnoModel> Buscar(Integer id){
        return  alumnoRepository.findById(id);
    }

    public Respuesta<ArrayList<AlumnoModel>> Listar() {
        try {

            ArrayList<AlumnoModel> result = (ArrayList<AlumnoModel>) alumnoRepository.findAll();
            if(result.toArray().length == 0){
                return new Respuesta<ArrayList<AlumnoModel>>().NoEncontrado();
            }

            return new Respuesta<ArrayList<AlumnoModel>>().Success(result);

        } catch (Exception e) {
            return new Respuesta<ArrayList<AlumnoModel>>().Error(e.getMessage());
        }
    }

    public Respuesta<String> Registrar(AlumnoModel alumnoModel) {
        try {

            AlumnoModel result = alumnoRepository.save(alumnoModel);
            if(result.getId() == null){
                return new Respuesta<String>().NoSuccess("No se pudo registrar el Alumno");
            }

            return new Respuesta<String>().Success(result.getId());

        } catch (Exception e) {
            return new Respuesta<String>().Error(e.getMessage());
        }
    }

    public Respuesta<String> Eliminar(Integer id) {
        try {

            Optional<AlumnoModel> result = Buscar(id);
            if (result.isEmpty()){
                return new Respuesta<String>().NoSuccess("No se encontró un Alumno con el Id " + id);
            }

            alumnoRepository.deleteById(id);
            return new Respuesta<String>().Success("Alumno eliminado");

        } catch (Exception e) {
            return new Respuesta<String>().Error(e.getMessage());
        }
    }

}
