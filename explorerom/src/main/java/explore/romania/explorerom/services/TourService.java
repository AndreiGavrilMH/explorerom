package explore.romania.explorerom.services;

import explore.romania.explorerom.domain.Difficulty;
import explore.romania.explorerom.domain.Region;
import explore.romania.explorerom.domain.Tour;
import explore.romania.explorerom.domain.TourPackage;
import explore.romania.explorerom.repository.TourPackageRepository;
import explore.romania.explorerom.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    //Cream un tur nou
    public Tour createTour(String title, String description, String long_description, Integer price, String duration,
                           String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if (tourPackage == null) {
            throw new RuntimeException("Tour package does not exist: " + tourPackageName);
        }
        return tourRepository.save(new Tour(title, description, long_description, price, duration, bullets,
                keywords, tourPackage, difficulty, region));
    }

    public Iterable<Tour> lookup() {
        return tourRepository.findAll();
    }

    public long total() {
        return tourRepository.count();
    }
}
