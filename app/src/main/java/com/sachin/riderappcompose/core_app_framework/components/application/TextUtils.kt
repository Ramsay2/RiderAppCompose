package com.apnamart.apnarider.core_app_framework.components.application

import android.text.Editable
import android.text.TextWatcher

interface SimpleTextWatcher: TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        finalText(s.toString().trim())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    fun finalText(string: String)
}