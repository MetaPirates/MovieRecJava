package com.org.example;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import Contracts.FirstRatingContract;
import Model.Movie;

@Component
public class FirstRating implements FirstRatingContract {

 //   public static void main(String[] args) throws IOException  {

//        HashMap<String,Rater> mvmap=loadraters();
//        List<Rater> r= mvmap.values().stream().collect(Collectors.toList());
//            for(Rater h : r){
//                System.out.println(h.itemsrated());
//            }

    //    HashMap<String,Movie> m=moviedata();//mid,movie
    //    m.values().stream().limit(1).forEach(n-> System.out.println(n.getImg()));
//        System.out.println(m.values().stream().limit(10).map(mo-> mo.getGenre()).toList());

  //  }
public static void main(String[] args) {
}

    public HashMap<String,Rater> loadraters() throws IOException {//raterid,rater
        HashMap<String,Rater> rhash = new HashMap<>();
        CSVParser parse = new CSVParser(new FileReader("ratings.csv"), CSVFormat.DEFAULT.withHeader());
        for (CSVRecord rec : parse) {
            String id=rec.get("rater_id");
            if(rhash.containsKey(id)){
                Rater r=rhash.get(id);
                r.putvalue(rec.get("movie_id"),Double.parseDouble(rec.get("rating")));
            }
            else {
            	
                rhash.put(id,new Rater(rec.get("movie_id"),Double.parseDouble(rec.get("rating"))));

            }

        }

        return rhash;

    }

    public  HashMap<String, Movie> moviedata() throws IOException {// mid, Movie obj
        HashMap<String, Movie> m = new HashMap<>();
        CSVParser parse = new CSVParser(new FileReader("ratedmoviesfull.csv"), CSVFormat.DEFAULT.withHeader());
        for (CSVRecord rec : parse) {
            String id = rec.get("id");//movieid
           
            if (!m.containsKey(id)) {
                List<String> g = Arrays.stream(rec.get("genre").split(",")).toList();
                String im=rec.get("poster");
                StringBuffer img=new StringBuffer(im);
             //  if(!(im.length()<5)) {
            	   String url=img.insert(4, "s").toString();
            	   
            	   m.put(id, new Movie(rec.get("title"), g,rec.get("year"),rec.get("country"),url));
              // }
           // else  m.put(id, new Movie(rec.get("title"), g,rec.get("year"),rec.get("country"),im));
                
                
               
            }

            
            
            
        }
      //  m.keySet().stream().limit(1).forEach(i->System.out.println("mid + " + i));
        return m;


    }
    
    
}