package com.MovieRec.MovieRec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.org.example.Rater;
import com.org.example.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import Contracts.FirstRatingContract;
import Contracts.RecContract;
import Model.Combined;
import Model.Movie;
import Model.Rating;
import jakarta.servlet.http.HttpSession;


@Controller
public class ControllerClass {
		 
	ControllerClass(){}
	
		@Autowired
		private FirstRatingContract fr;
		
		@Autowired
		private RecContract reccontract;
		
		public HashMap<String,Double> newraterhash = new HashMap<String, Double>();
		private Rating rt;
		private RestTemplate rest;
		
		
		
		@GetMapping(path="/")
		public String home() {
			return "recommend";
		}
		
		
		
		@GetMapping("/recommend")
		public String d(Model model,HttpSession session) throws IOException {
			
			HashMap<String,Rater> g=fr.loadraters();//string,rater
			HashMap<String, Movie> f=fr.moviedata();//string,movie
			//NewUser nu= new NewUser();
			//Recommender r= new Recommender();
			//List<Movie> mm=r.getrec(id, g, f);
			Combined c= new Combined();
			var list=InitializeRaterController(c,f,g,model);
			
			//System.out.println(c.getMovlist().getFirst());
			model.addAttribute("movv",list);
			session.setAttribute("movv", list);
			model.addAttribute("c",c);
			return "recommended";
		}
		
		
		@PostMapping("/rate")
		public String g(Model mm,@RequestParam("rating0") String r1,@RequestParam("rating1") String r2,@RequestParam("rating2") String r3,@RequestParam("rating3") String r4,@RequestParam("rating4") String r5,HttpSession s) throws IOException {
			List<String> list = (List<String>)s.getAttribute("movv");
		System.out.println(list);
			var raters=fr.loadraters();
			newraterhash.put(list.get(0),Double.parseDouble(r1));
			newraterhash.put(list.get(1),Double.parseDouble(r2));
			newraterhash.put(list.get(2),Double.parseDouble(r3));
			newraterhash.put(list.get(3),Double.parseDouble(r4));
			newraterhash.put(list.get(4),Double.parseDouble(r5));
			String newRaterId=getNewRaterID(raters);
			addNewRater(raters,newraterhash,newRaterId);
			
		      var rec=  reccontract.getrec(newRaterId,raters,fr.moviedata());
		        mm.addAttribute("recmov",rec);
		      
		        	return "rec";
		 
		}
		
		
		@PostMapping("/default")
		
		
		
		

		
		
	
		
		
		
		
		public List<String> InitializeRaterController(Combined c,HashMap<String,Movie> movies,HashMap<String,Rater> raters,Model m) {
	    	//FirstRating fr= new FirstRating();
	        // HashMap<String,Movie> movies=fr.moviedata();
	    //     movies.keySet().stream().limit(1).forEach(System.out::println);
	      //   HashMap<String,Rater> raters= fr.loadraters();
	         ArrayList<String> rlist=new ArrayList<String>(movies.keySet().stream().collect(Collectors.toList()));// mids
	      //   System.out.println(mlist.subList(0,5));
	         //List<String> rlist= new ArrayList<>();
	       //  for (int i = 4; i < 100; i++) {
	       //      rlist.add(mlist.get(i));//mids
	       //  }
	       //  Scanner in= new Scanner(System.in);
	    //     HashMap<String,Double> newratermovielist= new HashMap<>();// new raterhash(list of mid with ratings) for new rater
	       
	        Collections.shuffle(rlist);
	        List<Movie> movlist=new ArrayList<Movie>();
	       //  System.out.println("-------------Rate 5 movies out of 10---------------");
	        for (int i = 0; i < 5; i++) {
	        	movlist.add(movies.get(rlist.get(i)));//adding movie obj
	        	
	        	
	        //    System.out.println(movies.get(rlist.get(i)).toString());
	         //   System.out.println("Rate out of 10 = ");
	        //    double rating=in.nextDouble();
	        	
	         //    newratermovielist.put(rlist.get(i),rating);

	         }
	      
	        
	      
	        c.movobjlist=movlist;//Movie Obj list
	      c.movlist=rlist;// list of movi ids
	      m.addAttribute("movobjlist",movlist);
	       var l=rlist.subList(0,5);
	      return l;
	    //     String newRaterId=getNewRaterID(raters);
	   //      addNewRater(raters,newratermovielist,newRaterId);
	         

	      //  Recommender recommender= new Recommender();
	      //   recommender.getrec(newRaterId,raters,movies);
	     //    return newRaterId;
	     	
	     }
	     
	    
		public static  String getNewRaterID( HashMap<String,Rater> raters) {
	    	int raterid= raters.keySet().size();
	    	String newRaterId=raterid+1+"";
	    	return newRaterId;
	    }
	    
	    public static void addNewRater(HashMap<String,Rater> raters,HashMap<String,Double> newraterhash,String newRaterId) {
	    	Rater r= new Rater();
	    	r.setRaterhash(newraterhash);
	    	raters.put(newRaterId,r);
	    	
	    }
		
		
		
	
	
	
	
}
