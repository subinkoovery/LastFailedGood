package in.dreamseed.thanbee.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.GcmBroadcastReceiver;
import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import in.dreamseed.thanbee.mainHome;

/**
 * Created by subin on 21/11/14.
 */
public class MyPushReciever extends ParsePushBroadcastReceiver
{


    @Override
    protected void onPushOpen(Context context, Intent intent) {
        Intent i = new Intent(context,mainHome.class);
        i.putExtras(intent.getExtras());
        i.putExtra("news",true);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }

    @Override
    protected void onPushReceive(Context context, Intent intent) {
        super.onPushReceive(context, intent);
        Log.e("",intent.getExtras().toString());
        Log.e("com.parse.Data",intent.getStringExtra("com.parse.Data"));
        try {
            JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
            String notificationHead = json.getString("alert");
            Log.e("HEAD KITTY",notificationHead);
            String notificationTail = json.getString("details");
            Log.e("TAIL KITTY",notificationTail);
            LatestContainer.makePersistant(context,notificationHead,notificationTail);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}