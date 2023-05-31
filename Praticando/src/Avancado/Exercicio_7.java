package Avancado;

import java.util.ArrayList;
import java.util.List;

//Exercício 7: Escreva um programa em Java que utilize threads para realizar o cálculo de números primos em paralelo. O programa deve receber um intervalo de números e distribuir o
// trabalho entre várias threads para otimizar o processamento.
class PrimeChecker extends Thread {
    private int start;
    private int end;
    private List<Integer> primes;

    public PrimeChecker(int start, int end) {
        this.start = start;
        this.end = end;
        this.primes = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}

public class Exercicio_7 {
    public static void main(String[] args) throws InterruptedException {
        int startNumber = 1;
        int endNumber = 100;
        int numberOfThreads = 4;

        int numbersPerThread = (endNumber - startNumber + 1) / numberOfThreads;
        int remainingNumbers = (endNumber - startNumber + 1) % numberOfThreads;

        List<PrimeChecker> primeCheckers = new ArrayList<>();

        int currentStart = startNumber;
        int currentEnd = startNumber + numbersPerThread - 1;

        for (int i = 0; i < numberOfThreads; i++) {
            if (i < remainingNumbers) {
                currentEnd++;
            }

            PrimeChecker primeChecker = new PrimeChecker(currentStart, currentEnd);
            primeCheckers.add(primeChecker);
            primeChecker.start();

            currentStart = currentEnd + 1;
            currentEnd = currentStart + numbersPerThread - 1;
        }

        for (PrimeChecker primeChecker : primeCheckers) {
            primeChecker.join();
        }

        List<Integer> allPrimes = new ArrayList<>();

        for (PrimeChecker primeChecker : primeCheckers) {
            allPrimes.addAll(primeChecker.getPrimes());
        }

        System.out.println("Números primos encontrados:");
        for (int prime : allPrimes) {
            System.out.println(prime);
        }
    }
}
