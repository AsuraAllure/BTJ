package edu.hw5.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRegex {
    @Test
    public void testSuccess() {

        Assertions.assertTrue(CarIDRegex.carRegex.matcher("А001ВВ124").find());
        Assertions.assertTrue(CarIDRegex.carRegex.matcher("А001ВВ14").find());
        Assertions.assertTrue(CarIDRegex.carRegex.matcher("А121ВВ124").find());
        Assertions.assertTrue(CarIDRegex.carRegex.matcher("А011ВВ14").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А001ВВ00").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А001ВВ000").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А121ВВ024").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А000ВВ12").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А000ВВ420").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А121>В344").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("121>В344").find());

        Assertions.assertFalse(CarIDRegex.carRegex.matcher("123АВЕ777").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А123ВГ77").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А123ВЕ7777").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("w").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("1А435ВВ56").find());
        Assertions.assertFalse(CarIDRegex.carRegex.matcher("А011ВВ1444").find());
    }
}
