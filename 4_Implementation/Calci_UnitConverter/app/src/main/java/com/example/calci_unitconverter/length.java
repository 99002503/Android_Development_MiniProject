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
 * Use the {@link length#newInstance} factory method to
 * create an instance of this fragment.
 */
public class length extends Fragment {
    Double result;
    EditText num_feet;
    EditText num_inches;
    EditText num_cms;
    double num1;
    double num2;
    double num3;
    TextView feet_output;
    TextView inches_output;
    TextView cm_output;
    String strng;
    String strng1;
    String strng2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public length() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment length.
     */
    // TODO: Rename and change types and number of parameters
    public static length newInstance(String param1, String param2) {
        length fragment = new length();
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
    public boolean getNumbers()
    {
        num_feet = (EditText) getView().findViewById(R.id.feet_input);
        num_inches = (EditText) getView().findViewById(R.id.inches_input);
        cm_output = (TextView) getView().findViewById(R.id.textView26);
        strng = num_feet.getText().toString();
        strng1 = num_inches.getText().toString();
        if (((strng.equals(null))||(strng.equals("")))&&((strng1.equals(null))||(strng1.equals(""))))
        {
            String res = "Please enter a value";
            cm_output.setText(res);
            return false;
        }
        else{
            num1 = Integer.parseInt(num_feet.getText().toString());
            num2 = Integer.parseInt(num_inches.getText().toString());
        }
        return true;
    }
    public boolean getNumbers1()
    {
        num_cms = (EditText) getView().findViewById(R.id.cm_input);
        feet_output = (TextView) getView().findViewById(R.id.textView28);
        inches_output = (TextView) getView().findViewById(R.id.textView29);
        strng2 = num_cms.getText().toString();
        if((strng2.equals(null))||(strng2.equals("")))
        {
            String res = "Please enter a value";
            feet_output.setText(res);
            return false;
        }
        else
        {
            num3 = Integer.parseInt(num_cms.getText().toString());
        }
        return true;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_length, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button convert3 = (Button) getView().findViewById(R.id.convert_length);
        Button convert4 = (Button) getView().findViewById(R.id.convert_length2);
        convert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNumbers())
                {
                    double inch = (Double) (num2/12);
                    double feet = num1+inch;
                    double out = feet*30.48;
                    cm_output.setText(Double.toString(out));
                }
            }
        });
        convert4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNumbers1())
                {
                    double sum = (Double) (num3/30.48);
                    long f_out = (long) sum;
                    double i_out = (sum-f_out)*12;
                    feet_output.setText(Double.toString(f_out));
                    inches_output.setText(Double.toString(i_out));
                }
            }
        });
    }
}