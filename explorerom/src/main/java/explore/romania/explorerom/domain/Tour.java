package explore.romania.explorerom.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
public class Tour implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String long_description;
    @Column
    private Integer price;
    @Column
    private String duration;
    @Column
    private String bullets;
    @Column
    private String keywords;

    @ManyToOne
    private TourPackage tourPackage;
    @Column
    private Difficulty difficulty;
    @Column
    private Region region;

    protected Tour() {

    }

    //constructor generat cu toate campurile

    public Tour(String title, String description, String long_description, Integer price, String duration, String bullets, String keywords, TourPackage tourPackage, Difficulty difficulty, Region region) {
        this.title = title;
        this.description = description;
        this.long_description = long_description;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }

    public Tour(String title, String description, String long_description, Integer price, String duration, String bullets, String keywords, String tourPackage, Difficulty difficulty, Region region) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
