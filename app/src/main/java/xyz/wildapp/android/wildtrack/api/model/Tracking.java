package xyz.wildapp.android.wildtrack.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tracking {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("last_updated_at")
    @Expose
    private String lastUpdatedAt;
    @SerializedName("tracking_number")
    @Expose
    private String trackingNumber;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("android")
    @Expose
    private List<Object> android = null;
    @SerializedName("custom_fields")
    @Expose
    private Object customFields;
    @SerializedName("customer_name")
    @Expose
    private Object customerName;
    @SerializedName("delivery_time")
    @Expose
    private Integer deliveryTime;
    @SerializedName("destination_country_iso3")
    @Expose
    private String destinationCountryIso3;
    @SerializedName("emails")
    @Expose
    private List<Object> emails = null;
    @SerializedName("expected_delivery")
    @Expose
    private Object expectedDelivery;
    @SerializedName("ios")
    @Expose
    private List<Object> ios = null;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("order_id")
    @Expose
    private Object orderId;
    @SerializedName("order_id_path")
    @Expose
    private Object orderIdPath;
    @SerializedName("origin_country_iso3")
    @Expose
    private String originCountryIso3;
    @SerializedName("shipment_package_count")
    @Expose
    private Integer shipmentPackageCount;
    @SerializedName("shipment_pickup_date")
    @Expose
    private String shipmentPickupDate;
    @SerializedName("shipment_delivery_date")
    @Expose
    private String shipmentDeliveryDate;
    @SerializedName("shipment_type")
    @Expose
    private Object shipmentType;
    @SerializedName("shipment_weight")
    @Expose
    private Object shipmentWeight;
    @SerializedName("shipment_weight_unit")
    @Expose
    private Object shipmentWeightUnit;
    @SerializedName("signed_by")
    @Expose
    private Object signedBy;
    @SerializedName("smses")
    @Expose
    private List<Object> smses = null;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("subtag")
    @Expose
    private String subtag;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("tracked_count")
    @Expose
    private Integer trackedCount;
    @SerializedName("last_mile_tracking_supported")
    @Expose
    private Object lastMileTrackingSupported;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("unique_token")
    @Expose
    private String uniqueToken;
    @SerializedName("checkpoints")
    @Expose
    private List<Checkpoint> checkpoints = null;
    @SerializedName("tracking_account_number")
    @Expose
    private Object trackingAccountNumber;
    @SerializedName("tracking_destination_country")
    @Expose
    private Object trackingDestinationCountry;
    @SerializedName("tracking_key")
    @Expose
    private Object trackingKey;
    @SerializedName("tracking_postal_code")
    @Expose
    private Object trackingPostalCode;
    @SerializedName("tracking_ship_date")
    @Expose
    private Object trackingShipDate;
    @SerializedName("tracking_state")
    @Expose
    private Object trackingState;
    @Expose(serialize = false, deserialize = false)
    private Boolean checked = false;

    /**
     * No args constructor for use in serialization
     */
    public Tracking() {
    }

    /**
     * @param checkpoints
     * @param subtag
     * @param signedBy
     * @param android
     * @param shipmentType
     * @param shipmentWeight
     * @param tag
     * @param destinationCountryIso3
     * @param shipmentPackageCount
     * @param trackingPostalCode
     * @param orderIdPath
     * @param smses
     * @param id
     * @param shipmentWeightUnit
     * @param lastUpdatedAt
     * @param trackingKey
     * @param title
     * @param shipmentDeliveryDate
     * @param trackingShipDate
     * @param createdAt
     * @param lastMileTrackingSupported
     * @param trackingAccountNumber
     * @param note
     * @param orderId
     * @param shipmentPickupDate
     * @param uniqueToken
     * @param customerName
     * @param trackingState
     * @param customFields
     * @param ios
     * @param trackedCount
     * @param originCountryIso3
     * @param expectedDelivery
     * @param emails
     * @param trackingDestinationCountry
     * @param updatedAt
     * @param source
     * @param deliveryTime
     * @param trackingNumber
     * @param active
     * @param slug
     * @param language
     */
    public Tracking(String id, String createdAt, String updatedAt, String lastUpdatedAt, String trackingNumber,
                    String slug, Boolean active, List<Object> android, Object customFields, Object customerName,
                    Integer deliveryTime, String destinationCountryIso3, List<Object> emails, Object expectedDelivery,
                    List<Object> ios, Object note, Object orderId, Object orderIdPath, String originCountryIso3,
                    Integer shipmentPackageCount, String shipmentPickupDate, String shipmentDeliveryDate,
                    Object shipmentType, Object shipmentWeight, Object shipmentWeightUnit, Object signedBy,
                    List<Object> smses, String source, String tag, String subtag, String title, Integer trackedCount,
                    Object lastMileTrackingSupported, Object language, String uniqueToken, List<Checkpoint> checkpoints,
                    Object trackingAccountNumber, Object trackingDestinationCountry, Object trackingKey,
                    Object trackingPostalCode, Object trackingShipDate, Object trackingState) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.trackingNumber = trackingNumber;
        this.slug = slug;
        this.active = active;
        this.android = android;
        this.customFields = customFields;
        this.customerName = customerName;
        this.deliveryTime = deliveryTime;
        this.destinationCountryIso3 = destinationCountryIso3;
        this.emails = emails;
        this.expectedDelivery = expectedDelivery;
        this.ios = ios;
        this.note = note;
        this.orderId = orderId;
        this.orderIdPath = orderIdPath;
        this.originCountryIso3 = originCountryIso3;
        this.shipmentPackageCount = shipmentPackageCount;
        this.shipmentPickupDate = shipmentPickupDate;
        this.shipmentDeliveryDate = shipmentDeliveryDate;
        this.shipmentType = shipmentType;
        this.shipmentWeight = shipmentWeight;
        this.shipmentWeightUnit = shipmentWeightUnit;
        this.signedBy = signedBy;
        this.smses = smses;
        this.source = source;
        this.tag = tag;
        this.subtag = subtag;
        this.title = title;
        this.trackedCount = trackedCount;
        this.lastMileTrackingSupported = lastMileTrackingSupported;
        this.language = language;
        this.uniqueToken = uniqueToken;
        this.checkpoints = checkpoints;
        this.trackingAccountNumber = trackingAccountNumber;
        this.trackingDestinationCountry = trackingDestinationCountry;
        this.trackingKey = trackingKey;
        this.trackingPostalCode = trackingPostalCode;
        this.trackingShipDate = trackingShipDate;
        this.trackingState = trackingState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tracking withId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Tracking withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Tracking withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Tracking withLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Tracking withTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Tracking withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Tracking withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public List<Object> getAndroid() {
        return android;
    }

    public void setAndroid(List<Object> android) {
        this.android = android;
    }

    public Tracking withAndroid(List<Object> android) {
        this.android = android;
        return this;
    }

    public Object getCustomFields() {
        return customFields;
    }

    public void setCustomFields(Object customFields) {
        this.customFields = customFields;
    }

    public Tracking withCustomFields(Object customFields) {
        this.customFields = customFields;
        return this;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public Tracking withCustomerName(Object customerName) {
        this.customerName = customerName;
        return this;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Tracking withDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    public String getDestinationCountryIso3() {
        return destinationCountryIso3;
    }

    public void setDestinationCountryIso3(String destinationCountryIso3) {
        this.destinationCountryIso3 = destinationCountryIso3;
    }

    public Tracking withDestinationCountryIso3(String destinationCountryIso3) {
        this.destinationCountryIso3 = destinationCountryIso3;
        return this;
    }

    public List<Object> getEmails() {
        return emails;
    }

    public void setEmails(List<Object> emails) {
        this.emails = emails;
    }

    public Tracking withEmails(List<Object> emails) {
        this.emails = emails;
        return this;
    }

    public Object getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Object expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public Tracking withExpectedDelivery(Object expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
        return this;
    }

    public List<Object> getIos() {
        return ios;
    }

    public void setIos(List<Object> ios) {
        this.ios = ios;
    }

    public Tracking withIos(List<Object> ios) {
        this.ios = ios;
        return this;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public Tracking withNote(Object note) {
        this.note = note;
        return this;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Tracking withOrderId(Object orderId) {
        this.orderId = orderId;
        return this;
    }

    public Object getOrderIdPath() {
        return orderIdPath;
    }

    public void setOrderIdPath(Object orderIdPath) {
        this.orderIdPath = orderIdPath;
    }

    public Tracking withOrderIdPath(Object orderIdPath) {
        this.orderIdPath = orderIdPath;
        return this;
    }

    public String getOriginCountryIso3() {
        return originCountryIso3;
    }

    public void setOriginCountryIso3(String originCountryIso3) {
        this.originCountryIso3 = originCountryIso3;
    }

    public Tracking withOriginCountryIso3(String originCountryIso3) {
        this.originCountryIso3 = originCountryIso3;
        return this;
    }

    public Integer getShipmentPackageCount() {
        return shipmentPackageCount;
    }

    public void setShipmentPackageCount(Integer shipmentPackageCount) {
        this.shipmentPackageCount = shipmentPackageCount;
    }

    public Tracking withShipmentPackageCount(Integer shipmentPackageCount) {
        this.shipmentPackageCount = shipmentPackageCount;
        return this;
    }

    public String getShipmentPickupDate() {
        return shipmentPickupDate;
    }

    public void setShipmentPickupDate(String shipmentPickupDate) {
        this.shipmentPickupDate = shipmentPickupDate;
    }

    public Tracking withShipmentPickupDate(String shipmentPickupDate) {
        this.shipmentPickupDate = shipmentPickupDate;
        return this;
    }

    public String getShipmentDeliveryDate() {
        return shipmentDeliveryDate;
    }

    public void setShipmentDeliveryDate(String shipmentDeliveryDate) {
        this.shipmentDeliveryDate = shipmentDeliveryDate;
    }

    public Tracking withShipmentDeliveryDate(String shipmentDeliveryDate) {
        this.shipmentDeliveryDate = shipmentDeliveryDate;
        return this;
    }

    public Object getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(Object shipmentType) {
        this.shipmentType = shipmentType;
    }

    public Tracking withShipmentType(Object shipmentType) {
        this.shipmentType = shipmentType;
        return this;
    }

    public Object getShipmentWeight() {
        return shipmentWeight;
    }

    public void setShipmentWeight(Object shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public Tracking withShipmentWeight(Object shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
        return this;
    }

    public Object getShipmentWeightUnit() {
        return shipmentWeightUnit;
    }

    public void setShipmentWeightUnit(Object shipmentWeightUnit) {
        this.shipmentWeightUnit = shipmentWeightUnit;
    }

    public Tracking withShipmentWeightUnit(Object shipmentWeightUnit) {
        this.shipmentWeightUnit = shipmentWeightUnit;
        return this;
    }

    public Object getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(Object signedBy) {
        this.signedBy = signedBy;
    }

    public Tracking withSignedBy(Object signedBy) {
        this.signedBy = signedBy;
        return this;
    }

    public List<Object> getSmses() {
        return smses;
    }

    public void setSmses(List<Object> smses) {
        this.smses = smses;
    }

    public Tracking withSmses(List<Object> smses) {
        this.smses = smses;
        return this;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Tracking withSource(String source) {
        this.source = source;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Tracking withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getSubtag() {
        return subtag;
    }

    public void setSubtag(String subtag) {
        this.subtag = subtag;
    }

    public Tracking withSubtag(String subtag) {
        this.subtag = subtag;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tracking withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getTrackedCount() {
        return trackedCount;
    }

    public void setTrackedCount(Integer trackedCount) {
        this.trackedCount = trackedCount;
    }

    public Tracking withTrackedCount(Integer trackedCount) {
        this.trackedCount = trackedCount;
        return this;
    }

    public Object getLastMileTrackingSupported() {
        return lastMileTrackingSupported;
    }

    public void setLastMileTrackingSupported(Object lastMileTrackingSupported) {
        this.lastMileTrackingSupported = lastMileTrackingSupported;
    }

    public Tracking withLastMileTrackingSupported(Object lastMileTrackingSupported) {
        this.lastMileTrackingSupported = lastMileTrackingSupported;
        return this;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public Tracking withLanguage(Object language) {
        this.language = language;
        return this;
    }

    public String getUniqueToken() {
        return uniqueToken;
    }

    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken;
    }

    public Tracking withUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken;
        return this;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public Tracking withCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
        return this;
    }

    public Object getTrackingAccountNumber() {
        return trackingAccountNumber;
    }

    public void setTrackingAccountNumber(Object trackingAccountNumber) {
        this.trackingAccountNumber = trackingAccountNumber;
    }

    public Tracking withTrackingAccountNumber(Object trackingAccountNumber) {
        this.trackingAccountNumber = trackingAccountNumber;
        return this;
    }

    public Object getTrackingDestinationCountry() {
        return trackingDestinationCountry;
    }

    public void setTrackingDestinationCountry(Object trackingDestinationCountry) {
        this.trackingDestinationCountry = trackingDestinationCountry;
    }

    public Tracking withTrackingDestinationCountry(Object trackingDestinationCountry) {
        this.trackingDestinationCountry = trackingDestinationCountry;
        return this;
    }

    public Object getTrackingKey() {
        return trackingKey;
    }

    public void setTrackingKey(Object trackingKey) {
        this.trackingKey = trackingKey;
    }

    public Tracking withTrackingKey(Object trackingKey) {
        this.trackingKey = trackingKey;
        return this;
    }

    public Object getTrackingPostalCode() {
        return trackingPostalCode;
    }

    public void setTrackingPostalCode(Object trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
    }

    public Tracking withTrackingPostalCode(Object trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
        return this;
    }

    public Object getTrackingShipDate() {
        return trackingShipDate;
    }

    public void setTrackingShipDate(Object trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
    }

    public Tracking withTrackingShipDate(Object trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
        return this;
    }

    public Object getTrackingState() {
        return trackingState;
    }

    public void setTrackingState(Object trackingState) {
        this.trackingState = trackingState;
    }

    public Tracking withTrackingState(Object trackingState) {
        this.trackingState = trackingState;
        return this;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}