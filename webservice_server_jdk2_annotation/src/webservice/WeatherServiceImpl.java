package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {

	@Override
	public @WebResult(name="weatherInfo") String query(@WebParam(name="citName") String cityName) {
		
		System.out.println("查询" + cityName);
		return "晴天";
	}

	@Override
	public String other() {
		
		return "庆祝ws发布成功！！！";
	}
	
	@WebMethod(exclude = true)
	public String noPublish() {
		
		return "no";
	}

		
}


