package org.example.business;

import org.example.service.CourseService;
import org.example.service.stub.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseBusinessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        // Then
        assertEquals(4, filteredCourses.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStub() {
        // Given
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");

        // Then
        assertEquals(0, filteredCourses.size());
    }

}