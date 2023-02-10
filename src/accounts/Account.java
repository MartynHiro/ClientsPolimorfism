package accounts;

import clients.MoneyTarget;

public abstract class Account implements MoneyTarget {
    protected long balance;
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);

    public void transfer(Account accountTo, int amount) {
        if (pay(amount)) { //проверили можно ли списать
            this.balance -= amount; //сняли с этого аккаунта деньги
            accountTo.add(amount); //переводим на тот, который указали
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Перевод на сумму " + amount + "руб. со счёта " + this.name + " на счёт " + accountTo.name + " прошёл успешно");
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Невозможно совершить перевод");
        }
    }

    @Override
    public String toString() {
        return "Этот аккаунт называется: " + getName() + "\n" +
                "На его счету будет доступно после операции: " + getBalance();
    }
}
