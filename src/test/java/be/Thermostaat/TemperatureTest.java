package be.Thermostaat;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TemperatureTest {
    private Temperature temp;
    private Temperature temp2;

    @BeforeEach
    void init() {
         temp = new Temperature(23.5f);
         temp2 = new Temperature(45.5f);
    }

    @Test
    @DisplayName("Check constructor")
    void Temperature() { assertEquals(23.5f, temp.getValue()); }

    @Test
    @DisplayName("Check value getter")
    void testGetValue() { assertEquals(23.5f,temp.getValue()); }

    @Test
    @DisplayName("Check value setter")
    void testSetValue() {
        temp.setValue(33.5f);
        assertEquals(33.5f,temp.getValue());
    }

    @Test
    @DisplayName("Check equals")
    void testEquals() {
        temp2.setValue(23.5f);
        assertEquals(temp, temp2);
    }

    @Test
    @DisplayName("Check hashcode")
    void testHashCode() {
        //temp2.setValue(23.5f);
        assertEquals(temp.hashCode(), temp2.hashCode());
    }
}