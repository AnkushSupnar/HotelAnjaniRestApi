package com.anjani.service;

import com.anjani.entity.Kirana;
import com.anjani.repository.KiranaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KiranaService {
    private KiranaRepository repository;

    @Autowired
    public KiranaService(KiranaRepository repository) {
        this.repository = repository;
    }

    public List<Kirana> getAllKirana() {
        return repository.findAll();
    }

    public List<Kirana> getByDate(LocalDate date) {
        return repository.findByDate(date);
    }

    public List<Kirana> getByPartyName(String party) {
        return repository.findByParty_NameOrderByDateAsc(party);
    }

    public List<Kirana> getAllUnpaid() {
        return repository.findUnPaid();
    }

    public Kirana getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Kirana save(Kirana kirana) {
        return repository.save(kirana);
    }
}
