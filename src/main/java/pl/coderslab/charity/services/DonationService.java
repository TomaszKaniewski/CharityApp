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
        return donationRepository.donationAmount();
    }

}
