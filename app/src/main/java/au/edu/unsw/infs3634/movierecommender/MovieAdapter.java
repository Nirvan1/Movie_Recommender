package au.edu.unsw.infs3634.movierecommender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//implement recycler view to dynamically display movies
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements Filterable {
    private ArrayList<Movie> mMovies;
    private ArrayList<Movie> mMoviesFiltered;
    private RecyclerViewClickListener mListener;

    public MovieAdapter(ArrayList<Movie> movies, RecyclerViewClickListener listener) {
        mMovies = movies;
        mMoviesFiltered = movies;
        mListener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    mMoviesFiltered = mMovies;
                } else {
                    ArrayList<Movie> filteredList = new ArrayList<>();
                    for(Movie movie : mMovies) {
                        if(movie.getMovie().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(movie);
                        }
                    }
                    mMoviesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mMoviesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mMoviesFiltered = (ArrayList<Movie>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String id);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new MovieViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = mMoviesFiltered.get(position);
        holder.country.setText(movie.getMovie());
        holder.totalCases.setText(String.valueOf(movie.getReleaseDate()));
        holder.newCases.setText(String.valueOf(movie.getRating()));
        holder.itemView.setTag(movie.getId());
    }

    @Override
    public int getItemCount() {
        return mMoviesFiltered.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView country, totalCases, newCases;
        private RecyclerViewClickListener listener;

        public MovieViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            country = itemView.findViewById(R.id.tvMovieName);
            totalCases = itemView.findViewById(R.id.tvReleaseDate);
            newCases = itemView.findViewById(R.id.tvRating);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }

    }


}
