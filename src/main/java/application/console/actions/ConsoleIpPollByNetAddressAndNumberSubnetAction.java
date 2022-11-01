package application.console.actions;

import java.util.List;
import java.util.function.Consumer;

import application.cdi.NetServiceInject;
import application.console.context.ConsoleMenuItemActionContext;
import application.net.NetService;

public class ConsoleIpPollByNetAddressAndNumberSubnetAction implements Consumer<ConsoleMenuItemActionContext> {

	private NetService netService = NetServiceInject.inject();
	
	@Override
	public void accept(ConsoleMenuItemActionContext context) {
		List<String> inputHistory = context.getInputHistory();
		
		String[] addressIp = inputHistory.get(inputHistory.size() - 2).split("/");
		Integer minNumberSubnet = Integer.parseInt(inputHistory.get(inputHistory.size() - 1));
		
		List<Long[]> pools = netService.listSubnetPools(addressIp[0], Integer.parseInt(addressIp[1]), minNumberSubnet);
		
		for (Long[] pool : pools) {
			System.out.println(String.format("%s - %s", 
				netService.parseBinaryIpToString(pool[0]), netService.parseBinaryIpToString(pool[1])
			));
		}
	}

}
