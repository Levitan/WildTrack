package xyz.wildapp.android.wildtrack.firebase;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FcmMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FcmMessagingService";

    @Override
    public void onMessageReceived(RemoteMessage message) {
        Log.d(TAG, "From: " + message.getFrom());
        if (message.getData().size() > 0) {
            Log.d(TAG, "Message data payload: \n" + message.getData());
        }
        if (message.getNotification() != null) {
            Log.d(TAG, "Message notification body: " + message.getNotification().getBody());
        }
    }

    public void scheduleJob() {

    }

    public void handleNow() {

    }
}
