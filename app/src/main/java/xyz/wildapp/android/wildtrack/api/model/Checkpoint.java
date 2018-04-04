package xyz.wildapp.android.wildtrack.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Checkpoint {

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("country_iso3")
    @Expose
    private String countryIso3;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("subtag")
    @Expose
    private String subtag;
    @SerializedName("checkpoint_time")
    @Expose
    private String checkpointTime;
    @SerializedName("coordinates")
    @Expose
    private List<Object> coordinates = null;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("zip")
    @Expose
    private String zip;

    /**
     * No args constructor for use in serialization
     */
    public Checkpoint() {
    }

    /**
     * @param zip
     * @param subtag
     * @param countryName
     * @param location
     * @param countryIso3
     * @param tag
     * @param state
     * @param city
     * @param message
     * @param createdAt
     * @param checkpointTime
     * @param slug
     * @param coordinates
     */
    public Checkpoint(String slug, String city, String createdAt, String location, String countryName,
                      String message, String countryIso3, String tag, String subtag, String checkpointTime,
                      List<Object> coordinates, Object state, String zip) {
        super();
        this.slug = slug;
        this.city = city;
        this.createdAt = createdAt;
        this.location = location;
        this.countryName = countryName;
        this.message = message;
        this.countryIso3 = countryIso3;
        this.tag = tag;
        this.subtag = subtag;
        this.checkpointTime = checkpointTime;
        this.coordinates = coordinates;
        this.state = state;
        this.zip = zip;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Checkpoint withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Checkpoint withCity(String city) {
        this.city = city;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Checkpoint withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Checkpoint withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Checkpoint withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Checkpoint withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCountryIso3() {
        return countryIso3;
    }

    public void setCountryIso3(String countryIso3) {
        this.countryIso3 = countryIso3;
    }

    public Checkpoint withCountryIso3(String countryIso3) {
        this.countryIso3 = countryIso3;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Checkpoint withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getSubtag() {
        return subtag;
    }

    public void setSubtag(String subtag) {
        this.subtag = subtag;
    }

    public Checkpoint withSubtag(String subtag) {
        this.subtag = subtag;
        return this;
    }

    public String getCheckpointTime() {
        return checkpointTime;
    }

    public void setCheckpointTime(String checkpointTime) {
        this.checkpointTime = checkpointTime;
    }

    public Checkpoint withCheckpointTime(String checkpointTime) {
        this.checkpointTime = checkpointTime;
        return this;
    }

    public List<Object> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Object> coordinates) {
        this.coordinates = coordinates;
    }

    public Checkpoint withCoordinates(List<Object> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Checkpoint withState(Object state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Checkpoint withZip(String zip) {
        this.zip = zip;
        return this;
    }

}