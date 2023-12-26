
package com.desarrollo.basePostgrest.controladores;

import com.desarrollo.basePostgrest.objetos.Calificaciones;
import com.desarrollo.basePostgrest.objetos.Cursos;
import com.desarrollo.basePostgrest.repositorios.CalificacionesRepository;
import com.desarrollo.basePostgrest.repositorios.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class CalificacionesController {

    @Autowired
    CalificacionesRepository calificacionesRepository;
    //visualizar
    @GetMapping("/calificaciones2")
    public List<Calificaciones> calificaciones(){
        List<Calificaciones> calificaciones = calificacionesRepository.findAll();
        return calificaciones;
    }
    //ingresar
    @PostMapping("/calificaciones2")
    public Calificaciones ingresoCalificaciones(@RequestBody Calificaciones calificaciones){
        return calificacionesRepository.save(calificaciones);
    }

    //edit
    @PutMapping("/calificaciones2/{id}")
    public ResponseEntity<Calificaciones> calificacionesActualizar(@PathVariable int id, @RequestBody Calificaciones calificacionesData){
        Optional<Calificaciones> calificacionesOptional = calificacionesRepository.findById(id);
        Calificaciones calificaciones = calificacionesOptional.get();

        //actualizar campos directamente
        calificaciones.setIdEstudiante(calificacionesData.getIdEstudiante());
        calificaciones.setAnombreEstudiante(calificacionesData.getAnombreEstudiante());
        calificaciones.setBcodMateria(calificacionesData.getBcodMateria());
        calificaciones.setCalificacion(calificacionesData.getCalificacion());

        //guardar en db
        Calificaciones calificacionesSave = calificacionesRepository.save(calificaciones);
        return ResponseEntity.ok(calificacionesSave);
    }

    //delete
    @DeleteMapping("/calificaciones2/{id}")
    public ResponseEntity<Boolean> eliminarCalificacion(@PathVariable int id){
        Optional<Calificaciones> calificaciones = calificacionesRepository.findById(id);
        calificacionesRepository.delete(calificaciones.get());
        return ResponseEntity.ok(true);
    }


}
