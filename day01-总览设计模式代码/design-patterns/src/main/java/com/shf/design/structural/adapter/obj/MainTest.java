package com.shf.design.structural.adapter.obj;


import com.shf.design.structural.adapter.MoviePlayer;

public class MainTest {
    public static void main(String[] args) {
        MoviePlayer moviePlayer = new MoviePlayer();
        JPMoviePlayerAdapter adapter = new JPMoviePlayerAdapter(moviePlayer);
        adapter.play();
    }
}
