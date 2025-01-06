package com.apnamart.apnarider.domain.attendance

import com.apnamart.apnarider.domain.attendance.usecase.GetRiderAttendanceStatusUseCase
import com.apnamart.apnarider.domain.attendance.usecase.MarkInRiderUseCase
import com.apnamart.apnarider.domain.attendance.usecase.MarkOutRiderUseCase

interface AttendanceHelper {
    val getRiderAttendanceStatusUseCase: GetRiderAttendanceStatusUseCase
    val markInRiderUseCase: MarkInRiderUseCase
    val markOutRiderUseCase: MarkOutRiderUseCase
}