package be.Thermostaat;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TemperatureTest {
    private Temperature temp;
    private Temperature temp2;

    @BeforeEach
    void init() {
         temp = new Temperature(0);
         temp2 = new Temperature(0);
    }

    @Test
    @DisplayName("Check constructor")
    void Temperature(){
        temp.setValue(23.5f);
        assertEquals(23.5f, temp.getValue());
    }

    @Test
    @DisplayName("Check value getter")
    void testGetValue() {
        temp.setValue(23.5f);
        assertEquals(23.5f,temp.getValue()); }

    @Test
    @DisplayName("Check value setter")
    void testSetValue() {
        temp.setValue(33.5f);
        assertEquals(33.5f,temp.getValue());
    }

    @Test
    @DisplayName("Test isBoilingIsTrue")
    void testIsBoilingisTrue() {
        temp.setValue(101f);
        assertEquals(true,temp.isBoiling());
    }

    @Test
    @DisplayName("Test isBoilingIsTrue")
    void testIsBoilingisFalse()  {
        temp.setValue(10f);
        assertEquals(false,temp.isBoiling());
    }

    @Test
    @DisplayName("Test isFreezingisTrue")
    void testIsFreezingIsTrue()  {
        temp.setValue(-2f);
        assertEquals(true,temp.isFreezing());
    }

    @Test
    void testException() {
        Temperature t = new Temperature(0);
        assertThrows(InvalidTemperatureException.class, () -> t.setValue(-400F));
    }

    @Test
    void testNoException() {
        assertDoesNotThrow(() -> temp.setValue(-200));
    }

    @Test
    void testIfConstructorThrowsAnExceptionsBecauseItIsVeryImportantToCheckThisIfThisDoesOrDOesNotHappen() {
        assertThrows(InvalidTemperatureException.class, () -> new Temperature(-400f));
    }

    @Test
    @DisplayName("Test isFreezingisFalse")
    void testIsFreezingisFalse() {
        temp.setValue(2f);
        assertEquals(false,temp.isFreezing());
    }

    @Test
    @DisplayName("Check equals")
    void testEquals() {
        temp2.setValue(0f);
        assertEquals(temp, temp2);
    }

    @Test
    @DisplayName("Check hashcode")
    void testHashCode() {
        //temp2.setValue(23.5f);
        assertEquals(temp.hashCode(), temp2.hashCode());
    }
}