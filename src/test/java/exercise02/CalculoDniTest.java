package exercise02;

import org.example.exercise02.CalculateDni;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class CalculoDniTest {

    // Test parametrizado para calcular la letra del DNI
    @ParameterizedTest
    @CsvSource({
            "99999999, R",
            "12345678, Z",
            "87654321, X",
            "11111111, H"
    })
    void testCalculateDniLetter(int dniNumber, char expectedLetter) {
        assertEquals(expectedLetter, CalculateDni.calculateDniLetter(dniNumber));
    }

    // Test parametrizado para números inválidos
    @ParameterizedTest
    @ValueSource(ints = {-1, 100000000})
    void testCalculateDniLetterInvalidNumber(int invalidDni) {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculateDni.calculateDniLetter(invalidDni);
        });
    }
}
