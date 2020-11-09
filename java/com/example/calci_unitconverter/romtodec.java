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
 * Use the {@link romtodec#newInstance} factory method to
 * create an instance of this fragment.
 */
public class romtodec extends Fragment {

    EditText dec_input;
    EditText rom_input;
    EditText dec_output;
    EditText rom_output;
    Button b_converttoRoman;
    Button b_converttodecimal;
//    String string1, string2, rom_num;
//    double dec_num;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public romtodec() {
    }
    // TODO: Rename and change types and number of parameters
    public static romtodec newInstance(String param1, String param2) {
        romtodec fragment = new romtodec();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_romtodec, container, false);
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            b_converttoRoman = (Button) getView().findViewById(R.id.currency_convert);
            b_converttodecimal = (Button) getView().findViewById(R.id.currency_convert2);
            dec_input = (EditText) getView().findViewById(R.id.decimal_input);
            rom_input = (EditText) getView().findViewById(R.id.roman_input);
            dec_output = (EditText) getView().findViewById(R.id.Romanswer);
            rom_output = (EditText) getView().findViewById(R.id.decanswer);
            b_converttodecimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NumberConverter NumCon = new NumberConverter();
                    String userinputstring = rom_input.getText().toString();
                    int todecimalnumber;
                    todecimalnumber = NumCon.toNumber(userinputstring);
                    String decimal = String.valueOf(todecimalnumber);
                    dec_output.setText(decimal);
                }
            });
            b_converttoRoman.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NumberConverter NumCon = new NumberConverter();
                    int userinputnumber= Integer.parseInt(dec_input.getText().toString()); // Input given by user
                    String toromannumber; // data which goes back to user
                    toromannumber = NumCon.toRoman(userinputnumber);
                    rom_output.setText(toromannumber);
                }
            });
        }
    }
