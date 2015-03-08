package in.dreamseed.thanbee.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by subin on 21/11/14.
 */
public class LatestContainer {
    static String Head;
    static String Tail;
    static String SHARED_id = "latestID";
    static String SHARED_Count_String = "SHARED_Count";
    static String HEAD = "heading";
    static String TAIL = "description";
    static int SHARED_Count=0;

    public static void makePersistant(Context c,String aHead,String bDesc)
    {
        SharedPreferences mSharedPreferences=c.getSharedPreferences(SHARED_id,Context.MODE_PRIVATE);
        SHARED_Count=mSharedPreferences.getInt(SHARED_Count_String,0);  //getting index

        SharedPreferences.Editor mEditor=c.getSharedPreferences(SHARED_id,Context.MODE_PRIVATE).edit();
        SHARED_Count++;
        mEditor.putInt(SHARED_Count_String,SHARED_Count); // incremnting the index value
        Log.e("SHARED_PREF ins  SUCCESS : ",aHead);
        mEditor.putString(HEAD+SHARED_Count,aHead);
        mEditor.putString(TAIL+SHARED_Count,bDesc);
        mEditor.commit();
    }
    public static ArrayList<LatestNews> getAllNews(Context context)
    {
        ArrayList<LatestNews> collection=new ArrayList<LatestNews>();
        SharedPreferences mSharedPreferences=context.getSharedPreferences(SHARED_id,Context.MODE_PRIVATE);
        SHARED_Count=mSharedPreferences.getInt(SHARED_Count_String,0);
        LatestNews tmp;
        for (int i=SHARED_Count;i>=1;i--)
        {
            Log.e("SHARED_PREF get SUCCESS : ",mSharedPreferences.getString(TAIL+i,""));
            tmp=new LatestNews(mSharedPreferences.getString(HEAD+i,""),mSharedPreferences.getString(TAIL+i,""));
            collection.add(tmp);
        }
        return  collection;
    }

}