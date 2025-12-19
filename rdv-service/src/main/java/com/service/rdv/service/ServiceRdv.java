package com.service.rdv.service;

import com.service.rdv.clients.MedecinRestClient;
import com.service.rdv.clients.PatientRestClient;
import com.service.rdv.entity.Rdv;
import com.service.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv {

    private RdvRepository rdvRepository;
    private PatientRestClient patientRestClient;
    private MedecinRestClient medecinRestClient;

    @Override
    public List<Rdv> getAllRdvs() {
        List<Rdv> rdvs = rdvRepository.findAll();

        rdvs.forEach(rdv -> {
            patientRestClient.getPatientById(rdv.getPatientId())
                    .ifPresent(rdv::setPatient);

            medecinRestClient.getMedecinById(rdv.getMedecinId())
                    .ifPresent(rdv::setMedecin);
        });

        return rdvs;
    }

    @Override
    public Rdv getRdvById(int id) {
        Rdv rdv = rdvRepository.findById(id).orElseThrow();

        patientRestClient.getPatientById(rdv.getPatientId())
                .ifPresent(rdv::setPatient);

        medecinRestClient.getMedecinById(rdv.getMedecinId())
                .ifPresent(rdv::setMedecin);

        return rdv;
    }

    @Override
    public Rdv addRdv(Rdv rdv) {
        Rdv rdv2 = rdvRepository.findRdvByPatientIdAndDateRdv(
                rdv.getPatientId(), rdv.getDateRdv());

        Rdv rdv1 = rdvRepository.findRdvByMedecinIdAndDateRdv(
                rdv.getMedecinId(), rdv.getDateRdv());

        if (rdv1 == null && rdv2 == null)
            return rdvRepository.save(rdv);

        return null;
    }
}

