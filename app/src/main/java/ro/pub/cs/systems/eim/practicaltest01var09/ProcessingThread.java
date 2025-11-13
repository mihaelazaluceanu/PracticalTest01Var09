package ro.pub.cs.systems.eim.practicaltest01var09;

import android.content.Intent;
import android.content.Context;

public class ProcessingThread extends Thread {
    private Context context;
    private String sum;
    public ProcessingThread(Context context, String sum) {
        this.context = context;
        this.sum = sum;
    }

    @Override
    public void run() {
        sleep();
        sendMessage(1);
    }

    private void sleep() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        switch(messageType) {
            case 1:
                intent.setAction("> 10");
                intent.putExtra("sum", sum);
        }

        context.sendBroadcast(intent);
    }
}
