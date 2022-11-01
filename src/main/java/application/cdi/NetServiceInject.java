package application.cdi;

import application.net.NetService;

public class NetServiceInject {

	private static NetService netService = new NetService();
	
	public static NetService inject() {
		return netService;
	}
	
}
