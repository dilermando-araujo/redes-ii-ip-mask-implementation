package application.console.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import application.cdi.NetServiceInject;
import application.console.context.ConsoleMenuItemActionContext;
import application.net.NetAddress;
import application.net.NetService;

public class ConsoleChooseNetInListByIpAction implements Consumer<ConsoleMenuItemActionContext> {

	private NetService netService = NetServiceInject.inject();
	
	@Override
	public void accept(ConsoleMenuItemActionContext context) {
		List<String> inputHistory = context.getInputHistory();
		
		String[] addressesNetOriginal = inputHistory.get(inputHistory.size() - 2).split(",");
		String ip = inputHistory.get(inputHistory.size() - 1);
		
		List<NetAddress> addressesNet = new ArrayList<>(); 
		for (String addressNetOriginal : addressesNetOriginal) {
			String[] addressNet = addressNetOriginal.split("/");
			
			addressesNet.add(new NetAddress(addressNet[0], Integer.parseInt(addressNet[1])));
		}
		
		Optional<NetAddress> chosenAddressNetOpt = netService.getAddressNetInListByIp(addressesNet, ip);
		chosenAddressNetOpt.ifPresentOrElse(chosenAddressNet -> {
			System.out.println(ip + " -> " + chosenAddressNet.toString() + " : Encontrado.");
		}, () -> {
			System.out.println(ip + " -> ? : Não encontrado.");
		});
		
	}

}
