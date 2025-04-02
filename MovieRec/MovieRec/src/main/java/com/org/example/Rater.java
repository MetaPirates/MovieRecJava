package com.org.example;



import java.util.HashMap; 
import java.util.List;

public class Rater {

    private HashMap<String,Double> raterhash = new HashMap<>();//mid ,rating {list of movies rated by a rater}

    public Rater(String mid,Double rating){

        this.raterhash.put(mid,rating);
    }
    public Rater(){}

    public void putvalue(String mid,Double rating) {
        this.raterhash.put(mid,rating);

    }


    public List<String> itemsrated(){
        List<String> mids= raterhash.keySet().stream().toList();
    	return mids;// list of movieid's

    }

    public List<Double> getratingsset(){
        return raterhash.values().stream().toList();
    }

    public int hashsize(){
        return raterhash.size();
    }

    public void setRaterhash(HashMap<String, Double> raterhash) {
        this.raterhash = raterhash;
    }
}
