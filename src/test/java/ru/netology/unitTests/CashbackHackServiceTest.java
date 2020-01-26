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

    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackHackServiceTestData.csv", numLinesToSkip = 1)
    void checkCashbackHackService(int amount, int expected, String message) {
        actual = cashbackHackService.remain(amount);
        assertEquals(expected, actual, message);
    }

    @Test
    @DisplayName("Должен выбросить исключение, если значение amount = 0")
    public void shouldReturnIllegalArgumentExceptionIfAmountEqualsZero() throws IllegalArgumentException {
        amount = 0;
        assertThrows(IllegalArgumentException.class, () -> cashbackHackService.remain(amount));
    }
}