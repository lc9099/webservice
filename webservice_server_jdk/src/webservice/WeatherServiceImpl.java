package webservice;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {

	@Override
	public String query(String cityName) {
		
		System.out.println("��ѯ" + cityName);
		return "����";
	}

	@Override
	public String other() {
		
		return "��ףws�����ɹ�������";
	}

}
