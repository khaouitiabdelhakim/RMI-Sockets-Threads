public class Account {

    float amount;

    public Account(float amount) {
        this.amount = amount;
    }

    public void changeAmount(float amount)  {
        this.amount += amount;
    }

    public float getAmount() {
        return this.amount;
    }
}

