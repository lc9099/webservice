package cn.com.webxml.client;

import java.util.List;

import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class Client {
	
	public static void main(String[] args) {
		
		WeatherWS service = new WeatherWS();
		WeatherWSSoap port = service.getPort(WeatherWSSoap.class);
		List<String> list = port.getWeather("Î÷°²", null).getString();
		
		for (String string : list) {
			System.out.println(string);
		}
		
	}

}
