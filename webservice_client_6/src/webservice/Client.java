package webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		// ��ȡurl
		URL url = new URL("http://localhost:8000/weatherService");
		
		// ����һ�����Ӷ������������������������Ϣ�����ڻ�ȡ����������Ӧ��Ϣ
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		
		// ��ͨ��
		connection.setDoOutput(true);	
		connection.setDoInput(true);
		
		// ƴ�ӷ���Э��Ҫ������ݸ�ʽ
		String info = buildXml("����");
		// ����������Ϣ
		connection.getOutputStream().write(info.getBytes());
		
		// ��ȡ��Ӧ��Ϣ
		int responseCode = connection.getResponseCode();
		if(responseCode == 200) {
			// ��Ӧ��������ȡ���ص���Ϣ
			InputStream inputStream = connection.getInputStream();
			
			Scanner scanner = new Scanner(inputStream);
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			
		}else {
			System.out.println("��Ӧ�룺" + responseCode);
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
