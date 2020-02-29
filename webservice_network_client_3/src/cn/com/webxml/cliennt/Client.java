package cn.com.webxml.cliennt;

import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;

public class Client {

	public static void main(String[] args) {
		
		MobileCodeWS service = new MobileCodeWS();
		MobileCodeWSSoap port = service.getPort(MobileCodeWSSoap.class);
		String info = port.getMobileCodeInfo("18991397976", null);
		System.out.println(info);
	}
}
