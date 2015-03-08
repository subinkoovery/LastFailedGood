package in.dreamseed.thanbee;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Single_Full_News#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Single_Full_News extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    // TODO: Rename and change types and number of parameters
    public static Single_Full_News newInstance(String head, String tail) {
        Single_Full_News fragment = new Single_Full_News();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, head);
        args.putString(ARG_PARAM2, tail);
        fragment.setArguments(args);
        return fragment;
    }
    public Single_Full_News() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_single__full__news, container, false);
        TextView header= (TextView) rootView.findViewById(R.id.single_head);
        TextView details= (TextView) rootView.findViewById(R.id.single_tail);
        mParam2="       "+mParam2;
        header.setText(mParam1);
        details.setText(mParam2);
        return rootView;
    }


}
