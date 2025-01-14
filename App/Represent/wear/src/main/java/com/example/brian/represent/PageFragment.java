package com.example.brian.represent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView textView;

    private OnFragmentInteractionListener mListener;

    public PageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageFragment newInstance(String param1, String param2) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view;
        Bundle bundle = getArguments();


        int slide = bundle.getInt("count");
        String[] views = bundle.getStringArray("info");
        if (slide == 4) {
            view = inflater.inflate(R.layout.presidential_activity, container, false);
            TextView state = (TextView) view.findViewById(R.id.textView7);
            TextView county = (TextView) view.findViewById(R.id.textView8);
            TextView president1 = (TextView) view.findViewById(R.id.textView9);
            TextView president2 = (TextView) view.findViewById(R.id.textView);
            state.setText("State: " +views[10]);
            county.setText("County: "+views[11]);
            president1.setText("Obama: " + views[12]+"% of Votes");
            president2.setText("Romney: "+ views[13]+"% of Votes");
        } else if (slide == 1) {
            view = inflater.inflate(R.layout.page_fragment_layout, container, false);
            Button Btn = (Button) view.findViewById(R.id.button);
            TextView first = (TextView) view.findViewById(R.id.textView3);
            TextView second = (TextView) view.findViewById(R.id.textView4);
            Btn.setBackgroundResource(R.drawable.jchu);
            first.setText(views[1] + ": " + views[2]);
            second.setText("Party: " + views[3]);
            if (views[3].equals("Democrat")) {
                Btn.setBackgroundColor(Color.parseColor("#336699"));
            } else if (views[3].equals("Republican")) {
                Btn.setBackgroundColor(Color.parseColor("#8c001a"));
            } else {
                Btn.setBackgroundColor(Color.parseColor("#663399"));
            }
            Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity) getActivity();
                    Intent sendIntent = new Intent(activity.getBaseContext(), WatchToPhoneService.class);
                    sendIntent.putExtra("BUTTON", "1");
                    activity.startService(sendIntent);
                }
            });
        } else if (slide == 2) {
            view = inflater.inflate(R.layout.page_fragment_layout, container, false);
            Button Btn = (Button) view.findViewById(R.id.button);
            TextView first = (TextView) view.findViewById(R.id.textView3);
            TextView second = (TextView) view.findViewById(R.id.textView4);
            first.setText(views[4] + ": " + views[5]);
            second.setText("Party: " + views[6]);
            if (views[6].equals("Democrat")) {
                Btn.setBackgroundColor(Color.parseColor("#336699"));
            } else if (views[6].equals("Republican")) {
                Btn.setBackgroundColor(Color.parseColor("#8c001a"));
            } else {
                Btn.setBackgroundColor(Color.parseColor("#663399"));
            }
            Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity) getActivity();
                    Intent sendIntent = new Intent(activity.getBaseContext(), WatchToPhoneService.class);
                    sendIntent.putExtra("BUTTON", "2");
                    activity.startService(sendIntent);
                }
            });
        } else {
            view = inflater.inflate(R.layout.page_fragment_layout, container, false);
            Button Btn = (Button) view.findViewById(R.id.button);
            TextView first = (TextView) view.findViewById(R.id.textView3);
            TextView second = (TextView) view.findViewById(R.id.textView4);
            first.setText(views[7] + ": " + views[8]);
            second.setText("Party: " + views[9]);
            if (views[9].equals("Democrat")) {
                Btn.setBackgroundColor(Color.parseColor("#336699"));
            } else if (views[9].equals("Republican")) {
                Btn.setBackgroundColor(Color.parseColor("#8c001a"));
            } else {
                Btn.setBackgroundColor(Color.parseColor("#663399"));
            }
            Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity) getActivity();
                    Intent sendIntent = new Intent(activity.getBaseContext(), WatchToPhoneService.class);
                    sendIntent.putExtra("BUTTON", "3");
                    activity.startService(sendIntent);
                }
            });
        }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
