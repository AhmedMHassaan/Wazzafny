package com.example.hassan.retrofit.interfaces;

import java.util.List;

import Model.DepartmentModel;
import Model.JobModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCalls {


    @GET("getAllDeps.php")
    Call<List<DepartmentModel>> getAllDepartment();

    @GET("getJobs.php")
    Call<List<JobModel>> getAllJob(@Query("dep_name") String departmentName);

}
