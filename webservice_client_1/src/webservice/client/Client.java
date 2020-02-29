package webservice.client;

import webservice.WeatherServiceImpl;
import webservice.WeatherServiceImplService;

public class Client {

	public static void main(String[] args) {
		
		// 1. 创建服务视图（从service标签的name属性获取）
		WeatherServiceImplService service = new WeatherServiceImplService();
		
		// 2. 获取服务的实现类（从portType的name属性获取）
		WeatherServiceImpl port = service.getPort(WeatherServiceImpl.class);
		
		// 3. 调用方法
		String query = port.query("陕西");
		System.out.println(query);
		
		// 调用新方法
		String other = port.other();
		System.out.println(other);
		
	}
}
