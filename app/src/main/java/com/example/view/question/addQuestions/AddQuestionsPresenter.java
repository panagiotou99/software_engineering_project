package com.example.view.question.addQuestions;
import com.example.dao.daoStub.QuestionDAO;
import com.example.domain.Question;

public class AddQuestionsPresenter {

    AddQuestionsView view;
    QuestionDAO questionDAO;

    AddQuestionsPresenter(AddQuestionsView view, QuestionDAO questionDAO){
        this.view=view;
        this.questionDAO=questionDAO;
    }

    public Question processQuestionRequest() {
        if (view.getQuestionDecription().isEmpty()){
            view.invalidInput("Κενή εκφώνηση!","Συμπλήρωσε την εκφώνηση της ερώτησης και ξανα προσπάθησε.");
            return null;
        }
        int difficultyCode = view.getDifficulty();
        int typeCode = view.getType();
        String description;
        String correctAnswer,falseAnswer1,falseAnswer2,falseAnswer3;
        description = view.getQuestionDecription();
        Question newQuestion = new Question();
        if (difficultyCode==1) {
            newQuestion.setLevel("Εύκολη");
        }
        else if(difficultyCode==2) {
            newQuestion.setLevel("Μέτρια");
        }
        else {
            newQuestion.setLevel("Δύσκολη");
        }
        newQuestion.setDescription(description);
        if (typeCode==3){
            correctAnswer = view.getCorrectAnswer();
            falseAnswer1 = view.getfalseAnswer1();
            falseAnswer2 = view.getfalseAnswer2();
            falseAnswer3 = view.getfalseAnswer3();
            if (correctAnswer.isEmpty() || falseAnswer1.isEmpty() || falseAnswer2.isEmpty() || falseAnswer3.isEmpty()){
                view.invalidInput("Κενή απάντηση!","Συμπλήρωσε όλες τις απαντήσεις.");
                return null;
            }
            else if(correctAnswer.equals(falseAnswer1)||correctAnswer.equals(falseAnswer2)||correctAnswer.equals(falseAnswer3)){
                 view.invalidInput("Λάθος!","Η σωστή απάντηση είναι ίδια με μία από τις λάθος.");
                 return null;
            }
            newQuestion.questionInitMulti(correctAnswer,falseAnswer1,falseAnswer2,falseAnswer3);
        } else if (typeCode==2) {
            newQuestion.questionInitTF(false);
        } else if (typeCode==1){
            newQuestion.questionInitTF(true);
        }
        questionDAO.save(newQuestion);
        view.validInput("Question added!");
        return newQuestion;
    }

}
