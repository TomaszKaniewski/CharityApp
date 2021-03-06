package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;

import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> showAllInstitution() {
        return institutionRepository.findAll();
    }

    public Institution getIntitutionById(Long id) {
        return institutionRepository.findById(id).get();
    }
}
