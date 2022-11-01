package application.console.context;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMenuItemActionContext {

	private List<String> inputHistory = new ArrayList<>();
	
	public void addInput(String input) {
		inputHistory.add(input);
	}
	
	public String getLastInput() {
		return inputHistory.get(inputHistory.size() - 1);
	}
	
	public List<String> getInputHistory() {
		return inputHistory;
	}
	
}
