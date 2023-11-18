package edu.hw3.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAtbash {

    @Test
    public void shouldThrowNullException() {
        NullPointerException exc = Assertions.assertThrows(NullPointerException.class, () -> Atbash.encode(null));
        Assertions.assertEquals(NullPointerException.class, exc.getClass());
        NullPointerException exc2 = Assertions.assertThrows(NullPointerException.class, () -> Atbash.encode(""));
        Assertions.assertEquals(NullPointerException.class, exc2.getClass());
    }

    @Test
    public void testCorrectEncode() {
        Assertions.assertEquals("Svool dliow!", Atbash.encode("Hello world!"));

        Assertions.assertEquals(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
            Atbash.encode("Any fool can write code that a computer can understand." +
                " Good programmers write code that humans can understand. ― Martin Fowler")
        );
    }
}
