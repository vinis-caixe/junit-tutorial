package org.example.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        // Given
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        // When & Then
        assertEquals(10, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30);

        // When & Then
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(30, list.size());
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnErudio() {
        // Given
        var list = mock(List.class);
        when(list.getFirst()).thenReturn("Erudio");

        // When & Then
        assertEquals("Erudio", list.getFirst());
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
        // Given
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Erudio");

        // When & Then
        assertEquals("Erudio", list.get(anyInt()));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        // Given
        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));

        // When & Then
        assertThrows(RuntimeException.class,
                () -> {list.get(anyInt());},
                () -> "Should have thrown a RuntimeException");
    }
}
