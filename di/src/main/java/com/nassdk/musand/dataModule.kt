package com.nassdk.musand

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val dataModule = module {

    single {

        val builder = OkHttpClient().newBuilder()
        builder.readTimeout(15, TimeUnit.SECONDS)
        builder.connectTimeout(10, TimeUnit.SECONDS)

//        if (BuildConfig.DEBUG) {
//        }


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        //Extra Headers

        //builder.addNetworkInterceptor().add(chain -> {
        //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
        //  return chain.proceed(request);
        //});

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit
            .Builder()
            .baseUrl("https://api.jamendo.com/v3.0/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    factory<ApiService> { get<Retrofit>().create(ApiService::class.java) }

}