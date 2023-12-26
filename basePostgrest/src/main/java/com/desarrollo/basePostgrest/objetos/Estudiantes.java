package com.desarrollo.basePostgrest.objetos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idEstudiante;

    @Column(name = "nombre")
    private String anombreEstudiante;

    private String apellidoEstudiante;

    private String emailEstudiante;

    private String telefonoEstudiante;

    @Column(name = "codigo")
    private String codMateria;

}
