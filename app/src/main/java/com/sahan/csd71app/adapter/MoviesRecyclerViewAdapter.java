package com.sahan.csd71app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sahan.csd71app.R;
import com.sahan.csd71app.model.Movie;

import java.util.List;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewAdapter.MyViewHolder> {

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvYear;
        TextView tvLanguages;
        TextView tvGenres;
        TextView tvDuration;
        TextView tvOverallRating;
        TextView tvMoreDetails;
        ImageView imgMovieCover;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvMovieTitle);
            this.tvYear = itemView.findViewById(R.id.tvYear);
            this.tvLanguages = itemView.findViewById(R.id.tvLanguages);
            this.tvOverallRating = itemView.findViewById(R.id.tvOverallRating);
            this.tvGenres = itemView.findViewById(R.id.tvGenres);
            this.tvDuration = itemView.findViewById(R.id.tvDuration);
            this.tvMoreDetails = itemView.findViewById(R.id.tvMoreDetails);
            this.imgMovieCover = itemView.findViewById(R.id.imgMovieCover);
            this.ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }

    private Context context;
    private List<Movie> movieList;

    private static final String TAG = "ratingTag";

    public MoviesRecyclerViewAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.list_movie_row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        holder.tvTitle.setText(movie.getName());
        holder.tvYear.setText(String.valueOf(movie.getYear()));
        holder.tvLanguages.setText(movie.getLanguage());
        holder.tvGenres.setText(movie.getGenre());
        holder.tvDuration.setText(movie.getDuration());
        holder.tvOverallRating.setText("0.0");
        Glide
                .with(context)
                .load(movie.getCoverURL())
                .into(holder.imgMovieCover);
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.i(TAG, movie.getName()+ " Rating - "+v);
                //2
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
