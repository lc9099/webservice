package webservice.client;

import webservice.WeatherServiceImpl;
import webservice.WeatherServiceImplService;

public class Client {

	public static void main(String[] args) {
		
		// 1. ����������ͼ����service��ǩ��name���Ի�ȡ��
		WeatherServiceImplService service = new WeatherServiceImplService();
		
		// 2. ��ȡ�����ʵ���ࣨ��portType��name���Ի�ȡ��
		WeatherServiceImpl port = service.getPort(WeatherServiceImpl.class);
		
		// 3. ���÷���
		String query = port.query("����");
		System.out.println(query);
		
		// �����·���
		String other = port.other();
		System.out.println(other);
		
	}
}
