package com.example.calci_unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link unit_converter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class unit_converter extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public unit_converter() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment unit_converter.
     */
    // TODO: Rename and change types and number of parameters
    public static unit_converter newInstance(String param1, String param2) {
        unit_converter fragment = new unit_converter();
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
        return inflater.inflate(R.layout.fragment_unit_converter, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button currency = view.findViewById(R.id.button_currency);
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_unit_converter2_to_currency);
            }
            //    @Override
            //    public void onClickView(View v){
            //        Bundle result = new Bundle();
            //        result.putString("bundleKey", "Data from Home to Gallery");
            //        getParentFragmentManager().setFragmentResult("requestKey", result);
            //        navController.navigate(R.id.nav_gallery);//   }
        });
        Button temperature = view.findViewById(R.id.button_temperature);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_unit_converter2_to_temperature);
            }
            //    @Override
            //    public void onClickView(View v){
            //        Bundle result = new Bundle();
            //        result.putString("bundleKey", "Data from Home to Gallery");
            //        getParentFragmentManager().setFragmentResult("requestKey", result);
            //        navController.navigate(R.id.nav_gallery);//   }
        });
        Button power = view.findViewById(R.id.button_Length);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_unit_converter2_to_length);
            }
            //    @Override
            //    public void onClickView(View v){
            //        Bundle result = new Bundle();
            //        result.putString("bundleKey", "Data from Home to Gallery");
            //        getParentFragmentManager().setFragmentResult("requestKey", result);
            //        navController.navigate(R.id.nav_gallery);//   }
        });
    }
}