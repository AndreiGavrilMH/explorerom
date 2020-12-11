package explore.romania.explorerom.services;

import explore.romania.explorerom.domain.TourPackage;
import explore.romania.explorerom.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    //Creeaza un pachet. Daca exista returneaza null
    public TourPackage createTourPackage(String code, String name) {
        if (!tourPackageRepository.existsById(code)) {
            tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

    //Creeaza o lista cu toate pachetele din baza de date
    public Iterable<TourPackage> loookup() {
        return tourPackageRepository.findAll();
    }

    //Cate tururi sunt disponibile in baza de date
    public long total() {
        return tourPackageRepository.count();
    }
}
