package explore.romania.explorerom.repository;

import explore.romania.explorerom.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(@RequestParam("code") String code);
}
