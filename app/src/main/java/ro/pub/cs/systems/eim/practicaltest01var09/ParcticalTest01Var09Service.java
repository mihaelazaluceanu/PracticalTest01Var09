package ro.pub.cs.systems.eim.practicaltest01var09;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ParcticalTest01Var09Service extends Service {
    public ParcticalTest01Var09Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("service", "onBind() method was invoked");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "onStartCommand() method was invoked");

        ProcessingThread processingThread = new ProcessingThread(this, intent.getStringExtra("sum"));
        processingThread.start();

        return START_REDELIVER_INTENT;
    }
}