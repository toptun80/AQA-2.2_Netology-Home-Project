package ru.netology.unitTests;

import org.junit.jupiter.api.Test;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {
    private int amount;
    private int actual;
    private int expected;
    private final CashbackHackService cashbackHackService = new CashbackHackService();

    @Test
    void shouldReturn1IfAmount999() {
        amount = 999;
        actual = cashbackHackService.remain(amount);
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn999IfAmount1001() {
        amount = 1001;
        actual = cashbackHackService.remain(amount);
        expected = 999;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroIfAmountMultiple1000() {
        amount = 1000;
        actual = cashbackHackService.remain(amount);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn1000IfAmountEqualsZero() {
        amount = 0;
        actual = cashbackHackService.remain(amount);
        expected = 1000;
        assertEquals(expected, actual);
    }
}