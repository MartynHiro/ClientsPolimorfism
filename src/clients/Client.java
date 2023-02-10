package clients;

import accounts.Account;

public class Client implements MoneyTarget {
    protected String name;
    protected Account[] accounts;

    public Client(String name, int maxAccounts) {
        this.name = name;
        this.accounts = new Account[maxAccounts];
    }

    @Override
    public boolean accept(int money) {
        for (Account account : accounts) {
            if (account.add(money)) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Полученные деньги в размере " + money + "руб. зачислены на счёт "
                        + account.getName() + "\nНа его счету теперь " + account.getBalance());
                return true;
            }
        }
        System.out.println("Нет подходящих аккаунтов для пополнения");
        return false;
    }

    public void addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {           //проверка есть ли место для добавления нового аккаунта этому клиенту
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Места для добавления нового счёта нет!");
    }

    public void isPayPossible(int amount) {
        for (Account account : accounts) {
            if (account != null) {
                if (account.pay(amount)) {
                    System.out.println("Покупка на сумму " + amount + " оплачена\n" + "Доп. информация об оплате -- " + account + "\n" +
                            "-----------------------------------------------------------------");
                }
            }
        }
    }
}
