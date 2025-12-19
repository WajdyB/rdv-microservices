package com.service.rdv.repository;

import com.service.rdv.entity.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {
    Rdv findRdvByMedecinIdAndDateRdv(int id, LocalDateTime date);
    Rdv findRdvByPatientIdAndDateRdv(int id, LocalDateTime date);
}
