package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAtbash {

    @Test
    public void testEncode() {
        Assertions.assertEquals("Svool dliow!", Atbash.encode("Hello world!"));
        Assertions.assertEquals(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
            Atbash.encode("Any fool can write code that a computer can understand." +
                " Good programmers write code that humans can understand. ― Martin Fowler")
        );
    }
}
