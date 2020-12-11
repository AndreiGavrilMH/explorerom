package explore.romania.explorerom.web;

import explore.romania.explorerom.domain.Tour;
import explore.romania.explorerom.domain.TourRating;
import explore.romania.explorerom.repository.TourRatingRepository;
import explore.romania.explorerom.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

        TourRatingRepository tourRatingRepository;
        TourRepository tourRepository;

        @Autowired
        public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
            this.tourRatingRepository = tourRatingRepository;
            this.tourRepository = tourRepository;
        }

        protected TourRatingController() {

        }

        private RatingDto toDto(TourRating tourRating) {
            return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
        }

        private TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {
            TourRating rating = tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId, customerId);
            if (rating == null) {
                throw new NoSuchElementException("Tour-Rating pair for request("
                        + tourId + " for customer" + customerId);
            }
            return rating;
        }

        private Tour verifyTour(int tourId) throws NoSuchElementException {
            Tour tour = tourRepository.findByTourPackageCode(tourId);
            if (tour == null) {
                throw new NoSuchElementException("Tour does not exist " + tourId);
            }
            return tour;
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(NoSuchElementException.class)
        public String return400(NoSuchElementException ex) {
            return ex.getMessage();

        }

    }

}
