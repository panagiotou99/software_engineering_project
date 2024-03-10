package com.example.view.editQuizes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.learningapp.R;

public class EditQuizesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.my_quizes2);
        setContentView(R.layout.activity_edit_quizes);
    }
}