package com.example.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


public class CoatOfArmsFragment extends Fragment {
    public static final String PARCEL = "parcel";
    private final String TAG = this.getClass().getSimpleName();

    private TextView cityDegree;
    private TextView cityNameView;
    private TextView citySunCloud;

    private int defaultIndex = 0;


    public static CoatOfArmsFragment createInstance(CityIndex parcel) {
        CoatOfArmsFragment fragment = new CoatOfArmsFragment();
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_coat_of_arms, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() == null) {
            return;
        }

        cityNameView = getView().findViewById(R.id.tv_chosen_city);
        cityDegree = getView().findViewById(R.id.weatherViewFragment);
        citySunCloud = getView().findViewById(R.id.sun_cloud);

        CityIndex parcel = getParcel();
        if (parcel != null) {
            cityNameView.setText(parcel.getCityName());
        } else {

            cityNameView.setText(getResources().getTextArray(R.array.cities_list)[defaultIndex].toString());
        }

        Random rand = new Random();
        int gradus = rand.nextInt(30);
        StringBuilder endview = new StringBuilder(gradus + " ");
        endview.append(getString(R.string.circle)).append(getString(R.string.str_degree));
        cityDegree.setText(endview);


    }

    public @Nullable
    CityIndex getParcel() {
        CityIndex parcel = null;
        if (getArguments() != null) {
            parcel = (CityIndex) getArguments().getSerializable(PARCEL);
        }
        return parcel;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }
}