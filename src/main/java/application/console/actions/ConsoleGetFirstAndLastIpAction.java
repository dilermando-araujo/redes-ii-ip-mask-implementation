package application.console.actions;

import java.util.function.Consumer;

import application.cdi.NetServiceInject;
import application.console.context.ConsoleMenuItemActionContext;
import application.net.NetService;

public class ConsoleGetFirstAndLastIpAction implements Consumer<ConsoleMenuItemActionContext> {
	
	private NetService netService = NetServiceInject.inject();
	
	@Override
	public void accept(ConsoleMenuItemActionContext context) {
		String ip = context.getLastInput();
		
		String[] ipParts = ip.split("/");
		
		long[] ips = netService.getFirstAndLastIp(ipParts[0], Integer.parseInt(ipParts[1]));
		
		System.out.println(String.format("%s - %s", netService.parseBinaryIpToString(ips[0]), netService.parseBinaryIpToString(ips[1])));
	}

}
