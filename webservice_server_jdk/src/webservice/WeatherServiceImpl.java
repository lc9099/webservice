package webservice;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {

	@Override
	public String query(String cityName) {
		
		System.out.println("查询" + cityName);
		return "晴天";
	}

	@Override
	public String other() {
		
		return "庆祝ws发布成功！！！";
	}

}
