package com.service.rdv.controller;

import com.service.rdv.clients.MedecinRestClient;
import com.service.rdv.clients.PatientRestClient;
import com.service.rdv.entity.Rdv;
import com.service.rdv.model.Medecin;
import com.service.rdv.model.Patient;
import com.service.rdv.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {

    private IServiceRdv iServiceRdv;

    @GetMapping("all")
    public List<Rdv> all() {
        return iServiceRdv.getAllRdvs();
    }

    @GetMapping("{id}")
    public Rdv find(@PathVariable int id) {
        return iServiceRdv.getRdvById(id);
    }

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody Rdv rdv) {
        Rdv created = iServiceRdv.addRdv(rdv);

        if (created != null)
            return new ResponseEntity<>(created, HttpStatus.CREATED);

        return new ResponseEntity<>(
                "Le Rdv ne peut pas etre créé, merci de vérifier vos données",
                HttpStatus.CONFLICT
        );
    }
}

