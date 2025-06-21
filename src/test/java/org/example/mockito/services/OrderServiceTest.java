package org.example.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

    @Test
    @DisplayName("Should Include Random Order Id when no Order Id Exists")
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
        // Given
        try(MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            // When
            Order result = service.createOrder("MacBook Pro", 2L, null);

            // Then
            assertEquals(defaultUuid.toString(), result.getId());
        }
    }

    @Test
    @DisplayName("Should Include Include Current Time when Create a New Order")
    void testShouldIncludeCurrentTime_When_CreateANewOrder() {
        // Given
        try(MockedStatic<LocalDateTime> mockedLocalDateTime = Mockito.mockStatic(LocalDateTime.class)) {
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            // When
            Order result = service.createOrder("MacBook Pro", 2L, null);

            // Then
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }

}