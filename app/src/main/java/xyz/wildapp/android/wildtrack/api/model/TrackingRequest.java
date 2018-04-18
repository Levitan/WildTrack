package xyz.wildapp.android.wildtrack.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vborisovskii on 4/5/18.
 */

public class TrackingRequest {
    @SerializedName("tracking")
    private Tracking tracking;

    public TrackingRequest(Tracking tracking) {
        this.tracking = tracking;
    }
}
