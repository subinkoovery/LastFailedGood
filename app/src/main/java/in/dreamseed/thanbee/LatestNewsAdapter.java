package in.dreamseed.thanbee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import in.dreamseed.thanbee.push.LatestNews;

/**
 * Created by subin on 21/11/14.
 */
public class LatestNewsAdapter extends ArrayAdapter<LatestNews> {
    Context context;
    TextView mTextView;
    ArrayList<LatestNews> myLatestNewses=new ArrayList<LatestNews>();
    public LatestNewsAdapter(Context context, int resource, ArrayList<LatestNews> objects) {
        super(context, resource, objects);
        this.context=context;
        myLatestNewses= (ArrayList<LatestNews>) objects.clone();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater mLayoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView=mLayoutInflater.inflate(R.layout.lastest_news_single_row,parent,false);
        mTextView= (TextView) rootView.findViewById(R.id.latest_head);
        if (position%2==0)
            mTextView.setBackgroundColor(context.getResources().getColor(R.color.list_even));
        else
            mTextView.setBackgroundColor(context.getResources().getColor(R.color.list_odd));
        mTextView.setText(myLatestNewses.get(position).getHead());
        return  rootView;
    }
}
