package xyz.wildapp.android.wildtrack.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.wildapp.android.wildtrack.api.intf.AfterShip;
import xyz.wildapp.android.wildtrack.api.model.Courier;
import xyz.wildapp.android.wildtrack.api.model.Tracking;
import xyz.wildapp.android.wildtrack.api.tools.Deserializer;
import xyz.wildapp.android.wildtrack.api.tools.Serializer;

/**
 * Created by vborisovskii on 4/3/18.
 */

public class ApiFactory {

    private static OkHttpClient setUpHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain
                        .request()
                        .newBuilder()
                        .addHeader("aftership-api-key", "45796810-25bc-441c-a5fd-500fbbc162d7")
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }

    @SuppressWarnings("unchecked")
    private static Gson setUpGson() {
        Type courierList = new TypeToken<List<Courier>>() {
        }.getType();
        Type trackList = new TypeToken<List<Tracking>>() {
        }.getType();
        return new GsonBuilder()
                .registerTypeAdapter(courierList, new Deserializer<List<Courier>>("couriers"))
                .registerTypeAdapter(trackList, new Deserializer<List<Tracking>>("trackings"))
                .registerTypeAdapter(Tracking.class, new Deserializer<Tracking>("tracking"))
                .registerTypeAdapter(Tracking.class, new Serializer<Tracking>())
                .create();
    }

    public static AfterShip getAfterShipApi() {
        return new Retrofit.Builder()
                .baseUrl("https://api.aftership.com/v4/")
                .addConverterFactory(GsonConverterFactory.create(setUpGson()))
                .client(setUpHttpClient())
                .build()
                .create(AfterShip.class);
    }

}
