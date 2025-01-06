package com.apnamart.apnarider.domain.storage_file.useCase

import android.os.Environment
import com.apnamart.apnarider.core_app_framework.getDeviceUniqueId
import com.apnamart.apnarider.core_app_framework.interactor.usecase.CompletableVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.core_app_framework.interactor.State

class SetUniqueDeviceIdUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : CompletableVoidUseCase<Unit>(dispatcherProvider) {

    override suspend fun execute(): State<Unit> {
        val path = "${Environment.getExternalStorageDirectory()}/UNIQUE_ID_FILE_PATH"
        var uniqueId = dataHelper.fileHelper.getData(
            path,
           " UNIQUE_ID_FILE_NAME"
        )

        return try {
            if (uniqueId == null) {
                uniqueId = getDeviceUniqueId(true)
                dataHelper.fileHelper.storeData(path, "UNIQUE_ID_FILE_NAME", uniqueId)
            }

            dataHelper.cacheHelper.deviceUniqueId = uniqueId
            State.success(Unit)
        } catch (e: Exception) {
            State.error(e)
        }
    }

}