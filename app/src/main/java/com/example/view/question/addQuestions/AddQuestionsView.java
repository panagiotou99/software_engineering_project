package com.example.view.question.addQuestions;

public interface AddQuestionsView {

    public String getQuestionDecription();

    public String getfalseAnswer1();

    public String getfalseAnswer2();

    public String getfalseAnswer3();

    public String getCorrectAnswer();

    public int getDifficulty();
    public int getType();

    public void invalidInput(String title, String info);

    public void validInput(String title);
}
