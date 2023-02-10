import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Sergey", 3); //новый клиент

        Account saving = new SavingsAccount("save", 15_000, 5_000);  //новый счёт
        Account crediting = new CreditAccount("credit", 0);
        Account checking = new CheckingAccount("check", 7_000);

        client.addAccount(checking);//основной расчётный аккаунт
        client.addAccount(saving); //сберегательный акк, с которого будет пытаться списать, если не хватает на расчётном
        client.addAccount(crediting); //если ни на одном аккаунте не хватит денег на покупку, то берем в кредит

        client.addAccount(saving); //счёт для проверки метода отказа в добавлении

        client.isPayPossible(6_000); //покупка (пройдёт с расчётного)
        client.isPayPossible(8_000);//покупка (пройдёт со сберегательного счёта, так как не хватит на расчётном)
        client.isPayPossible(20_000);//покупка (на наших счетах недостаточно средств, берём в кредит)

        crediting.add(15_000); //тут сразу внесли первую сумму за наш кредит
        System.out.println("Осталось до погашения кредита: " + crediting.getBalance());

        crediting.transfer(checking, 50); //проверка работает ли перевод
        checking.transfer(saving, 100_000); //проверка на слишком большой платёж

        client.accept(100_000); //проверка получения денег с автоматическим зачислением на один из счетов
        saving.accept(100);//проверка добавления полученных денег через тот же интерфейс, но на определенный счет
    }
}