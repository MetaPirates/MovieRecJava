package Contracts;

import java.io.IOException;
import java.util.HashMap;

import com.org.example.Rater;
import org.springframework.stereotype.Repository;

import Model.Movie;
@Repository
public interface FirstRatingContract {
	public HashMap<String,Rater> loadraters() throws IOException;
	public HashMap<String,Movie> moviedata() throws IOException;
	

}
