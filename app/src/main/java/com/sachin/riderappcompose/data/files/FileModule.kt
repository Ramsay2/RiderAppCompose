package com.apnamart.apnarider.data.files

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FileModule {

    @Provides
    fun contributeFileHelper(fileHelper: FileHelperImpl): FileHelper {
        return fileHelper
    }
}