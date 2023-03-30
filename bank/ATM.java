package bank;

import client.Client;

import java.util.Scanner;
public class ATM implements FunctionsATM {
    Scanner scanner = new Scanner(System.in);
    Bank bank = new Bank();
    Client client = new Client();
    private void workATM() {
        System.out.println("Выберите действие" + "\n" + "Баланс (1)" + "\n"
                + "Снять со счёта (2)" + "\n" + "Пополнить счёт (3)" +
                "\n" + "Выход (4)");

        String input = scanner.nextLine();

        if (input.equals("1")) {
            checkBalance();
        }
        if (input.equals("2")) {
            cashWithdrawal();
        }
        if (input.equals("3")) {
            refilling();
        }
    }
    @Override
    public void checkBalance() {
        System.out.println("Ваш баланс " + Client.cardBalance);
    }
    @Override
    public void refilling() {
        System.out.println("Введите сумму внесения");

        double depositMoney = scanner.nextDouble();
        double balancePlus = depositMoney + bank.balance;

        System.out.println("Ваш баланс пополнен на " + depositMoney + ". На балансе сейчас " + balancePlus);
        workATM();

    }
    @Override
    public void cashWithdrawal() {
        System.out.println("Введите сумму для снятия");
        double withdrawalMoney = scanner.nextDouble();

        double balanceOut = bank.balance - withdrawalMoney;

        System.out.println("Вы сняли " + withdrawalMoney + ". На балансе сейчас " + balanceOut);
        workATM();

    }
    public class DataClient {
        public void enterCard() {

            System.out.println("Введите пин-код");

            String enterCode = scanner.nextLine();

            for (int x = 0; x < client.code.length; x++) {

                if (enterCode.equals(client.code[x])) {
                    workATM();
                    break;
                }
            }
            System.out.println("Неверный пин-код");
        }

        public void output() {
            bank.checkAvailableClient();
            enterCard();
            workATM();
        }
    }
}
