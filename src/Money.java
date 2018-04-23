import java.util.Objects;

public class Money {
    private long value;

    public Money(long value) {
        this.value = value;
    }

    private long getValue() {
        return value;
    }

    private long getTotalPart() {
        return value/100;
    }

    private long getFractionalPart() {
        return value%100;
    }

    public void add(Money money) {
        value += money.getValue();
    }

    public String toString() {
        if(getFractionalPart()<10) return getTotalPart() + ".0" + getFractionalPart();
        else return getTotalPart() + "." + getFractionalPart();
    }
}
