import java.util.Scanner;

public class Bank {
    static int monthlyPayment = 100;                    // глобальні змінні класу для доступу у всіх методах класу
    static int number = 7;
    static int credit = number * monthlyPayment;
    static int debt = credit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            info();                                         // вивести на екран інформацію про кредит
            System.out.println("Введіть суму платежу");
            int amountOfPayment = scanner.nextInt();
            payment(amountOfPayment);                       // проведення оплати
            System.out.println("Зробити ще один платіж? y - так, n - ні");
            char symbol = scanner.next().charAt(0);
            if (symbol == 'n') {                            // можливість виходу з циклу оплати
                System.out.println("Вихід");
                break;
            }

        } while (Bank.debt > 0);
                                                            //за скільки платежів закритий кредит
        if (Bank.debt <= 0) {
            if (Bank.number == 6) System.out.println("Вітаємо, ви закрили кредит за " + (7 - Bank.number) + " платіж");
            else if (Bank.number >= 4)
                System.out.println("Вітаємо, ви закрили кредит за " + (7 - Bank.number) + " платежі");
            else System.out.println("Вітаємо, ви закрили кредит за " + (7 - Bank.number) + " платежів");
        }
    }

    static void info() {                                    // інформація про стан кредиту
        System.out.println("Інформація про кредит");
        System.out.println("___________________");
        System.out.println("Заборгованість по кредиту: " + Bank.debt + " грн");
        System.out.println("Мінімальний платіж: " + monthlyPayment + " грн");
        System.out.println("Залишилось платежів: " + Bank.number);
        System.out.println("___________________");
    }

    static void payment(int a) {                            // інформація про стан кредиту після проведення платежу
        debt(a);
        if (a < monthlyPayment) System.out.println("Платіж менше мінімального");
        else if (Bank.debt < 0) System.out.println("Переплата по кредиту становить " + Bank.debt + " грн");
        else if (Bank.debt == 0) System.out.println("Борг по кредиту відсутній");
        else System.out.println("Борг по кредиту становить " + Bank.debt + " грн");
    }

    static void debt(int a) {                                // нове значення боргу після проведення платежу
        Bank.debt = Bank.debt - a;
        Bank.number--;                                      // лічильник кількості платежів
    }

}
