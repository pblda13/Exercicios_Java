package Avancado;

import java.util.*;

//Exercício 9: Escreva um programa em Java que implemente um sistema de recomendação de filmes. O programa deve receber informações
// sobre os usuários e suas preferências de filmes e, com base nesses dados, recomendar filmes semelhantes aos usuários.
public class Exercicio_9 {
    private Map<String, Map<String, Double>> ratings;

    public Exercicio_9() {
        this.ratings = new HashMap<>();
    }

    public void addRating(String user, String movie, double rating) {
        ratings.computeIfAbsent(user, k -> new HashMap<>()).put(movie, rating);
    }

    public List<String> recommendMovies(String user) {
        Map<String, Double> userRatings = ratings.get(user);

        Map<String, Double> movieScores = new HashMap<>();

        // Calcular a similaridade entre o usuário atual e todos os outros usuários
        for (String otherUser : ratings.keySet()) {
            if (!otherUser.equals(user)) {
                Map<String, Double> otherUserRatings = ratings.get(otherUser);
                double similarity = calculateSimilarity(userRatings, otherUserRatings);

                // Calcular a pontuação dos filmes baseada na similaridade ponderada pelos ratings dos outros usuários
                for (String movie : otherUserRatings.keySet()) {
                    if (!userRatings.containsKey(movie)) {
                        double score = otherUserRatings.get(movie) * similarity;
                        movieScores.merge(movie, score, Double::sum);
                    }
                }
            }
        }

        // Ordenar os filmes pela pontuação em ordem decrescente
        List<String> recommendedMovies = new ArrayList<>(movieScores.keySet());
        recommendedMovies.sort((m1, m2) -> Double.compare(movieScores.get(m2), movieScores.get(m1)));

        return recommendedMovies;
    }

    private double calculateSimilarity(Map<String, Double> user1Ratings, Map<String, Double> user2Ratings) {
        // Calcular a média das avaliações de cada usuário
        double user1Mean = calculateMean(user1Ratings);
        double user2Mean = calculateMean(user2Ratings);

        // Calcular o numerador e o denominador do coeficiente de correlação de Pearson
        double numerator = 0.0;
        double denominatorUser1 = 0.0;
        double denominatorUser2 = 0.0;

        for (String movie : user1Ratings.keySet()) {
            if (user2Ratings.containsKey(movie)) {
                double ratingUser1 = user1Ratings.get(movie);
                double ratingUser2 = user2Ratings.get(movie);

                numerator += (ratingUser1 - user1Mean) * (ratingUser2 - user2Mean);
                denominatorUser1 += Math.pow(ratingUser1 - user1Mean, 2);
                denominatorUser2 += Math.pow(ratingUser2 - user2Mean, 2);
            }
        }

        // Calcular o coeficiente de correlação de Pearson
        double similarity = numerator / (Math.sqrt(denominatorUser1) * Math.sqrt(denominatorUser2));

        return similarity;
    }

    private double calculateMean(Map<String, Double> ratings) {
        double sum = 0.0;
        for (double rating : ratings.values()) {
            sum += rating;
        }
        return sum / ratings.size();
    }


    public static void main(String[] args) {
        Exercicio_9 recommender = new Exercicio_9();

        // Adicionar ratings de exemplo
        recommender.addRating("User1", "Movie1", 4.0);
        recommender.addRating("User1", "Movie2", 3.5);
        recommender.addRating("User1", "Movie3", 2.0);
        recommender.addRating("User2", "Movie1", 3.0);
        recommender.addRating("User2", "Movie2", 4.5);
        recommender.addRating("User2", "Movie3", 5.0);
        recommender.addRating("User3", "Movie1", 5.0);
        recommender.addRating("User3", "Movie2", 2.5);

        // Recomendar filmes para um usuário
        List<String> recommendedMovies = recommender.recommendMovies("User1");

        // Exibir os filmes recomendados
        System.out.println("Filmes recomendados para User1:");
        for (String movie : recommendedMovies) {
            System.out.println(movie);
        }
    }
}
