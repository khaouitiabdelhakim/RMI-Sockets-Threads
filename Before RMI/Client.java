public class Client {

    public static void main(String[] args) {
        Account account = new Account(1000) ;
        account.changeAmount(300);
        account.changeAmount(-700);
        System.out.println("Amount is : " + account.getAmount());
    }
}
