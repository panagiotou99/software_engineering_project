package com.example.dao.daoMemory;

import com.example.dao.daoStub.CourseDAO;
import com.example.domain.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOMemory implements CourseDAO {
    protected static ArrayList<Course> courseList = new ArrayList<>();

    /**
     * Find a {@link Course}
     *
     * @param courseId The unique id of the course
     * @return The course object or {@code null} if not found.
     */
    public Course find(String courseId) {
        for (Course c : courseList) {
            if (c.getId().equals(courseId))
                return c;
        }
        return null;
    }

    /**
     * Either saves the {@link Course} in storage or updates an existing one if already exists
     *
     * @param course The course you want to either save or update in storage.
     */
    public void save(Course course) {
        delete(course);
        courseList.add(course);
    }

    /**
     * Removes the {@link Course}
     *
     * @param course The unique course object
     */
    public void delete(Course course) {
        courseList.remove(course);
    }

    /**
     * Get all {@link Course}
     *
     * @return All {@link Course} that are in storage
     */
    public List<Course> findAll() {
        return new ArrayList<>(courseList);
    }
}
