package com.example.view.course.courseCreation;

import com.example.dao.daoStub.CourseDAO;
import com.example.domain.Course;
import com.example.util.SchoolCourse;


public class CreateCoursePresenter {
    CreateCourseActivity view;
    CourseDAO courseDAO;

    public CreateCoursePresenter(CreateCourseActivity view, CourseDAO courseDAO) {
        this.view = view;
        this.courseDAO = courseDAO;
    }

    public void onSubmitForm(){
        if (view.getCourseID().isEmpty() || view.getCourseGrade().isEmpty() || view.getCourseTitle().isEmpty() || view.getCoursePrice().isEmpty() || view.courseDescription().isEmpty()){
            view.showEmptyInputMessage();
            return;
        }
        int x = Integer.parseInt(view.getCourseGrade());
        if (x<1 || x >13){
            view.showInvalidGradeMessage();
            return;
        }
        Course newCourse = new Course(view.getCourseID(), new SchoolCourse(Integer.parseInt(view.getCourseGrade()),view.getCourseTitle()),Float.parseFloat(view.getCoursePrice()), view.courseDescription());
        courseDAO.save(newCourse);
        view.onValidInput();
    }
}
