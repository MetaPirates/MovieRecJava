package com.org.example;

import java.io.IOException;
import java.util.HashMap;



public class WeightedAverage {
    public static void main(String[] args) throws IOException {
        HashMap<String,Double> avgdata=new HashMap<>();

        FirstRating fr= new FirstRating();
        HashMap<String,Rater> hash=fr.loadraters();
        for(String i : hash.keySet()){
            avgdata.put(i,getavg(i,hash));
            System.out.println(avgdata.get(i));
        }


 




    }


    public static double getavg(String rid,HashMap<String,Rater> hash) throws IOException {

        Rater r=hash.get(rid);//4,5,6,7
        //-5 to 5 normalize
       return ( (r.getratingsset().stream().mapToDouble(i->i-5).sum())/r.hashsize());
    }
}
