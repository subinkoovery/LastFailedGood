package in.dreamseed.thanbee;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class mainHome extends ActionBarActivity implements AboutFragment.OnFragmentInteractionListener,Contact.OnFragmentInteractionListener,TestList.OnFragmentInteractionListener,Latest.OnFragmentInteractionListener
{
    Drawable BackGround;
    TextView eventTittle;
    AboutFragment myAboutFragment;
    Contact myContact;
    ImageView action;
    FragmentManager fm;
    ListView mainList;
    Latest mLatest;
    TestList test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_home);
        String [] data={"ABOUT","SCHEDULE","GALLERY","LATEST","CONTACT"};

        eventTittle= (TextView) findViewById(R.id.fragEvent_Name);
        action= (ImageView) findViewById(R.id.action);
        Typeface swasdee=Typeface.createFromAsset(getAssets(), "sawasdee.ttf");
        eventTittle.setTypeface(swasdee);
        myAboutFragment=new AboutFragment();
        mLatest=new Latest();
        fm=getSupportFragmentManager();
        myContact=new Contact();
        test=new TestList();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragArealist,test);
        ft.commit();
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().popBackStack();
                eventTittle.setText("Thanbeehul Islam");
                action.setVisibility(View.INVISIBLE);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().getExtras()!=null) {
            if (getIntent().getExtras().getBoolean("news", false)) {
                latest();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        eventTittle.setText("Thanbeehul Islam");
        action.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onFragmentInteraction(int position) {


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void about(View v)
    {
        FragmentTransaction about=fm.beginTransaction();
        about.replace(R.id.fragArealist,myAboutFragment);
        eventTittle.setText("About");
        about.addToBackStack("");
        action.setImageResource(R.drawable.ic_drawer);
        action.setVisibility(View.VISIBLE);
        about.commit();
    }
    public void schedule(View v)
    {
//        action.setImageResource(R.drawable.ic_drawer);
//        action.setVisibility(View.VISIBLE);
        Intent schedule=new Intent(getApplication(),Schedule.class);
        startActivity(schedule);

    }
    public void gallery(View v)
    {
//        action.setImageResource(R.drawable.ic_drawer);
//
//        action.setVisibility(View.VISIBLE);
        Intent gallery=new Intent(getApplication(),Gallery.class);
        startActivity(gallery);

    }
    public void latest(View v)
    {
//        action.setImageResource(R.drawable.ic_drawer);
//
//        action.setVisibility(View.VISIBLE);
        /*Intent News=new Intent(getApplicationContext(),LatestActivity.class);
        startActivity(News);*/
        //Toast.makeText(getApplicationContext(),"No Latest News",Toast.LENGTH_SHORT).show();
        action.setImageResource(R.drawable.ic_drawer);

        action.setVisibility(View.VISIBLE);
        FragmentTransaction latest=fm.beginTransaction();
        latest.replace(R.id.fragArealist, mLatest);
        eventTittle.setText("Latest News");
        latest.addToBackStack("Latest");
        latest.commit();
    }
    public void latest()
    {
//        action.setImageResource(R.drawable.ic_drawer);
//
//        action.setVisibility(View.VISIBLE);
        /*Intent News=new Intent(getApplicationContext(),LatestActivity.class);
        startActivity(News);*/
        //Toast.makeText(getApplicationContext(),"No Latest News",Toast.LENGTH_SHORT).show();
        action.setImageResource(R.drawable.ic_drawer);

        action.setVisibility(View.VISIBLE);
        FragmentTransaction latest=fm.beginTransaction();
        latest.replace(R.id.fragArealist, mLatest);
        eventTittle.setText("Latest News");
        latest.addToBackStack("Latest");
        latest.commit();
    }
    public  void contact(View v)
    {
        action.setImageResource(R.drawable.ic_drawer);

        action.setVisibility(View.VISIBLE);
        FragmentTransaction contact=fm.beginTransaction();
        contact.replace(R.id.fragArealist, myContact);
        eventTittle.setText("Contact");
        contact.addToBackStack("cont");
        contact.commit();
    }
    public void onFragmentInteraction(String head,String tail)
    {

    }
    public void singleNews(String head,String tail)
    {
        action.setImageResource(R.drawable.ic_drawer);
        Single_Full_News mSingle_full_news=Single_Full_News.newInstance(head,tail);
        action.setVisibility(View.VISIBLE);
        FragmentTransaction latest=fm.beginTransaction();
        latest.replace(R.id.fragArealist, mSingle_full_news);
        eventTittle.setText("Latest News");
        latest.addToBackStack("Latest");
        latest.commit();
    }
}
