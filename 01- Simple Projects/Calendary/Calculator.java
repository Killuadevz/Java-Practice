import java.time.LocalDate;

public class Main {

    public static void main(String[] args)
    {
        LocalDate today = LocalDate.now();

        LocalDate christmas = LocalDate.of(2024, 12, 25);

        System.out.println("Hoje: " + today);
        System.out.println("Natal: " + christmas);
    }
}
