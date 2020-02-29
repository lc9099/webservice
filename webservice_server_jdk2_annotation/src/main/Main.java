package main;

import javax.xml.ws.Endpoint;

import webservice.WeatherServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8080/weatherService", new WeatherServiceImpl());
		System.out.println("发布成功");
	}
}
