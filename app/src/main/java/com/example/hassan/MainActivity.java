package com.example.hassan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hassan.retrofit.MyRetrofit;
import com.example.hassan.retrofit.interfaces.ApiCalls;
import com.example.hassan.works.DepartmentsWork;
import com.example.hassan.works.JobsWork;

import java.util.List;

import Control.BestOfferAdapter;
import Control.DepartmentsAdapter;
import Control.MainJobAdapter;
import Model.DepartmentModel;
import Model.JobModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    // TODO : UPDATES ON MainActivity
    //  1- DELETE METHOD (Aqsam  , Best , Main) Parameters Because they are never useless
    //  2- change DepartmentsAdapter Name to be clean and readable code
    //  3- replace List<DepartmentModel>list_aqsam  with another static one in package works class DepartmentWork to be static data
    //  4-replace List<JobModel>list_best  with another static one in package works class DepartmentWork to be static data

    //   private List<DepartmentModel>list_aqsam;
//   private List<JobModel>list_best;

    private TextView lblBestOffers ;
   private DepartmentsAdapter departementsAdapter;
   private BestOfferAdapter bestOffer_adapter;
   private MainJobAdapter main_adapter;
   private Activity mActivity ;


   private RecyclerView.LayoutManager layoutManager , layoutManagerBest,mainlayout;
   private RecyclerView rcy_Aqsam,recy_best,recy_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = MainActivity.this;

        Aqsam(); // TODO : Method names must be start with small letter like a not A => aqsam or setAqsams
        Best(); // TODO : Method names must be start with small letter like b not B => best or setBest or initialiseBest
        Main(); // TODO : Method names must be start with small letter like m not M => main or setMain...


    }


    public void Aqsam(/*RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager,*/ /*DepartmentsAdapter departements_adapter*//*, List<DepartmentModel>list_aqsam */){
//        list_aqsam = new ArrayList<>();
        rcy_Aqsam = findViewById(R.id.recy_aqsam);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rcy_Aqsam.setLayoutManager(layoutManager);
        departementsAdapter= new DepartmentsAdapter(/*this,*/DepartmentsWork.departmentModels);
        rcy_Aqsam.setItemAnimator(new DefaultItemAnimator());
        rcy_Aqsam.setHasFixedSize(true);
        rcy_Aqsam.setClickable(true);
        rcy_Aqsam.setAdapter(departementsAdapter);


        Retrofit retrofit = MyRetrofit.setRetrofit();
        final ApiCalls calls = retrofit.create(ApiCalls.class);

        Toast.makeText(this, "جار جلب الأقسام  ", Toast.LENGTH_LONG).show();

        calls.getAllDepartment().enqueue(new Callback<List<DepartmentModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<DepartmentModel>> call,@NonNull Response<List<DepartmentModel>> response) {


                if (response.isSuccessful()){
                    DepartmentsWork.departmentModels =  response.body();
                    departementsAdapter.update(DepartmentsWork.departmentModels );
                    Toast.makeText(mActivity, "تم تحميل جميع الأقسام بنجاح", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(mActivity, "Error Occurred When Request The Page", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<DepartmentModel>> call, @NonNull Throwable t) {
                Toast.makeText(mActivity, "Error Occurred When Request The Page \n"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



        departementsAdapter.setOnDepartmentClick(new OnDepartmentClick() {
            @Override
            public void onDepClick(View view, int position, String departmentName) {
                calls.getAllJob(departmentName).enqueue(new Callback<List<JobModel>>() {
                    @Override
                    public void onResponse(@NonNull  Call<List<JobModel>> call, @NonNull  Response<List<JobModel>> response) {
                        if (response.isSuccessful()){
                            JobsWork.jobModels = response.body() ;
                            main_adapter.update(JobsWork.jobModels );
                            bestOffer_adapter.update(JobsWork.jobModels );
                        }
                    }

                    @Override
                    public void onFailure( @NonNull   Call<List<JobModel>> call, @NonNull  Throwable t) {
                        Toast.makeText(mActivity, "Error Occurred When Request The Page \n"+t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }



    public void Best(/*RecyclerView recy_best, RecyclerView.LayoutManager layoutManagerBest,BestOfferAdapter bestOffer_adapter,List<JobModel>list_best*/){

        lblBestOffers = findViewById(R.id.lblBestOffers);
        recy_best = findViewById(R.id.recy_best);
        layoutManagerBest = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recy_best.setLayoutManager(layoutManagerBest);
        bestOffer_adapter = new BestOfferAdapter(JobsWork.jobModels);

        recy_best.setItemAnimator(new DefaultItemAnimator());
        recy_best.setHasFixedSize(true);
        recy_best.setClickable(true);
        recy_best.setAdapter(bestOffer_adapter);


    }


    public void Main(/*RecyclerView recy_main, RecyclerView.LayoutManager mainlayout,MainJobAdapter main_adapter,List<JobModel>list_best*/){

        recy_main = findViewById(R.id.recy_main);
        layoutManagerBest = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recy_main.setLayoutManager(layoutManagerBest);
        main_adapter = new MainJobAdapter(JobsWork.jobModels);
        recy_main.setItemAnimator(new DefaultItemAnimator());
        recy_main.setHasFixedSize(true);
        recy_main.setClickable(true);
        recy_main.setAdapter(main_adapter);



    }




}
