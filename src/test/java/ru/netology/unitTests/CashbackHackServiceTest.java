package ru.netology.unitTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {
    private int amount;
    private int actual;
    private final CashbackHackService cashbackHackService = new CashbackHackService();

    @DisplayName("Должен вернуть 1, если amount = 999")
    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackHackServiceTestData.csv", numLinesToSkip = 1)
    void shouldReturn1IfAmount999(int amount, int expected, String message) {
        actual = cashbackHackService.remain(amount);
        assertEquals(expected, actual);
    }

    @DisplayName("Должен вернуть 999, если amount = 1001")
    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackHackServiceTestData.csv", numLinesToSkip = 2)
    void shouldReturn999IfAmount1001(int amount, int expected, String message) {
        actual = cashbackHackService.remain(amount);
        assertEquals(expected, actual);
    }

    @DisplayName("Должен вернуть 0, если значение amount кратно 1000")
    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackHackServiceTestData.csv", numLinesToSkip = 3)
    void shouldReturnZeroIfAmountMultiple1000(int amount, int expected, String message) {
        actual = cashbackHackService.remain(amount);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Должен выбросить исключение, если amount = 0")
    public void shouldReturnIllegalArgumentExceptionIfAmountEqualsZero() throws IllegalArgumentException {
        amount = 0;
        assertThrows(IllegalArgumentException.class, () -> cashbackHackService.remain(amount));
    }
}