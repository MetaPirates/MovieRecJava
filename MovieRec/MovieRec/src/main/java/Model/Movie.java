package Model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Movie {

    private String title;
    private List<String> genre;
    private  String year;
    private String img;
    private String country;
    @Override
    public String toString() {
        return
                title + '\'' +
                "," + genre +
                "," + year + '\'' +
                "," + country + '\'';
    }

    

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Movie(String t, List<String> g, String y, String c,String im){
        this.title=t;
        this.genre= g;
        this.year=y;
        this.country=c;
        this.img=im;

    }
    public Movie() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
    
}
