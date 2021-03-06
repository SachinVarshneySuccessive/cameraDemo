package com.capturesignature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.capturesignature.view.SignatureView
import com.example.coachmarkdemo.R
import kotlinx.android.synthetic.main.fragment_signature_dialog.*

class SignatureDialogFragment(private val onSignedListener: OnSignedCaptureListener) :
    DialogFragment(),
    SignatureView.OnSignedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        return inflater.inflate(R.layout.fragment_signature_dialog, container, false)
    }

    override fun getTheme(): Int {
        return R.style.Dialog_App
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCancel.setOnClickListener { dismiss() }
        buttonClear.setOnClickListener { signatureView.clear() }
        buttonOk.setOnClickListener {
            onSignedListener.onSignatureCaptured(signatureView.getSignatureBitmap(), "")
            dismiss()
        }
        signatureView.setOnSignedListener(this)

    }

    override fun onStartSigning() {

    }

    override fun onSigned() {
        buttonOk.isEnabled = true
        buttonClear.isEnabled = true
    }

    override fun onClear() {
        buttonClear.isEnabled = false
        buttonOk.isEnabled = false
    }
}