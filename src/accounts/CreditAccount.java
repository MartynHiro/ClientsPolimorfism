package accounts;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreditAccount extends Account {
    public CreditAccount(String name, long balance) {
        super.setName(name);
        if (balance <= 0) {
            super.setBalance(balance);
        } else {
            System.out.println("Баланс не может быть положительным");
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
    public boolean pay(long amount) { //Любая оплата пройдет, так как нам не задали выставлять лимит на кредитке
        this.balance -= amount;
        return true;
    }

    @Override
    public boolean add(long amount) {
        if (getBalance() <= 0 && (getBalance() + amount) <= 0) {
            this.balance += amount;
            return true;
        } else {
            System.out.println("Невозможно пополнить так как кредитный счёт превысит 0 значение");
            return false;
        }
    }

    @Override
    public String toString() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, 3);
        return "Тип : кредитный аккаунт\n" +
                super.toString() + "\n" +
                "У вас есть 3 месяца без процентов, не забудьте оплатить до: " + calendar.getTime();
    }
}