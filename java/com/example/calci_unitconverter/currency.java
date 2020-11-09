package com.example.calci_unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link currency#newInstance} factory method to
 * create an instance of this fragment.
 */
public class currency extends Fragment {
    EditText rup_input;
    EditText usd_input;
    TextView rup_output;
    TextView usd_output;
    String strng;
    String strng2;
    double num3;
    double num4;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public currency() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment currency.
     */
    // TODO: Rename and change types and number of parameters
    public static currency newInstance(String param1, String param2) {
        currency fragment = new currency();
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
        return inflater.inflate(R.layout.fragment_currency, container, false);
    }

    public boolean getNumbers() {
        rup_input = (EditText) getView().findViewById(R.id.rupee_input);
        usd_output = (TextView) getView().findViewById(R.id.textView15);
        strng = rup_input.getText().toString();
        if ((strng.equals(null)) || (strng.equals(""))) {
            String res = "Please enter a value";
            usd_output.setText(res);
            return false;
        } else {
            num3 = Integer.parseInt(rup_input.getText().toString());
        }
        return true;
    }

    public boolean getNumbers1() {
        usd_input = (EditText) getView().findViewById(R.id.usd_input);
        rup_output = (TextView) getView().findViewById(R.id.textView18);
        strng2 = usd_input.getText().toString();
        if ((strng2.equals(null)) || (strng.equals(""))) {
            String res = "Please enter a value";
            rup_output.setText(res);
            return false;
        } else {
            num4 = Integer.parseInt(usd_input.getText().toString());
        }
        return true;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button convert1 = (Button) getView().findViewById(R.id.currency_convert2);
        convert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNumbers()) {
                    double r = num3;
                    double u = r / 73.31;
                    usd_output.setText(String.valueOf(u));
                }
            }
        });
        Button convert2 = (Button) getView().findViewById(R.id.currency_convert);
        convert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNumbers1()) {
                    double u = num4;
                    double r = u * 73.31;
                    rup_output.setText(String.valueOf(r));
                }
            }
        });
    }
}






