package org.example.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListWithBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        // Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        // When & Then
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20).willReturn(30);

        // When & Then
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(30));
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnErudio() {
        // Given
        var list = mock(List.class);
        given(list.getFirst()).willReturn("Erudio");

        // When & Then
        assertThat(list.getFirst(), is("Erudio"));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
        // Given
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn("Erudio");

        // When & Then
        assertThat(list.get(anyInt()), is("Erudio"));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        // Given
        var list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!!"));

        // When & Then
        assertThrows(RuntimeException.class,
                () -> {list.get(anyInt());},
                () -> "Should have thrown a RuntimeException");
    }
}
