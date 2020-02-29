package webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		// 获取url
		URL url = new URL("http://localhost:8000/weatherService");
		
		// 创建一个连接对象，用于向服务器发送请求消息，用于获取服务器的响应消息
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		
		// 打开通信
		connection.setDoOutput(true);	
		connection.setDoInput(true);
		
		// 拼接符合协议要求的数据格式
		String info = buildXml("西安");
		// 发送请求信息
		connection.getOutputStream().write(info.getBytes());
		
		// 获取相应信息
		int responseCode = connection.getResponseCode();
		if(responseCode == 200) {
			// 响应正常，获取返回的信息
			InputStream inputStream = connection.getInputStream();
			
			Scanner scanner = new Scanner(inputStream);
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			
		}else {
			System.out.println("响应码：" + responseCode);
		}
		
	}
	
	
	public static String buildXml(String cityName) {
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("<?xml version=\"1.0\" ?>");
		sBuilder.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sBuilder.append("<S:Body>");
		sBuilder.append("<ns2:query xmlns:ns2=\"http://webservice/\">");
		sBuilder.append("<arg0>");
		sBuilder.append(cityName);
		sBuilder.append("</arg0>");
		sBuilder.append("</ns2:query>");
		sBuilder.append("</S:Body>");
		sBuilder.append("</S:Envelope>");
	
		return sBuilder.toString();
		
	}

}
