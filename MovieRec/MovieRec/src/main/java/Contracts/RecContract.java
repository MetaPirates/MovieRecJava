package Contracts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.org.example.Rater;

import Model.Movie;

@Component
public interface RecContract {

	public List<Movie> getrecGenre(String newid,HashMap<String,Rater> ratt,HashMap<String,Movie> mo,String G) throws IOException;
	public List<Movie> getrec(String newid,HashMap<String,Rater> ratt,HashMap<String,Movie> mo) throws IOException;
}
