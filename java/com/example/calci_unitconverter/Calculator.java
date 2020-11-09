package com.example.calci_unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.nfc.tech.MifareUltralight;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;
import android.widget.TextView;
import com.example.calci_unitconverter.databinding.FragmentCalculatorBinding;
import androidx.databinding.DataBindingUtil;
import java.text.DecimalFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment {
    private FragmentCalculatorBinding binding;
    private DecimalFormat decimalFormat;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = 'x';
    private static final char DIVISION = '/';
    private static final char MODULO = '%';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculator.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculator newInstance(String param1, String param2) {
        Calculator fragment = new Calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        decimalFormat = new DecimalFormat("#.##########");
        super.onCreate(savedInstanceState);

          binding = DataBindingUtil.inflate(inflater,R.layout.fragment_calculator,container,false);

        binding.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 binding.textView2.setText(binding.textView2.getText() + ".");
            }
        });

        binding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "0");
            }
        });

        binding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "1");
            }
        });

        binding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "2");
            }
        });

        binding.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "3");
            }
        });

        binding.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "4");
            }
        });

        binding.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "5");
            }
        });

        binding.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "6");
            }
        });

        binding.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "7");
            }
        });

        binding.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "8");
            }
        });

        binding.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView2.setText(binding.textView2.getText() + "9");
            }
        });

        binding.sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.textView.setText(decimalFormat.format(valueOne) + "+");
                binding.textView2.setText(null);
            }
        });

        binding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.textView.setText(decimalFormat.format(valueOne) + "-");
                binding.textView2.setText(null);
            }
        });

        binding.multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.textView.setText(decimalFormat.format(valueOne) + "x");
                binding.textView2.setText(null);
            }
        });

        binding.divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.textView.setText(decimalFormat.format(valueOne) + "/");
                binding.textView2.setText(null);
            }
        });
        binding.modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MODULO;
                binding.textView.setText(decimalFormat.format(valueOne) + "%");
                binding.textView2.setText(null);
            }
        });

        binding.equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.textView.setText(binding.textView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.textView2.getText().length() > 0) {
                    CharSequence currentText = binding.textView2.getText();
                    binding.textView2.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.textView2.setText("");
                    binding.textView.setText("");
                }
            }
        });
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //FragmentCalculatorBinding binding = FragmentCalculatorBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.textView2.getText().toString());
            binding.textView2.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
            else if(CURRENT_ACTION == MODULO)
                valueOne = this.valueOne % valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.textView2.getText().toString());
            }
            catch (Exception e){}
        }

    }
}