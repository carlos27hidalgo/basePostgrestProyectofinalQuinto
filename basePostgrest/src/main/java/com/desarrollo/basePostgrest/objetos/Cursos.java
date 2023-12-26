
package com.desarrollo.basePostgrest.objetos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCursos;

    private String anombreMateria;

    private String codMateria;

    private Integer numEstudiantes;

    private String oaulaAsignada;

    private String pdocentes;

}
