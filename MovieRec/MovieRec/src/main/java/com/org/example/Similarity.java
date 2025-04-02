package com.org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Model.Movie;

public class Similarity {



   public double getsim(String i, String t, HashMap<String, Rater> r) throws IOException {
        WeightedAverage a =new WeightedAverage();

        double iavg=a.getavg(i,r);
        
        double tavg=a.getavg(t,r);
      
        double dif=Math.abs(iavg-tavg); 
       
        return dif;
    }

    public List<Movie> getsimmov(List<String> simratlist,HashMap<String,Movie> m,HashMap<String,Rater> r){
        List<String> movies=new ArrayList<>();
        List<Movie> mobj=new ArrayList<Movie>();
        for(String i: simratlist){
           Rater rat= r.get(i);
           
           List<String> ratmlist = rat.itemsrated();//mids
          
           
           for (String mid : ratmlist){
        	   
               Movie mov=m.get(mid);
               if(mov!=null) {
               String mname= mov.getTitle();
               if(!movies.contains(mname)){
               movies.add(mname);
               mobj.add(mov);}
               }

           }
        }
      //  Collections.shuffle(mobj);
        return mobj;
    }


    public List<Movie> getsimmovfilByGenre(List<String> mlist,HashMap<String,Movie> m,HashMap<String,Rater> r,String gen){
        List<String> movies=new ArrayList<>();
        List<Movie> mobj=new ArrayList<Movie>();
        for(String i: mlist){
            Rater rat= r.get(i);
            List<String> ratmlist = rat.itemsrated();
            for (String mid : ratmlist){
                Movie mov=m.get(mid);
                String mname=mov.getTitle();
                if(!movies.contains(mname) && m.get(mid).getGenre().contains(gen)){
                    movies.add(mname);
                    mobj.add(mov);}

            }
        }
        return mobj;
    }


    public List<String> getsimmovfilByYear(List<String> mlist,HashMap<String,Movie> m,HashMap<String,Rater> r,String yr){
        List<String> movies=new ArrayList<>();
        for(String i: mlist){
            Rater rat= r.get(i);
            List<String> ratmlist = rat.itemsrated();
            for (String mid : ratmlist){
                String mname=m.get(mid).getTitle();
                if(!movies.contains(mname) && m.get(mid).getYear().equals(yr)){
                    movies.add(mname);}

            }
        }
        return movies;
    }

    public List<String> getsimmovfilByCountry(List<String> mlist,HashMap<String,Movie> m,HashMap<String,Rater> r,String con){
        List<String> movies=new ArrayList<>();
        for(String i: mlist){//list of similar movies id
            Rater rat= r.get(i);
            List<String> ratmlist = rat.itemsrated();// list of particular rater movie list
            for (String mid : ratmlist){
                String mname=m.get(mid).getTitle();
                if(!movies.contains(mname) && m.get(mid).getCountry().equals(con)){
                    movies.add(mname);}

            }
        }
        return movies;
    }

}
