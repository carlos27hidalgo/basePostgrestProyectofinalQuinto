package com.desarrollo.basePostgrest.controladores;

import com.desarrollo.basePostgrest.objetos.Estudiantes;
import com.desarrollo.basePostgrest.repositorios.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class EstudiantesController {

    @Autowired
    EstudiantesRepository estudiantesRepository;
    //visualizar
    @GetMapping("/estudiantes2")
    public List<Estudiantes> estudiantes(){
        List<Estudiantes> estudiantes = estudiantesRepository.findAll();
        return estudiantes;
    }
    //ingresar
    @PostMapping("/estudiantes2")
    public Estudiantes ingresoEstudiante(@RequestBody Estudiantes estudiantes){
        return estudiantesRepository.save(estudiantes);
    }

    //edit
    @PutMapping("/estudiantes2/{id}")
    public ResponseEntity<Estudiantes> estudianteActualizar(@PathVariable int id, @RequestBody Estudiantes estudiantesData){
        Optional<Estudiantes> estudianteOptional = estudiantesRepository.findById(id);
        Estudiantes estudiantes = estudianteOptional.get();

        //actualizar campos directamente
        estudiantes.setAnombreEstudiante(estudiantesData.getAnombreEstudiante());
        estudiantes.setApellidoEstudiante(estudiantesData.getApellidoEstudiante());
        estudiantes.setEmailEstudiante(estudiantesData.getEmailEstudiante());
        estudiantes.setTelefonoEstudiante(estudiantesData.getTelefonoEstudiante());
        estudiantes.setCodMateria(estudiantesData.getCodMateria());

        //guardar en db
        Estudiantes estudiantesSave = estudiantesRepository.save(estudiantes);
        return ResponseEntity.ok(estudiantesSave);
    }

    //delete
    @DeleteMapping("/estudiantes2/{id}")
    public ResponseEntity<Boolean> eliminarEstudiante(@PathVariable int id){
        Optional<Estudiantes> estudiantes = estudiantesRepository.findById(id);
        estudiantesRepository.delete(estudiantes.get());
        return ResponseEntity.ok(true);
    }


}
