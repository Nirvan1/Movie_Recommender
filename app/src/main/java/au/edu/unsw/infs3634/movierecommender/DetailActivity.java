package au.edu.unsw.infs3634.movierecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//AppCompatActivity lets us make use of newer android platform features
public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.movierecommender.intent_message";

    private TextView mMovieName;
    private TextView mRating;
    private TextView mReleaseDate;
    private TextView mGenre;
    private TextView mDescription;
    private Button mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //link to the activity_detail XML text views
        mMovieName = findViewById(R.id.tvMovieName);
        mRating = findViewById(R.id.tvRating);
        mReleaseDate = findViewById(R.id.tvReleaseDate);
        mGenre = findViewById(R.id.tvGenre);
        mDescription = findViewById(R.id.tvDescription);
        mSearch = findViewById(R.id.btSearch);

        Intent intent = getIntent();
        String id = intent.getStringExtra(INTENT_MESSAGE);

        Movie movie = Movie.getMovie(id);
        if(movie != null) {
            setTitle(movie.getMovieCode());
            mMovieName.setText(movie.getMovie());
            mRating.setText(String.valueOf(movie.getRating()));
            mReleaseDate.setText(String.valueOf(movie.getReleaseDate()));
            mGenre.setText(String.valueOf(movie.getGenre()));
            mDescription.setText(String.valueOf(movie.getDescription()));
            mSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchMovie(movie.getMovie());
                }
            });
        }
    }
//dictates that the app should search the movie on the internet when this button is clicked
    private void searchMovie(String movie) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/#q " + movie));
        startActivity(intent);
    }
}