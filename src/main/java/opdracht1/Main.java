package opdracht1;

import java.util.Scanner;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        // Hier wordt een nieuwe StringBuilder aangemaakt
        StringBuilder stringBuilder = new StringBuilder();

        // Dit is de scanner die het ingetypte jaartal bijhoudt
        Scanner sc = new Scanner(System.in);
        System.out.println("Type het jaartal in: ");
        String input = sc.nextLine();
        sc.close();

        // Vanaf hier komt de uitvoer van het programma
        System.out.println("\n" + "Dit is de uitvoer:");

        // Hier wordt de ingevoerde jaartal in de uitvoer gezet
        stringBuilder.append(input);
        String string = stringBuilder.toString();
        System.out.println(string);

        // Hierin wordt aan de hand van de maand aangegeven of het een maand is met 31 of 30 dagen
        // Daarnaast wordt de output van deze maanden in een methode aangemaakt
        makeMonth("Januari", false);
        makeMonth("Februari", true);
        makeMonth("Maart", false);
        makeMonth("April", true);
        makeMonth("Mei", false);
        makeMonth("Juni", true);
        makeMonth("Juli", false);
        makeMonth("Augustus", false);
        makeMonth("September", true);
        makeMonth("Oktober", false);
        makeMonth("November", true);
        makeMonth("December", false);

/*        System.out.println(stringBuilder.charAt(stringBuilder.length() - 1));


        LocalDate date = LocalDate.of(2018, Month.NOVEMBER, 22);
        System.out.println(date);

        LocalTime time = LocalTime.of(9, 44);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        System.out.println(LocalTime.now());

        LocalDateTime dateTimeNow = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(dateTimeNow);

        DateTimeFormatter test = DateTimeFormatter.ofPattern("dd-MMMM-YYYY");
        System.out.println(test.format(dateTime)); */
    }

    // Dit is de methode die ervoor zorgt dat de maanden met de juiste aantal dagen uitgeprint worden
    private static void makeMonth(String maand, boolean Evenmaand) {
        // Hier wordt een cijfer bijgehouden die ervoor zorgt dat de juiste aantal dagen geprint worden
        int cijfer;

        // Hier wordt een nieuwe StringBuilder aangemaakt
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(maand).append("\n");

        // Dit is een Array met alle dagen
        String[] day = {"Ma ", "Di ", "Wo ", "Do", "Vrij", "Za", "Zo"};

        // Elke dag moet toegevoegd worden aan de StringBuilder en moet er een spatie toegevoegd worden
        for (String days : day) {
            stringBuilder.append(days).append(" ");
        }

        stringBuilder.append("\n");

        // Hier worden de juiste aantal dagen uitgeprint voor een maand
        if (!Evenmaand) {
            cijfer = 32;
        } else {
            if (maand.equals("Februari")) {
                cijfer = 29;
            } else {
            cijfer = 31;
            }
        }

        // Print alle dagen van de maand uit
        for (int i = 1; i < cijfer; i++) {
            stringBuilder.append(i).append("\t");

            // Telkens als er een nieuwe week is dan moet er een nieuwe regel komen in de kalender
            if (i == 7 || i == 14 || i == 21 || i == 28){
                stringBuilder.append("\n");
            }
        }

        // Voeg een enter toe voor een nieuwe maand
        String string = stringBuilder.append("\n").toString();

        // Print de gehele maand met de juiste aantal dagen uit in de console
        System.out.println(string);
    }
}