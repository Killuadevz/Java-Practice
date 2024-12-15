import java.util.Scanner;
import java.util.concurrent.*;

public class PrimeChecker {


    public static class PrimeTask implements Callable<String> {
        private final int number;

        public PrimeTask(int number) {
            this.number = number;
        }

        @Override
        public String call() {
            boolean isPrime = checkIfPrime(number);
            if (isPrime) {
                return number % 2 == 0 ? "par e primo" : "ímpar e primo";
            } else {
                return number % 2 == 0 ? "par e não primo" : "ímpar e não primo";
            }
        }

        private boolean checkIfPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int number = scanner.nextInt();


        ExecutorService executorService = Executors.newCachedThreadPool();


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                return executorService.submit(new PrimeTask(number)).get();
            } catch (Exception e) {
                e.printStackTrace();
                return "Erro na execução da thread.";
            }
        });

        String result = future.get();


        System.out.println(result);

        executorService.shutdown();
    }
}
