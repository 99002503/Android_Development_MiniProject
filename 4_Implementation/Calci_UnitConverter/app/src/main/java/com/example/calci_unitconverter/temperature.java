package com.example.calci_unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link temperature#newInstance} factory method to
 * create an instance of this fragment.
 */
public class temperature extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public temperature() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment temperature.
     */
    // TODO: Rename and change types and number of parameters
    public static temperature newInstance(String param1, String param2) {
        temperature fragment = new temperature();
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
        return inflater.inflate(R.layout.fragment_temperature, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //final NavController navController = Navigation.findNavController(view);
        final EditText cel = (EditText) getView().findViewById(R.id.celcius_input);
        final EditText far = (EditText) getView().findViewById(R.id.farenheit_input);
        final TextView cel1 = (TextView) getView().findViewById(R.id.textView13);
        final TextView far1 = (TextView) getView().findViewById(R.id.textView11);
        Button convert1 = (Button) getView().findViewById(R.id.convert1);
        Button convert2 = (Button) getView().findViewById(R.id.convert2);

        convert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double c = Double.valueOf(cel.getText().toString());
                Double f = (c * 9 / 5) + 32;
                far1.setText(String.valueOf(f));
            }
        });
        convert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double f = Double.valueOf(far.getText().toString());
                Double c = ((f - 32) * 5) / 9;
                cel1.setText(String.valueOf(c));
            }
        });
    }
}