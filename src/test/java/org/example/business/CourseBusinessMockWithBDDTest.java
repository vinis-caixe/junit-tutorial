package org.example.business;

import org.example.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class CourseBusinessMockWithBDDTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup() {
        // Given
        mockService = Mockito.mock(CourseService.class);
        business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // Given
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        // When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        // Then
        assertThat(filteredCourses.size(), is(4));
    }

    @Test
    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourse() {
        // Given
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        // When
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then
        verify(mockService).deleteCourse("Spotify Engineering Culture Desmistificado");
        verify(mockService, times(1)).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
        verify(mockService, atLeast(1)).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
        verify(mockService, never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Spring Boot e Docker");
    }

    @Test
    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method V2")
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourseV2() {
        // Given
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        // When
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then
        then(mockService).should().deleteCourse("Spotify Engineering Culture Desmistificado");
        then(mockService).should().deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
        then(mockService).should(never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Spring Boot e Docker");
    }

    @Test
    @DisplayName("Delete Courses not Related to Spring Capturing Arguments should call Method")
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourse() {
        // Given
        courses = Arrays.asList(
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );

        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String spotifyCourse = "Spotify Engineering Culture Desmistificado";

        // When
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then
        then(mockService).should().deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is(spotifyCourse));
    }

    @Test
    @DisplayName("Delete Courses not Related to Spring Capturing Arguments should call Method V2")
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourseV2() {
        // Given
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // When
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then
        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }

}