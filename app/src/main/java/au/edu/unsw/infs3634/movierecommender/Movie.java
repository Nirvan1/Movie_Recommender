package au.edu.unsw.infs3634.movierecommender;

import java.util.ArrayList;

public class Movie {
    public Movie(String id, String movie, String movieCode, String rating, Integer releaseDate, String genre, String description) {
        this.id = id;
        this.movie = movie;
        this.movieCode = movieCode;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.description = description;
    }

    private String id;
    private String movie;
    private String movieCode;
    private String rating;
    private Integer releaseDate;
    private String genre;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //implement the list of movies
    public static ArrayList<Movie> getMovies() {
        ArrayList<Movie> countries = new ArrayList<>();
        countries.add(new Movie("1", "Goodfellas", "GF", "Rating: 9/10", 1990, "Crime", "406001"));
        countries.add(new Movie("2", "Avengers: Infinity War", "AIN", "Rating: 8/10", 2018, "Action", "152869"));
        countries.add(new Movie("3", "American Psycho", "AP", "Rating: 7/10", 2000, "Thriller", "212831"));
        countries.add(new Movie("4", "Blade Runner", "BR", "Rating: 9/10", 1982, "Sci-Fi", "66214"));
        countries.add(new Movie("5", "The Truman Show", "TTS", "Rating: 8/10", 1998, "Drama", "93469"));
        countries.add(new Movie("6", "John Wick", "JW", "Rating: 7/10", 2014, "Action", "71792"));
        countries.add(new Movie("7", "The Dark Knight", "TDK", "Rating: 9/10", 2008, "Action", "83681"));
        countries.add(new Movie("8", "The Godfather", "TG", "Rating: 10/10", 1972, "Crime", "54637"));
        countries.add(new Movie("9", "12 Angry Men", "AM", "Rating: 8/10", 1957, "Drama", "24487"));
        countries.add(new Movie("10", "Fight Club", "FC", "Rating: 8/10", 1999, "Drama", "50010"));

        return countries;
    }

    public static Movie getMovie(String id) {
        ArrayList<Movie> movies = Movie.getMovies();
        for(final Movie movie : movies) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }
}
