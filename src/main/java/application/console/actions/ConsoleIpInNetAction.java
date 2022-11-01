package application.console.actions;

import java.util.List;
import java.util.function.Consumer;

import application.cdi.NetServiceInject;
import application.console.context.ConsoleMenuItemActionContext;
import application.net.NetService;

public class ConsoleIpInNetAction implements Consumer<ConsoleMenuItemActionContext> {

	private NetService netService = NetServiceInject.inject();
	
	@Override
	public void accept(ConsoleMenuItemActionContext context) {
		List<String> inputHistory = context.getInputHistory();
		
		String ip = inputHistory.get(inputHistory.size() - 1);
		
		String addressNetOriginal = inputHistory.get(inputHistory.size() - 2);
		String[] addressNetSplit = addressNetOriginal.split("/");
				
		boolean in = netService.checkIpInNet(ip, addressNetSplit[0], Integer.parseInt(addressNetSplit[1]));
		
		System.out.println(String.format("%s -> %s : %s.", 
							ip, addressNetOriginal, in ? "Pertence" : "Não pertence"
		));
	}

}
