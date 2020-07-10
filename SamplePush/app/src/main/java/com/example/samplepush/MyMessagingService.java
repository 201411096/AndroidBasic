package com.example.samplepush;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyMessagingService extends FirebaseMessagingService {
    public MyMessagingService() {
    }
    private static final String TAG = "FMS";

    @Override
    // 새로운  토큰이 확인했을 때 호출됨
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d(TAG, "onNewToken 호출됨 : " + token);
    }

    @Override
    // 새로운 메세지를 받았을 땓 호출됨
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived 호출됨.");

        //----------------------------------
        // (2) 메세지 수신 기능 추가
        //   - 푸시 메시지 받았을 때 그 내용 확인한 후 엑티비티 쪽으로 보내는 메소드 호출
        String from = remoteMessage.getFrom();
        Map<String, String> data = remoteMessage.getData();
        String contents = data.get("contents");
        Log.d(TAG, "from : " + from + ", contents : " + contents);

        sendToActivity(getApplicationContext(), from, contents);
    }

    //---------------------------------------------
    // (2) 메세지 수신 기능 추가
    //      - 엑티비티 쪽으로 데이타를 보내기 위해 인텐트 객체를 만들고 startActivity() 호출
    private void sendToActivity(Context context, String from, String contents) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("from", from);
        intent.putExtra("contents", contents);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        context.startActivity(intent);
    }

}
