package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    @Test
    @DisplayName("Test array sorted")
    void test(){
        int[] numbers = {25, 8, 21, 32, 3};
        int[] expectedArray = {3, 8, 21, 25, 32};

        Arrays.sort(numbers);

        assertArrayEquals(numbers, expectedArray);
    }

    @Test
    //@Timeout(1)
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Test array sorted on time")
    void testSortPerformance(){
        int[] numbers = {25, 8, 21, 32, 3};
        for(int i = 0; i < 10000; i++){
            numbers[0] = i;
            Arrays.sort(numbers);
        }
    }
}
