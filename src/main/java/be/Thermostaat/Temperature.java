package be.Thermostaat;



public class Temperature {
    private float value;

    public Temperature(float t) {
        this.value = t;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isBoiling() {
        return value>=100f;
    }

    public boolean isFreezing() {
        return value<=0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature)) return false;

        Temperature that = (Temperature) o;

        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return (value != +0.0f ? Float.floatToIntBits(value) : 0);
    }
}
