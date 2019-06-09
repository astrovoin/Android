package com.example.weather;

import android.content.res.Resources;
import android.content.res.TypedArray;
import java.util.ArrayList;
import java.util.List;


public class DataSourceBuilder {
    private List<Soc> dataSource;
    private Resources resources;

    public DataSourceBuilder(Resources resources) {
        dataSource = new ArrayList<>(6);
        this.resources = resources;
    }


    public List<Soc> build() {

        String[] descriptions = resources.getStringArray(R.array.descriptions);

        int[] pictures = getImageArray();

        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new Soc(descriptions[i], pictures[i]));
        }
        return dataSource;
    }


    private int[] getImageArray() {
        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);
        int length = pictures.length();
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
    }
}
