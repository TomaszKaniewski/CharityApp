package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public int donationAmount() {

        try {
            return donationRepository.donationAmount();
        } catch (Exception e) {
            return 0;
        }
    }

    public int numberOfSupportedIstitutions() {
        return donationRepository.numberOfSupportedIntitutions();
    }
}
