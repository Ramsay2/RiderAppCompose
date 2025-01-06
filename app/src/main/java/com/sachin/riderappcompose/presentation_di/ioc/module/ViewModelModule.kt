package com.apnamart.apnastore.presentation_di.ioc.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apnamart.apnarider.core_app_framework.ioc.qualifier.ViewModelKey
import com.apnamart.apnastore.presentation_di.ioc.factory.ViewModelFactory
import com.sachin.riderappcompose.presentation.auth_screen.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton
