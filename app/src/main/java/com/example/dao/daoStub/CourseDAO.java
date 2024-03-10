package com.example.dao.daoStub;

import com.example.domain.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for doing CRUD operations related to {@link Course}
 *
 * @author Panagiotis Panagiotou
 * @author Elena Fourtouni
 * @author Olga Margeli
 */
public interface CourseDAO{


    /**
     * Find a {@link Course}
     *
     * @param courseId The unique id of the course
     * @return The course object or {@code null} if not found.
     */
    public Course find(String courseId);

    /**
     * Either saves the {@link Course} in storage or updates an existing one if already exists
     *
     * @param course The course you want to either save or update in storage.
     */
    public void save(Course course);

    /**
     * Removes the {@link Course}
     *
     * @param course The unique course object
     */
    public void delete(Course course);

    /**
     * Get all {@link Course}
     *
     * @return All {@link Course} that are in storage
     */
    public List<Course> findAll();
}
