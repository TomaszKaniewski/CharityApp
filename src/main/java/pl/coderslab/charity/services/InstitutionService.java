package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;

import pl.coderslab.charity.repository.InstitutionRepository;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
}
