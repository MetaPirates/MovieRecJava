package com.org.example;







import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

public class Rest {
	
	public static void main(String[] args) {
	RestTemplate rest= new RestTemplate();
	String url="http://localhost:9090/test";
	UriTemplate ur = new UriTemplate("i");
	
	
	}

}
