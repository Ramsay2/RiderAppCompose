package com.apnamart.apnarider.domain.attendance

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.attendance.usecase.GetRiderAttendanceStatusUseCase
import com.apnamart.apnarider.domain.attendance.usecase.MarkInRiderUseCase
import com.apnamart.apnarider.domain.attendance.usecase.MarkOutRiderUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AttendanceHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider)
    : BaseHelperImplNew(dataHelper, dispatcherProvider), AttendanceHelper {

    override val getRiderAttendanceStatusUseCase: GetRiderAttendanceStatusUseCase
        get() = GetRiderAttendanceStatusUseCase(dataHelper, dispatcherProvider)
    override val markInRiderUseCase: MarkInRiderUseCase
        get() = MarkInRiderUseCase(dataHelper, dispatcherProvider)
    override val markOutRiderUseCase: MarkOutRiderUseCase
        get() = MarkOutRiderUseCase(dataHelper, dispatcherProvider)

}