package in.dreamseed.thanbee;

import android.app.Application;

import com.parse.Parse;
import com.parse.PushService;

/**
 * Created by subin on 21/11/14.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        Parse.initialize(this, "mwE5wxa9G8fPsUSsA7vbivz0U5FcCWcZZ53G6nmS", "jeNU7MfxcZJQHFClH1ClGwPuxwysPMW5vMGn91zy");
        PushService.setDefaultPushCallback(this, MyActivity.class);
        super.onCreate();
    }
}
