package com.theradikalsoftware.week5.rfitservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InstagramService {

    @GET("")
    Call<List> getUserAuth();

    @POST()
    Call<List> getUser();
}
