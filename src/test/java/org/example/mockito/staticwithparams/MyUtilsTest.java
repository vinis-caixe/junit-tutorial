package org.example.mockito.staticwithparams;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

class MyUtilsTest {

    @Test
    void shouldMockStaticMethodWithParams() {
        try(MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
            mockedStatic.when(() -> MyUtils.getWelcomeMessage(eq("Erudio"), anyBoolean()))
                    .thenReturn("Howdy Erudio!");

            String result = MyUtils.getWelcomeMessage("Erudio", false);

            assertEquals("Howdy Erudio!", result);
        }
    }

}