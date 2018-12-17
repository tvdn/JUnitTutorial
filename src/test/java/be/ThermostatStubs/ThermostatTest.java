package be.ThermostatStubs;

import be.Thermostaat.Temperature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThermostatTest {
    private final static int INTERVAL = 10;
    private Thermostat thermostat;
    private HeatingMock heatingMock;
//    private HeatingStub heatingStub;
//    private SensorStub sensorStub;
    private SensorMock sensorMock;

    private class HeatingStub implements Heating {
        public void setHeating(boolean status) {

        }
    }

    private class SensorStub implements Sensor {
        private float temp;

        public Temperature getTemperature() {
            return new Temperature(temp);
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }
    }

    private class HeatingMock implements Heating {
        private boolean status;

        public void setHeating(boolean status) {
            this.status = status;
        }

        //extra mock method to verify
        public boolean isHeating() {
            return status;
        }
    }

    private class SensorMock implements Sensor {
        private float temp;
        private boolean called;

        public Temperature getTemperature() {
            called = true;
            return new Temperature(temp);
        }

        //extra stub methods to control stub
        public void setTemp(float temp) {
            this.temp = temp;
        }

        //extra mock method to verify
        public boolean isCalled() {
            return called;
        }

        public void setcalled(boolean status) {
            called = status;
        }
    }

    @BeforeEach
    public void init() {
        sensorMock = new SensorMock();
        heatingMock = new HeatingMock();
        thermostat = new Thermostat(heatingMock, sensorMock);
        thermostat.setInterval(INTERVAL);
        thermostat.start();
    }

    @AfterEach
    public void destroy() {
        thermostat.stop();
    }

    @Test
    public void testThermostat()  throws InterruptedException {
        thermostat.setTargetTemperature(new Temperature(20));
        sensorMock.setTemp(15);
        sensorMock.setcalled(false);
        heatingMock.setHeating(false);
        Thread.sleep(INTERVAL * 3);
        assertTrue(thermostat.isHeating());
        assertTrue(sensorMock.isCalled());
        assertTrue(heatingMock.isHeating());
    }

    @Test
    public void testChangeCurrent() throws InterruptedException {
        sensorMock.setTemp(0);
        Temperature finalTemp = new Temperature(30);
        thermostat.setTargetTemperature(finalTemp);
        thermostat.start();
        Thread.sleep(INTERVAL * 3);
        assertTrue(thermostat.isHeating());
        sensorMock.setTemp(sensorMock.getTemperature().getValue() + 10);
        assertTrue(thermostat.isHeating());
    }

   @Test
    public void testChangeTarget() throws InterruptedException {
        sensorMock.setTemp(30);
        float temp = 10;
        thermostat.setTargetTemperature(new Temperature(temp));
        thermostat.start();
        Thread.sleep(INTERVAL *3);

        assertTrue(!thermostat.isHeating());
        thermostat.setTargetTemperature(new Temperature(temp += 20));
        assertTrue(!thermostat.isHeating());

   }


}
