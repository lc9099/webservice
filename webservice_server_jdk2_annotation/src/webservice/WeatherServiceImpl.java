package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {

	@Override
	public @WebResult(name="weatherInfo") String query(@WebParam(name="citName") String cityName) {
		
		System.out.println("��ѯ" + cityName);
		return "����";
	}

	@Override
	public String other() {
		
		return "��ףws�����ɹ�������";
	}
	
	@WebMethod(exclude = true)
	public String noPublish() {
		
		return "no";
	}

		
}


