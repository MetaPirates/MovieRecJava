package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.org.example.Rater;
import org.springframework.stereotype.Component;
@Component
public class Combined {
	public Rating r;
	public HashMap<String,Rater> rat;
	public HashMap<String,Movie> mov;
	public ArrayList<String> movlist;//list of mid
	public List<Movie> movobjlist;
	public List<Movie> getMovobjlist() {
		return movobjlist;
	}
	public void setMovobjlist(ArrayList<Movie> movobjlist) {
		this.movobjlist = movobjlist;
	}
	public Rating getR() {
		return r;
	}
	public void setR(Rating r) {
		this.r = r;
	}
	public HashMap<String, Rater> getRat() {
		return rat;
	}
	public void setRat(HashMap<String, Rater> rat) {
		this.rat = rat;
	}
	public HashMap<String, Movie> getMov() {
		return mov;
	}
	public void setMov(HashMap<String, Movie> mov) {
		this.mov = mov;
	}
	public ArrayList<String> getMovlist() {
		return movlist;
	}
	public void setMovlist(ArrayList<String> movlist) {
		this.movlist = movlist;
	}

}
