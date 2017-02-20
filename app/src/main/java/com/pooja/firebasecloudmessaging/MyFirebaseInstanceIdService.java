package com.pooja.firebasecloudmessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Pooja on 2/19/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG="MyFirebaseInstIdService";

    @Override
    public void onTokenRefresh() {
        String refershedtoken=FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refreshed token:"+refershedtoken);
    }
}
