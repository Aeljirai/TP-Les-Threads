
import java.util.*;
import java.util.concurrent.*;

// ======== Exercice 1 ========
// Classe Talkative
class Talkative implements Runnable {
    private final int value;

    public Talkative(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("[%s] %d%n", Thread.currentThread().getName(), value);
        }
    }
}

// Classe principale pour Exercice 1
class TalkativeDemo {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Talkative(i + 1), "T-" + (i + 1));
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nObservation : sorties entrelacées, ordre non déterministe.");
    }
}

// ======== Exercice 2 ========
// Classe Sommeur
class Sommeur implements Callable<Integer> {
    private int[] tableau;
    private int debut;
    private int fin;

    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public Integer call() {
        int somme = 0;
        for (int i = debut; i < fin; i++) {
            somme += tableau[i];
        }
        return somme;
    }
}

// Classe principale pour Exercice 2
class ParallelSum {
    public static void main(String[] args) throws Exception {
        int taille = 20000;
        int[] tableau = new int[taille];
        for (int i = 0; i < taille; i++) {
            tableau[i] = 1; // chaque élément = 1 pour un calcul facile
        }

        int nbThreads = 8;
        ExecutorService executorService = Executors.newFixedThreadPool(nbThreads);

        int plage = taille / nbThreads;
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nbThreads; i++) {
            int debut = i * plage;
            int fin = (i == nbThreads - 1) ? taille : (i + 1) * plage;
            results.add(executorService.submit(new Sommeur(tableau, debut, fin)));
        }

        int sommeTotale = 0;
        for (Future<Integer> f : results) {
            sommeTotale += f.get();
        }

        executorService.shutdown();
        System.out.println("Somme totale = " + sommeTotale);
    }
}
