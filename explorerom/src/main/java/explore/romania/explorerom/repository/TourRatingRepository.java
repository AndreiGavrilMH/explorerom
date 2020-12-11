package explore.romania.explorerom.repository;

import explore.romania.explorerom.domain.TourRating;
import explore.romania.explorerom.domain.TourRatingPk;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public class TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
    List<TourRating> findByPkTourId(Integer tourId);
    TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
