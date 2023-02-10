package accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(String name, long balance) {
        super.setName(name);
        super.setBalance(balance);
    }

    @Override
    public boolean accept(int money) {
        if (add(money)) {
            System.out.println("Добавление средств на выбранный счёт прошло успешно");
            return true;
        } else {
            System.out.println("Добавление средств на этот счёт невозможно");
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (getBalance() >= amount) {   //счёт не может быть меньше 0
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(long amount) {
        this.balance += amount;
        return true;
    }


    @Override
    public String toString() {
        return "Тип : расчётный аккаунт\n" +
                super.toString();
    }
}