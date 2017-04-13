import java.math.BigDecimal;

public class Customer {

    private BigDecimal customerId;

    public Customer() {
    }

    public Customer(BigDecimal customerId) {
        this.customerId = customerId;
    }

    public void setCustomerId(BigDecimal customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return customerId.toString();
    }

}
