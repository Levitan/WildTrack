package xyz.wildapp.android.wildtrack.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by vborisovskii on 4/3/18.
 */

public class FcmIdService extends FirebaseInstanceIdService {

    private static final String TAG = "FcmIdService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + refreshedToken);
    }
}
