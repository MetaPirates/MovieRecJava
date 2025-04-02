package com.org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import Contracts.RecContract;
import Model.Movie;


@Component
public class Recommender implements RecContract{

    public List<Movie> getrec(String newid,HashMap<String,Rater> ratt,HashMap<String,Movie> mo) throws IOException {
        Similarity sim= new Similarity();
        FirstRating rating= new FirstRating();
        HashMap<String,Rater> r= ratt;
        HashMap<String,Movie> m= mo;

        List<String> simratlist=new ArrayList<>();//list of rid that are similar to given rater
        for (String i: r.keySet()) {
            if (!newid.equals(i)) {
                double d = sim.getsim(newid, i, r);
                if (d <= 1.5) {
                    simratlist.add(i);
                } 
            }
        }
       
        //obtain movielist from simratlist

        //rid -> Rater -> itemsrated -> keyset of mid -> Movie name
        List<Movie> mov=sim.getsimmov(simratlist,m,r).subList(0, 50);
        return mov;

    }
    
    
    public List<Movie> getrecGenre(String newid,HashMap<String,Rater> ratt,HashMap<String,Movie> mo,String G) throws IOException {
        Similarity sim= new Similarity();
        FirstRating rating= new FirstRating();
        HashMap<String,Rater> r= ratt;
        HashMap<String,Movie> m= mo;

        List<String> simratlist=new ArrayList<>();//list of rid that are similar to given rater
        for (String i: r.keySet()) {
            if (!newid.equals(i)) {
                double d = sim.getsim(newid, i, r);
                if (d <= 1.5) {
                    simratlist.add(i);
                } 
            }
        }
       
        //obtain movielist from simratlist

        //rid -> Rater -> itemsrated -> keyset of mid -> Movie name
        List<Movie> mov=sim.getsimmovfilByGenre(simratlist,m,r,G).subList(0, 50);
        return mov;

    }
    
   
    

}
