package com.pooja.firebasecloudmessaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.net.URI;

/**
 * Created by Pooja on 2/19/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG ="MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingintent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri notificationsound=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentTitle("Firebase Cloud Message");
        notificationBuilder.setContentText(remoteMessage.getNotification().getBody());
        notificationBuilder.setContentIntent(pendingintent);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSound(notificationsound);

        NotificationManager notificationmanager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationmanager.notify(0,notificationBuilder.build());
    }
}