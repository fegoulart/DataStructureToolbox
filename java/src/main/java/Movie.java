import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Movie {

    String poster;
    String title;
    String type;
    int year;
    String imdbID;

    Movie(String poster, String title, String type, int year, String imdbID) {
        this.poster = poster;
        this.title = title;
        this.type = type;
        this.imdbID = imdbID;
        this.year = year;
    }

    Movie() {
        this.poster = "";
        this.title = "";
        this.type = "";
        this.imdbID = "";
        this.year = 0;
    }

}

final class MovieMapper {

    /***
     * ParseMovie method: transform a JsonObject to a Movie instance
     *
     *
     * @param movie JsonObject received from Rest Call
     * @return Movie instance
     */
    static Movie parseMovie(JsonObject movie) {
        Movie film = new Movie();

        try {
            film.poster = movie.get("Poster").getAsString();
        } catch (Exception e) {
            film.poster = "";
        }
        try {
            film.title = movie.get("Title").getAsString();
        } catch (Exception e) {
            film.title = "";
        }
        try {
            film.type = movie.get("Type").getAsString();
        } catch (Exception e) {
            film.type = "";
        }
        try {
            film.imdbID = movie.get("imdbID").getAsString();
        } catch (Exception e) {
            film.imdbID = "";
        }
        try {
            film.year = movie.get("Year").getAsInt();
        } catch (Exception e) {
            film.year = 0;
        }

        return film;
    }
}


final class MovieAPI {

    /***
     * restMovieCall makes a REST get call to example API
     *
     * @param substr  name to be searched (eg: spiderman)
     * @param page send 1 for first call
     * @return API content
     */
    static StringBuffer restMovieCall(String substr, int page) {
        String BASEURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
        String urlString = BASEURL + substr;
        if (page > 1) {
            urlString = urlString + "&page=" + page;
        }
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            con.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        try {
            int status = con.getResponseCode();
            System.out.println(status);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputLine;
        StringBuffer content = new StringBuffer();
        try {
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;

    }

    /***
     * getMovies retrieves all movies from API and return a String array with the titles
     *
     *
     * @param substr Title of the movie being search
     * @return String array with titles
     */
    static List<Movie> getMovies(String substr) {

        List<Movie> myMovies = new ArrayList<>();

        JsonObject o;
        JsonArray myData;
        int totalPages = 2;
        int total = 1;
        int page = 1;

        while (page <= totalPages) {
            o = JsonParser.parseString(String.valueOf(restMovieCall(substr, page))).getAsJsonObject();

            page = o.get("page").getAsInt();
            totalPages = o.get("total_pages").getAsInt();
            myData = o.getAsJsonArray("data");
            for (int i = 0; i < myData.size(); i++) {
                Movie newMovie;
                newMovie = MovieMapper.parseMovie(myData.get(i).getAsJsonObject());
                myMovies.add(newMovie);
            }
            page++;

        }

        return myMovies;

    }

    static String[] getMovieTitles(String substr) {


        List<Movie> myMovies = new ArrayList<>();
        myMovies = getMovies(substr);
        String[] titles = new String[myMovies.size()];

        int aux = 0;
        for (Movie movie : myMovies) {
            titles[aux] = movie.title;

            aux = aux + 1;
        }
        Arrays.sort(titles);
        return titles;
    }
}
