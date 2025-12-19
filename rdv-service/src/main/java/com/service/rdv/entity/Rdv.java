package com.service.rdv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.rdv.model.Medecin;
import com.service.rdv.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Rdv {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateRdv;
    private String etat;
    private int patientId;
    @Transient
    private Patient patient; ;
    private int medecinId ;
    @Transient
    private Medecin medecin ;

}
