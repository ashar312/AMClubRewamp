package com.project.techaract.amclub.Form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.project.techaract.amclub.Utils.References;
import com.project.techaract.amclub.Utils.TimeClass;
import com.project.techaract.amclub.databinding.ActivitySimpleFormBinding;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SimpleForm extends AppCompatActivity {
    DatePickerDialog pickerDialog;
    private ActivitySimpleFormBinding binding;
    Calendar cldr;
    int day;
    int month;
    int year;
    private String gender,society,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySimpleFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cldr = Calendar.getInstance();
        day = cldr.get(Calendar.DAY_OF_MONTH);
        month = cldr.get(Calendar.MONTH);
        year = cldr.get(Calendar.YEAR) - 18;

        binding.ageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            pickerDialog = new DatePickerDialog(SimpleForm.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        binding.ageText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
            pickerDialog.show();
            }
        });



        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFieldsEmpty()){
                    gender = binding.genderSpinner.getSelectedItem().toString();
                    society = binding.societySpinner.getSelectedItem().toString();
                    com.project.techaract.amclub.Models.SimpleForm simpleForm
                            = new com.project.techaract.amclub.Models.SimpleForm(binding.name.getText().toString(),
                            binding.email.getText().toString(),binding.phNum.getText().toString(),
                            gender,society,new TimeClass().getDate(),binding.ageText.getText().toString());
                    new References()
                            .getFirebaseFirestore()
                            .collection("SimpleFormDate")
                            .document()
                            .set(simpleForm)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SimpleForm.this, "Registration Done", Toast.LENGTH_SHORT).show();
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                onBackPressed();
                                            }
                                        }, 1500);

                                    }else{
                                        Toast.makeText(SimpleForm.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SimpleForm.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                }
            }
        });


    }
    private boolean isFieldsEmpty() {
        if (TextUtils.isEmpty(binding.name.getText())
                || TextUtils.isEmpty(binding.email.getText())
                || TextUtils.isEmpty(binding.phNum.getText())
                || TextUtils.isEmpty(binding.ageText.getText())) {
            Toast.makeText(this, "Please complete all fields to continue", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }



    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}