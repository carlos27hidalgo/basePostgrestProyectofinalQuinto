
package com.desarrollo.basePostgrest.controladores;

import com.desarrollo.basePostgrest.objetos.Cursos;
//import com.desarrollo.basePostgrest.objetos.Estudiantes;
import com.desarrollo.basePostgrest.repositorios.CursosRepository;
//import com.desarrollo.basePostgrest.repositorios.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class CursosController {

    @Autowired
    CursosRepository cursosRepository;
    //visualizar
    @GetMapping("/cursos2")
    public List<Cursos> cursos(){
        List<Cursos> cursos = cursosRepository.findAll();
        return cursos;
    }
    //ingresar
    @PostMapping("/cursos2")
    public Cursos ingresoCursos(@RequestBody Cursos cursos){
        return cursosRepository.save(cursos);
    }

    //edit
    @PutMapping("/cursos2/{id}")
    public ResponseEntity<Cursos> cursosActualizar(@PathVariable int id, @RequestBody Cursos cursosData){
        Optional<Cursos> cursosOptional = cursosRepository.findById(id);
        Cursos cursos = cursosOptional.get();

        //actualizar campos directamente
        cursos.setAnombreMateria(cursosData.getAnombreMateria());
        cursos.setCodMateria(cursosData.getCodMateria());
        cursos.setNumEstudiantes(cursosData.getNumEstudiantes());
        cursos.setOaulaAsignada(cursosData.getOaulaAsignada());
        cursos.setPdocentes(cursosData.getPdocentes());

        //guardar en db
        Cursos cursosSave = cursosRepository.save(cursos);
        return ResponseEntity.ok(cursosSave);
    }

    //delete
    @DeleteMapping("/cursos2/{id}")
    public ResponseEntity<Boolean> eliminarCurso(@PathVariable int id){
        Optional<Cursos> cursos = cursosRepository.findById(id);
        cursosRepository.delete(cursos.get());
        return ResponseEntity.ok(true);
    }


}
