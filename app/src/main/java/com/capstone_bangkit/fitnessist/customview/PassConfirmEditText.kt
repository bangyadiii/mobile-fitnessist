package com.capstone_bangkit.fitnessist.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.capstone_bangkit.fitnessist.R

class PassConfirmEditText: AppCompatEditText {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val passconf = s.toString()
                when {
                    passconf.isBlank() -> error = context.getString(R.string.empty_passconf)
                    passconf.length < 8 -> error = context.getString(R.string.invalid_password)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
}