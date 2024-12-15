package Monthly;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.*;

public class MonthlyCalendar {
    public static void main(String[] args) {
        var ano = 2024;
        var mes = Month.DECEMBER;
        var primeiroDia = LocalDate.of(ano, mes, 1);
        var diaSemana = primeiroDia.getDayOfWeek().getValue();
        var diasNoMes = primeiroDia.lengthOfMonth();
        var diasDaSemana = Stream.of("Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom").collect(Collectors.joining("  "));
        System.out.println("Calendário de " + primeiroDia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " de " + ano + ":");
        System.out.println(diasDaSemana);
        System.out.print("    ".repeat(diaSemana - 1));
        IntStream.rangeClosed(1, diasNoMes).forEach(dia -> {System.out.printf("%2d  ", dia); if ((dia + diaSemana - 1) % 7 == 0) System.out.println(); });
        System.out.println();
    }
}
