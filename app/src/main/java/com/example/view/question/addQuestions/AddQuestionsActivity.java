package com.example.view.question.addQuestions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.learningapp.R;


public class AddQuestionsActivity extends AppCompatActivity implements AddQuestionsView {

    EditText questionDescription,correctAns,falseAns1,falseAns2,falseAns3;
    RadioGroup difficultyGroup,typeGroup;
    RadioButton difficultyButton,typeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.add_questions2);
        setContentView(R.layout.activity_add_questions);

        difficultyGroup = findViewById(R.id.radioGroupDifficulty);
        typeGroup = findViewById(R.id.radioGroupType);

        questionDescription = findViewById(R.id.editQuestionDescription);
        correctAns= findViewById(R.id.editCorrectAnswerDesription);
        falseAns1= findViewById(R.id.editFalseAnswer1Description);
        falseAns2 = findViewById(R.id.editFalseAnswer2Description);
        falseAns3 = findViewById(R.id.editFalseAnswer3Description);

        Button addQuestionButton =  findViewById(R.id.addQuestionButton);
        Initializer initializer = new MemoryInitializer();
        try {
            initializer.prepareData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AddQuestionsPresenter presenter = new AddQuestionsPresenter(this, initializer.getQuestionDAO());
        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioDifficultyId = difficultyGroup.getCheckedRadioButtonId();
                difficultyButton = findViewById(radioDifficultyId);
                int radioTypeId = typeGroup.getCheckedRadioButtonId();
                typeButton = findViewById(radioTypeId);
                presenter.processQuestionRequest();
            }
        });
    }

    @Override
    public String getQuestionDecription(){
        return questionDescription.getText().toString();
    }

    @Override
    public String getCorrectAnswer(){
        return correctAns.getText().toString();
    }

    @Override
    public String getfalseAnswer1(){
        return falseAns1.getText().toString();
    }

    @Override
    public String getfalseAnswer2(){
        return falseAns2.getText().toString();
    }

    @Override
    public String getfalseAnswer3(){
        return falseAns3.getText().toString();
    }

    public void checkLevelButton(View view) {
        int radioDifficultyId = difficultyGroup.getCheckedRadioButtonId();
        difficultyButton = findViewById(radioDifficultyId);
        Toast.makeText(this,"Eπίπεδο δυσκολίας: " + difficultyButton.getText(),Toast.LENGTH_SHORT).show();
    }

    public void checkTypeButton(View view) {
        int radioTypeId = typeGroup.getCheckedRadioButtonId();
        typeButton = findViewById(radioTypeId);
        if (typeButton.getId()==R.id.multipleChoice){
            correctAns.setVisibility(View.VISIBLE);
            falseAns1.setVisibility(View.VISIBLE);
            falseAns2.setVisibility(View.VISIBLE);
            falseAns3.setVisibility(View.VISIBLE);
        }else{
            correctAns.setVisibility(View.INVISIBLE);
            falseAns1.setVisibility(View.INVISIBLE);
            falseAns2.setVisibility(View.INVISIBLE);
            falseAns3.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getType(){
        int radioTypeId = typeGroup.getCheckedRadioButtonId();
        typeButton = findViewById(radioTypeId);
        if (typeButton.getId()==R.id.trueIsCorrect){
            return 1;
        }
        else if(typeButton.getId()==R.id.falseIsCorrect){
            return 2;
        }
        else{
            return 3;
        }
    }

    @Override
    public int getDifficulty(){
        int radioDifficultyId = difficultyGroup.getCheckedRadioButtonId();
        difficultyButton = findViewById(radioDifficultyId);
        if (difficultyButton.getId()==R.id.radioBtnEasy){
            return 1;
        }
        else if(difficultyButton.getId()==R.id.radioBtnMedium){
            return 2;
        }
        else{
            return 3;
        }
    }

    @Override
    public void invalidInput(String title,String message){
        new AlertDialog.Builder(AddQuestionsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    public void validInput(String title){
        new AlertDialog.Builder(AddQuestionsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setPositiveButton(R.string.ok, null).create().show();
        questionDescription.getText().clear();
        correctAns.getText().clear();
        falseAns1.getText().clear();
        falseAns2.getText().clear();
        falseAns3.getText().clear();
    }
}