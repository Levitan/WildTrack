package xyz.wildapp.android.wildtrack.api.intf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import xyz.wildapp.android.wildtrack.api.model.Courier;
import xyz.wildapp.android.wildtrack.api.model.Tracking;
import xyz.wildapp.android.wildtrack.api.model.TrackingRequest;

/**
 * Created by vborisovskii on 4/3/18.
 */

public interface AfterShip {
    @GET("couriers")
    Call<List<Courier>> getCouriers();

    @GET("couriers/all")
    Call<List<Courier>> getAllCouriers();

    @GET("trackings")
    Call<List<Tracking>> getAllTrackings();

    @GET("trackings/{trackId}")
    Call<Tracking> getTrack(@Path("trackId") String trackId);

    @POST("trackings")
    Call<Tracking> createTrack(@Body TrackingRequest tracking);

    @PUT("trackings/{trackId}")
    Call<Tracking> updateTrack(@Path("trackId") String trackId, @Body TrackingRequest tracking);

    @DELETE("trackings/{trackId}")
    Call<Tracking> deleteTrack(@Path("trackId") String trackId);


}
