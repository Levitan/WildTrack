package xyz.wildapp.android.wildtrack.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Courier implements Serializable {

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("other_name")
    @Expose
    private String otherName;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("required_fields")
    @Expose
    private List<Object> requiredFields = null;
    @SerializedName("optional_fields")
    @Expose
    private List<Object> optionalFields = null;
    @SerializedName("default_language")
    @Expose
    private String defaultLanguage;
    @SerializedName("support_languages")
    @Expose
    private List<String> supportLanguages = null;
    @SerializedName("service_from_country_iso3")
    @Expose
    private List<String> serviceFromCountryIso3 = null;

    /**
     * No args constructor for use in serialization
     */
    public Courier() {
    }

    /**
     * @param webUrl
     * @param otherName
     * @param serviceFromCountryIso3
     * @param phone
     * @param requiredFields
     * @param name
     * @param defaultLanguage
     * @param slug
     * @param supportLanguages
     * @param optionalFields
     */
    public Courier(String slug, String name, String phone, String otherName, String webUrl,
                   List<Object> requiredFields, List<Object> optionalFields, String defaultLanguage,
                   List<String> supportLanguages, List<String> serviceFromCountryIso3) {
        super();
        this.slug = slug;
        this.name = name;
        this.phone = phone;
        this.otherName = otherName;
        this.webUrl = webUrl;
        this.requiredFields = requiredFields;
        this.optionalFields = optionalFields;
        this.defaultLanguage = defaultLanguage;
        this.supportLanguages = supportLanguages;
        this.serviceFromCountryIso3 = serviceFromCountryIso3;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Courier withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courier withName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Courier withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Courier withOtherName(String otherName) {
        this.otherName = otherName;
        return this;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Courier withWebUrl(String webUrl) {
        this.webUrl = webUrl;
        return this;
    }

    public List<Object> getRequiredFields() {
        return requiredFields;
    }

    public void setRequiredFields(List<Object> requiredFields) {
        this.requiredFields = requiredFields;
    }

    public Courier withRequiredFields(List<Object> requiredFields) {
        this.requiredFields = requiredFields;
        return this;
    }

    public List<Object> getOptionalFields() {
        return optionalFields;
    }

    public void setOptionalFields(List<Object> optionalFields) {
        this.optionalFields = optionalFields;
    }

    public Courier withOptionalFields(List<Object> optionalFields) {
        this.optionalFields = optionalFields;
        return this;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public Courier withDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
        return this;
    }

    public List<String> getSupportLanguages() {
        return supportLanguages;
    }

    public void setSupportLanguages(List<String> supportLanguages) {
        this.supportLanguages = supportLanguages;
    }

    public Courier withSupportLanguages(List<String> supportLanguages) {
        this.supportLanguages = supportLanguages;
        return this;
    }

    public List<String> getServiceFromCountryIso3() {
        return serviceFromCountryIso3;
    }

    public void setServiceFromCountryIso3(List<String> serviceFromCountryIso3) {
        this.serviceFromCountryIso3 = serviceFromCountryIso3;
    }

    public Courier withServiceFromCountryIso3(List<String> serviceFromCountryIso3) {
        this.serviceFromCountryIso3 = serviceFromCountryIso3;
        return this;
    }

}