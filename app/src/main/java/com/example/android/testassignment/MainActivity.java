package com.example.android.testassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.testassignment.adapter.DataAdapter;
import com.example.android.testassignment.model.Data;
import com.example.android.testassignment.network.GetDataService;
import com.example.android.testassignment.network.RetrofitClientInstance;
import com.example.android.testassignment.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private DataAdapter mAdapter;

    private ProgressBar mPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPb = findViewById(R.id.pb_loading_indicator);
        getApiData();
    }

    private void getApiData(){
        mPb.setVisibility(View.VISIBLE);
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Data> call = service.getAppData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {
                if(response.isSuccessful()) {
                    generateDataList(response.body().getResponse());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                mPb.setVisibility(View.GONE);
                t.printStackTrace();
            }
        });
    }

    private void generateDataList(List<Response> responseList){
        mRecyclerView = findViewById(R.id.rv_main);
        mAdapter = new DataAdapter(this, responseList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }
}