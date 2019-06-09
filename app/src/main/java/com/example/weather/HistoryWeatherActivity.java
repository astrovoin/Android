package com.example.weather;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class HistoryWeatherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_weather);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        recyclerView.setHasFixedSize(true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DataSourceBuilder builder = new DataSourceBuilder(getResources());

        SocnetAdapter adapter = new SocnetAdapter(builder.build());
        recyclerView.setAdapter(adapter);


        adapter.SetOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String positionStr = getString(R.string.position);
                StringBuilder posStrBuild = new StringBuilder(positionStr);
                posStrBuild.append(getString(R.string.empty_string)).append(position);
                showToast(String.valueOf(posStrBuild));
            }
        });
    }
}
