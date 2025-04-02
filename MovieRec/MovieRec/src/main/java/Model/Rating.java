package Model;

import org.springframework.stereotype.Component;

@Component
public class Rating {
	private String rating1;
	private String rating2;
	private String rating3;
	private String rating4;
	private String rating5;
	public String getRating1() {
		return rating1;
	}
	public void setRating1(String rating1) {
		this.rating1 = rating1;
	}
	public String getRating2() {
		return rating2;
	}
	public void setRating2(String rating2) {
		this.rating2 = rating2;
	}
	public String getRating3() {
		return rating3;
	}
	public void setRating3(String rating3) {
		this.rating3 = rating3;
	}
	public String getRating4() {
		return rating4;
	}
	public void setRating4(String rating4) {
		this.rating4 = rating4;
	}
	public String getRating5() {
		return rating5;
	}
	public void setRating5(String rating5) {
		this.rating5 = rating5;
	}
	@Override
	public String toString() {
		return "Rating [rating1=" + rating1 + ", rating2=" + rating2 + ", rating3=" + rating3 + ", rating4=" + rating4
				+ ", rating5=" + rating5 + "]";
	}
	
	
	}
	


