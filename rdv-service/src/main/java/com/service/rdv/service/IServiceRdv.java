package com.service.rdv.service;

import com.service.rdv.entity.Rdv;
import java.util.List;
public interface IServiceRdv {
    public Rdv addRdv(Rdv rdv);
    public List<Rdv> getAllRdvs();
    public Rdv getRdvById(int id);
}
