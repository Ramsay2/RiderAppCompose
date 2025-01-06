package com.apnamart.apnarider.data.http

import android.content.Context
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.core_app_framework.retrofit.MockInterceptor
import com.apnamart.apnarider.core_app_framework.retrofit.logger.Level
import com.apnamart.apnarider.core_app_framework.retrofit.logger.LoggingInterceptor
import com.sachin.riderappcompose.data.http.cookies.AddCookiesInterceptor
import com.apnamart.apnarider.data.http.services.AppInfoApiService
import com.apnamart.apnarider.data.http.services.AttendanceApiService
import com.sachin.riderappcompose.data.http.services.ConsumerAuthApiService
import com.apnamart.apnarider.data.http.services.FirebaseApiService
import com.apnamart.apnarider.data.http.services.OnboardingApiService
import com.apnamart.apnarider.data.http.services.PaymentApiService
import com.apnamart.apnarider.data.http.services.RiderCashCollectionApiService
import com.apnamart.apnarider.data.http.services.SaleApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    
    fun contributeApiHelper(apiHelper: ApiHelperImpl): ApiHelper {
        return apiHelper
    }

    @Provides
    
    fun contributeLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
//            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BODY)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
//            .addHeader("version", BuildConfig.VERSION_NAME)
            .build()
    }

    @Provides
    
    fun contributeAddCookiesInterceptor(context: Context): AddCookiesInterceptor {
        return AddCookiesInterceptor(context)
    }

    @Provides
    
    fun contributeMockInterceptor() : MockInterceptor {
        return MockInterceptor()
    }

    @Provides
    
    fun contributeOkHttpClient(
        loggingInterceptor: LoggingInterceptor,
        addCookiesInterceptor: AddCookiesInterceptor,
        mockInterceptor: MockInterceptor
    ): OkHttpClient {
        var clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(5, TimeUnit.SECONDS)
        clientBuilder.readTimeout(120, TimeUnit.SECONDS)
       /* if (BuildConfig.DEBUG) {
            clientBuilder = clientBuilder
                .addInterceptor(loggingInterceptor)
                .addInterceptor(mockInterceptor)

        }*/
        return clientBuilder
            .addInterceptor(addCookiesInterceptor)
            .build()
    }

    @Provides
    
    fun contributeRetrofit(client: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        return builder
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .client(client)
            .build()
    }

    @Provides
    fun contributeConsumerAuthApiService(retrofit: Retrofit): ConsumerAuthApiService {
        return retrofit.create(ConsumerAuthApiService::class.java)
    }

    @Provides
    fun contributeFirebaseApiService(retrofit: Retrofit): FirebaseApiService {
        return retrofit.create(FirebaseApiService::class.java)
    }

    @Provides
    fun contributeAppInfoApiService(retrofit: Retrofit): AppInfoApiService {
        return retrofit.create(AppInfoApiService::class.java)
    }

    @Provides
    fun contributeSaleApiService(retrofit: Retrofit): SaleApiService {
        return retrofit.create(SaleApiService::class.java)
    }

    @Provides
    fun contributeAttendanceApiService(retrofit: Retrofit): AttendanceApiService {
        return retrofit.create(AttendanceApiService::class.java)
    }

    @Provides
    fun contributePaymentApiService(retrofit: Retrofit): PaymentApiService {
        return retrofit.create(PaymentApiService::class.java)
    }

    @Provides
    fun contributeRiderCashCollectionApiService(retrofit: Retrofit): RiderCashCollectionApiService {
        return retrofit.create(RiderCashCollectionApiService::class.java)
    }

    @Provides
    fun contributeOnboardingApiService(retrofit: Retrofit): OnboardingApiService {
        return retrofit.create(OnboardingApiService::class.java)
    }
}