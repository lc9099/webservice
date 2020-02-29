package webservice.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import webservice.WeatherServiceImpl;

public class Client {

	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:8000/weatherService?wsdl");
		QName qName = new QName("http://webservice/", "WeatherServiceImplService");
		Service service = Service.create(url, qName);
		
		WeatherServiceImpl port = service.getPort(WeatherServiceImpl.class);
		
		String query = port.query("±±¾©");
		System.out.println(query);
	}
}
