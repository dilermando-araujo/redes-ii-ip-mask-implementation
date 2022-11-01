package application.console;

import java.util.Scanner;

import application.console.context.ConsoleMenuItemActionContext;
import application.console.menu.ConsoleMenuItem;
import application.console.menu.ConsoleMenuLoad;

public class ConsoleRunner {
	
	public void run() {
		
		ConsoleMenuItem menuRoot = (new ConsoleMenuLoad()).load();
		ConsoleMenuItemActionContext context = new ConsoleMenuItemActionContext();
		
		ConsoleMenuItem currentMenu = menuRoot;
		Scanner inputScanner = new Scanner(System.in);
		
		while (true) {
			for (int i = 0; i < currentMenu.getSubmenus().size(); i++) {
				
				if (currentMenu.isSelectableChildren()) {					
					System.out.println(String.format("%s. %s.", i+1, currentMenu.getSubmenus().get(i).getDescription()));
				} else {
					System.out.println(String.format("%s:", currentMenu.getSubmenus().get(i).getDescription()));
				}
				
			}
			
			if (!currentMenu.hasChildren()) {
				currentMenu.getAction().accept(context);
				break;
			}
			
			System.out.print("> ");
			String inputText = inputScanner.nextLine();
			context.addInput(inputText);
			
			if (currentMenu.isSelectableChildren()) {
				currentMenu = currentMenu.getSubmenus().get(Integer.parseInt(inputText) - 1);
				continue;
			}
			
			currentMenu = currentMenu.getFirstChild();
		}
		
		inputScanner.close();
	}
	
}
