package org.example;

import org.example.model.Person;
import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;
    IPersonService service;

    @BeforeEach
    void setup() {
        person = new Person(
                "Keith",
                "Moon",
                "kmoon@erudio.com.br",
                "Wembley - UK",
                "Male"
        );

        service = new PersonService();
    }

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        // Given

        // When
        Person actual = service.createPerson(person);

        // Then
        assertNotNull(actual, () -> "The createPerson should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contain All Fields in Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainFirstNameInReturnedPersonObject() {
        // Given

        // When
        Person actual = service.createPerson(person);

        // Then
        assertNotNull(person.getId(), () -> "Person ID is Missing!");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The firstName is different!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "The lastName is different!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "The address is different!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is different!");
        assertEquals(person.getGender(), actual.getGender(), () -> "The gender is different!");
    }

    @DisplayName("When Create a Person with Null E-mail Should Throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        // Given
        person.setEmail(null);

        var expectedMessage = "The Person e-Mail is null or empty!";

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Empty e-Mail should have caused an IllegalArgumentException!");

        // Then
        assertEquals(
                expectedMessage,
                exception.getMessage(),
                () -> "Exception error message is incorrect!"
        );
    }
}
