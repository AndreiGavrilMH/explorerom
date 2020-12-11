package explore.romania.explorerom;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import explore.romania.explorerom.domain.Difficulty;
import explore.romania.explorerom.domain.Region;
import explore.romania.explorerom.services.TourPackageService;
import explore.romania.explorerom.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ExploreromApplication implements CommandLineRunner {

    @Autowired
    private TourPackageService tourPackageService;
    @Autowired
    private TourService tourService;

    public static void main(String[] args) {
        SpringApplication.run(ExploreromApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //name-ul TourPackage este packageType din json
        tourPackageService.createTourPackage("BN", "Banatenian Dream");
        tourPackageService.createTourPackage("BC", "Hot Bucovina");
        tourPackageService.createTourPackage("DB", "From Mountain to Shore");
        tourPackageService.createTourPackage("OL", "Oltenita is not in Oltenia");
        tourPackageService.createTourPackage("MA", "Funny graveyard");
        tourPackageService.createTourPackage("MO", "Alchool is life");
        tourPackageService.createTourPackage("MU", "Where the poor live");
        tourPackageService.createTourPackage("TR", "Castles and vampires");

        tourPackageService.loookup().forEach(tourPackage -> System.out.println(tourPackage));

        TourFromFile.importTours().forEach(t -> tourService.createTour(t.title, t.description, t.long_description, Integer.valueOf(t.price),
                t.bullets, t.bullets, t.keywords, t.packageType, Difficulty.valueOf(t.difficulty), Region.findByLabel(t.region)));
        System.out.println("Total number of tours: " + tourService.total());
    }

    static class TourFromFile {
        private String packageType, title, description, long_description,
                price, length, bullets, keywords, difficulty, region;

        static List<TourFromFile> importTours() throws IOException {
            return new ObjectMapper().
                    setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
                    readValue(TourFromFile.class.getResourceAsStream("/ExploreRomania.json"),
                            new TypeReference<List<TourFromFile>>() {
                            });
        }
    }
}
