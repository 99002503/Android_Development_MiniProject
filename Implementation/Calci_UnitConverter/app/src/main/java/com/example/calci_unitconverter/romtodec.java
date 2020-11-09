package com.example.calci_unitconverter;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class romtodec extends Fragment {

    EditText dec_input;
    EditText rom_input;
    EditText dec_output;
    EditText rom_output;
    Button b_converttoRoman;
    Button b_converttodecimal;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public romtodec() {
    }

    public static romtodec newInstance(String param1, String param2) {
        romtodec fragment = new romtodec();
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onCreate(savedInstanceState);
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

                String romaninput = userinputstring.toUpperCase();
                for (int i = 0; i < romaninput.length(); i++) {
                    if ((romaninput.charAt(i)) == 'I' || (romaninput.charAt(i)) == 'V' || (romaninput.charAt(i)) == 'X' || (romaninput.charAt(i)) == 'L' ||
                            (romaninput.charAt(i)) == 'C' || (romaninput.charAt(i)) == 'D' || (romaninput.charAt(i)) == 'M') {
                        int var = NumCon.toNumber(userinputstring);
                        String todecimalnumber = String.valueOf(var);
                        dec_output.setText(todecimalnumber);
                    }

                    else {
                        Toast toast = Toast.makeText(getContext(),
                                "Please enter valid Roman Number",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
        b_converttoRoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberConverter NumCon = new NumberConverter();
                int userinputnumber= Integer.parseInt(dec_input.getText().toString());
                String toromannumber = NumCon.toRoman(userinputnumber);
                rom_output.setText(toromannumber);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_romtodec, container, false);
    }
}