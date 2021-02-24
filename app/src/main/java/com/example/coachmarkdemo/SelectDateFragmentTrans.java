package com.example.coachmarkdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class SelectDateFragmentTrans extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }


    @Override
    public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
        String date1 = dd+"/"+ mm+1 +"/"+yy;
        Toast.makeText(getActivity(), "Date is: "+ date1, Toast.LENGTH_LONG).show();
    }
}
