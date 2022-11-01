package application.console.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import application.console.context.ConsoleMenuItemActionContext;

public class ConsoleMenuItem {
	private String description;
	private Consumer<ConsoleMenuItemActionContext> action;
	private List<ConsoleMenuItem> submenus = new ArrayList<>();
	private boolean selectableChildren = false;
	
	public ConsoleMenuItem() {}
	
	public ConsoleMenuItem(String description, Consumer<ConsoleMenuItemActionContext> action) {
		this.description = description;
		this.action = action;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Consumer<ConsoleMenuItemActionContext> getAction() {
		return action;
	}

	public void addSubmenu(ConsoleMenuItem action) {
		this.submenus.add(action);
	}
	
	public void setAction(Consumer<ConsoleMenuItemActionContext> action) {
		this.action = action;
	}

	public List<ConsoleMenuItem> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<ConsoleMenuItem> submenus) {
		this.submenus = submenus;
	}

	public boolean isSelectableChildren() {
		if (this.submenus.size() == 0) return false;
		
		return selectableChildren;
	}

	public void setSelectableChildren(boolean selectableChildren) {
		this.selectableChildren = selectableChildren;
	}
	
	public boolean hasChildren() {
		return this.submenus.size() > 0;
	}
	
	public ConsoleMenuItem getFirstChild() {
		return this.submenus.get(0);
	}
	
}
