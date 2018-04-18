package xyz.wildapp.android.wildtrack.api;

import com.google.common.collect.ImmutableMap;

/**
 * Created by vborisovskii on 4/5/18.
 */

public class ApiConstants {
    public static final String STATUS_PENDING = "Pending";
    public static final String STATUS_INFO_RECEIVED = "InfoReceived";
    public static final String STATUS_IN_TRANSIT = "InTransit";
    public static final String STATUS_OUT_FOR_DELIVERY = "OutForDelivery";
    public static final String STATUS_FAIL = "AttemptFail";
    public static final String STATUS_DELIVERED = "Delivered";
    public static final String STATUS_ERROR = "Exception";
    public static final String STATUS_EXPIRED = "Expired";

    public static final String COURIER_RUSSIAN_POST = "russian-post";
    public static final String COURIER_EPACKET = "china-ems";
    public static final String COURIER_CHINA = "china-post";
    public static final String COURIER_SINGPOST = "singapore-post";

    public static final ImmutableMap<String, String> DELIVERY_STATUS = ImmutableMap.<String, String>builder()
            .put(STATUS_PENDING, "Pending")
            .put(STATUS_INFO_RECEIVED, "Info received")
            .put(STATUS_IN_TRANSIT, "In transit")
            .put(STATUS_OUT_FOR_DELIVERY, "Out for delivery")
            .put(STATUS_FAIL, "Attempt fail")
            .put(STATUS_DELIVERED, "Delivered")
            .put(STATUS_ERROR, "Exception")
            .put(STATUS_EXPIRED, "Expired")
            .build();
}
