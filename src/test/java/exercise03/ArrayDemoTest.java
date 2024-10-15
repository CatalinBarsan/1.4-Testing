package exercise03;

import static org.junit.jupiter.api.Assertions.*;

import org.example.exercise03.ArrayDemo;
import org.junit.jupiter.api.Test;

class ArrayDemoTest {

    @Test
    void testGetElementThrowsArrayIndexOutOfBoundsException() {
        ArrayDemo arrayDemo = new ArrayDemo(new int[]{1, 2, 3});

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arrayDemo.getElement(5); // Accessing an index that does not exist
        });
    }
}
