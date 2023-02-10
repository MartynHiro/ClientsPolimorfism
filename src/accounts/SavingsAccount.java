package accounts;

public class SavingsAccount extends Account {
    private long limit;

    public SavingsAccount(String name, long balance, long limit) {
        super.setName(name);
        super.setBalance(balance);
        if (limit >= 0) {
            this.limit = limit;
        } else {
            System.out.println("Вы не можете установить минусовой лимит");
        }
    }

    @Override
    public boolean pay(long amount) { //не выходим за пределы (баланс - лимит)
        if (amount <= (getBalance() - limit)) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
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
    public boolean add(long amount) {
        balance += amount;
        return true;
    }


    @Override
    public String toString() {
        return "Тип : накопительный аккаунт\n" +
                super.toString() + " не забывайте, что у вас установлен лимит ниже которого нельзя опуститься: " + limit;
    }
}