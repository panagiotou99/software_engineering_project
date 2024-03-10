package com.example.view.question.addQuestions;

public class AddQuestionsStub implements AddQuestionsView{
    String description,correctAnswer,falseAnswer1,falseAnswer2,falseAnswer3,title,info;
    int difficulty,type;

    public AddQuestionsStub(){
        this.description="";
        this.difficulty=-1;
        this.type=-1;
        this.correctAnswer="";
        this.falseAnswer1="";
        this.falseAnswer2="";
        this.falseAnswer3="";
    }

    public void setDescription(String description){
        this.description=description;

    }

    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer=correctAnswer;
    }

    public void setFalseAnswer1(String falseAnswer1){
        this.falseAnswer1=falseAnswer1;
    }

    public void setFalserAnswer2(String falseAnswer2){
        this.falseAnswer2=falseAnswer2;
    }

    public void setFalseAnswer3(String falseAnswer3){
        this.falseAnswer3=falseAnswer3;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty=difficulty;
    }

    public void setType(int type) {
        this.type=type;
    }

    @Override
    public String getQuestionDecription(){
        return description;
    }

    @Override
    public String getfalseAnswer1(){
        return falseAnswer1;
    }

    @Override
    public String getfalseAnswer2(){
        return falseAnswer2;
    }

    @Override
    public String getfalseAnswer3(){
        return falseAnswer3;
    }

    @Override
    public String getCorrectAnswer(){
        return correctAnswer;
    }

    @Override
    public int getDifficulty(){
        return difficulty;
    }

    @Override
    public int getType(){
        return type;
    }

    @Override
    public void invalidInput(String title, String info){
        this.title=title;
        this.info=info;
    }

    @Override
    public void validInput(String title){
        this.title=title;
}
}

