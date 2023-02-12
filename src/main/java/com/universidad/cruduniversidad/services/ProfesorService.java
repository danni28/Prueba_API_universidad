package com.universidad.cruduniversidad.services;

import com.universidad.cruduniversidad.models.AlumnoModel;
import com.universidad.cruduniversidad.models.ProfesorModel;
import com.universidad.cruduniversidad.result.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universidad.cruduniversidad.repository.ProfesorRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    public Optional<ProfesorModel> Buscar(Integer id){
        return  profesorRepository.findById(id);
    }

    public Respuesta<ArrayList<ProfesorModel>> Listar() {
        try {

            ArrayList<ProfesorModel> result = (ArrayList<ProfesorModel>) profesorRepository.findAll();
            if(result.toArray().length == 0){
                return new Respuesta<ArrayList<ProfesorModel>>().NoEncontrado();
            }

            return new Respuesta<ArrayList<ProfesorModel>>().Success(result);

        } catch (Exception e) {
            return new Respuesta<ArrayList<ProfesorModel>>().Error(e.getMessage());
        }
    }

    public Respuesta<String> Registrar(ProfesorModel profesorModel) {
        try {

            ProfesorModel result = profesorRepository.save(profesorModel);
            if(result.getId() == null){
                return new Respuesta<String>().NoSuccess("No se pudo registrar el Profesor");
            }

            return new Respuesta<String>().Success(result.getId());

        } catch (Exception e) {
            return new Respuesta<String>().Error(e.getMessage());
        }
    }

    public Respuesta<String> Eliminar(Integer id) {
        try {

            Optional<ProfesorModel> result = Buscar(id);
            if (result.isEmpty()){
                return new Respuesta<String>().NoSuccess("No se encontró un Profesor con el Id " + id);
            }

            profesorRepository.deleteById(id);
            return new Respuesta<String>().Success("Profesor eliminado");

        } catch (Exception e) {
            return new Respuesta<String>().Error(e.getMessage());
        }
    }
}
