package com.company;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2020 , 1 , 1);
        Locale polish = new Locale("pl", "PL");
        int choice;

        do
        {
            PrintMenuOptions(localDate, polish);

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    Company c = new Company();
                    System.out.println("Stan konta Twojej firmy: " + c.getBudget());
                    break;
                case 4:
                    break;
                case 5:
                    localDate = localDate.plusDays(1);
                    break;
                case 6:
                    localDate = localDate.plusDays(1);
                    break;
                case 7:
                    localDate = localDate.plusDays(1);
                    break;
                case 8:
                    localDate = localDate.plusDays(1);
                    break;
                case 9:
                    localDate = localDate.plusDays(1);
                    break;
                case 10:
                    localDate = localDate.plusDays(1);
                    break;
                case 11:
                    localDate = localDate.plusDays(1);
                    break;
                case 12:
                    localDate = localDate.plusDays(1);
                    break;
                case 13:
                    System.out.println("Szkoda, że już kończysz grę. Mam nadzieję, że zobaczymy się niedługo ponownie.");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór opcji. Spróbuj jeszcze raz.");
            }
        } while (choice != 13);

    }

    private static void PrintMenuOptions(LocalDate localDate, Locale polish) {
        System.out.println("\nDzisiejsza data: " + localDate);
        System.out.println("Dzień tygodnia: " + localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        System.out.println("-------------------------\n");
        System.out.println("Wybierz opcję wpisując odpowiednią cyfrę:\n");
        System.out.println("1 - Przejrzyj dostępne projekty");
        System.out.println("2 - Przejrzyj dostępnych pracowników");
        System.out.println("3 - Sprawdź stan konta");
        System.out.println("4 - Sprawdź stan realizacji poszczególnych projektów");
        System.out.println("5 - Podpisz umowę na realizację nowego projektu");
        System.out.println("6 - Szukaj klientów");
        System.out.println("7 - Programuj");
        System.out.println("8 - Testuj");
        System.out.println("9 - Oddaj gotowy projekt klientowi");
        System.out.println("10 - Zatrudnij nowego pracownika");
        System.out.println("11 - Zwolnij pracownika");
        System.out.println("12 - Rozlicz się z urzędami");
        System.out.println("13 - Wyjście\n");
    }
}
