package application.console.menu;

import application.console.actions.ConsoleChooseNetInListByIpAction;
import application.console.actions.ConsoleGetFirstAndLastIpAction;
import application.console.actions.ConsoleIpInNetAction;
import application.console.actions.ConsoleIpPollByNetAddressAndNumberSubnetAction;

public class ConsoleMenuLoad {

	public ConsoleMenuItem load() {
		ConsoleMenuItem root = new ConsoleMenuItem();
		
		ConsoleMenuItem showFirstAndLastIpMenuItem = new ConsoleMenuItem("Exibir primeiro e último IP de uma rede", null);
		ConsoleMenuItem showFirstAndLastIpAction = new ConsoleMenuItem("Informe o endereço de rede", new ConsoleGetFirstAndLastIpAction());
		
		showFirstAndLastIpMenuItem.addSubmenu(showFirstAndLastIpAction);
		
		ConsoleMenuItem showIpPollByNetAddressAndNumberSubnet = new ConsoleMenuItem("Exibir as faixas de IP para uma quantidade N de subredes em um endereço", null);
		ConsoleMenuItem showIpPollByNetAddressAndNumberSubnetFirstAction = new ConsoleMenuItem("Informe o endereço de rede", null);
		ConsoleMenuItem showIpPollByNetAddressAndNumberSubnetSecondAction = new ConsoleMenuItem("Informe o número mínimo de subredes", new ConsoleIpPollByNetAddressAndNumberSubnetAction());
		
		showIpPollByNetAddressAndNumberSubnet.addSubmenu(showIpPollByNetAddressAndNumberSubnetFirstAction);
		showIpPollByNetAddressAndNumberSubnetFirstAction.addSubmenu(showIpPollByNetAddressAndNumberSubnetSecondAction);
		
		ConsoleMenuItem showIfIpInNet = new ConsoleMenuItem("Checar se um IP pertence a uma rede", null);
		ConsoleMenuItem showIfIpInNetFirstAction = new ConsoleMenuItem("Informe a rede", null);
		ConsoleMenuItem showIfIpInNetSecondAction = new ConsoleMenuItem("Informe o IP", new ConsoleIpInNetAction());
		
		showIfIpInNet.addSubmenu(showIfIpInNetFirstAction);
		showIfIpInNetFirstAction.addSubmenu(showIfIpInNetSecondAction);
		
		ConsoleMenuItem showChooseNetInListByIp = new ConsoleMenuItem("Escolher a rede, dado uma lista, que um IP pertence", null);
		ConsoleMenuItem showChooseNetInListByIpFirstAction = new ConsoleMenuItem("Informe a lista de redes, separado por vírgula (,)", null);
		ConsoleMenuItem showChooseNetInListByIpSecondAction = new ConsoleMenuItem("Informa o IP", new ConsoleChooseNetInListByIpAction());
		
		showChooseNetInListByIp.addSubmenu(showChooseNetInListByIpFirstAction);
		showChooseNetInListByIpFirstAction.addSubmenu(showChooseNetInListByIpSecondAction);
		
		root.addSubmenu(showFirstAndLastIpMenuItem);
		root.addSubmenu(showIpPollByNetAddressAndNumberSubnet);
		root.addSubmenu(showIfIpInNet);
		root.addSubmenu(showChooseNetInListByIp);
		
		root.setSelectableChildren(true);
		
		return root;
	}
	
}
