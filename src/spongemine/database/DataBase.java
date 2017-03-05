package spongemine.database;

import spongemine.Main;

public class DataBase extends BaseDB<Main>{
	public DataBase(Main plugin) {
		super(plugin);
		setPrefix("[광산]");
		
		initConfig();
	}
	
	private void initConfig() {
		saveDefaultConfig();
		
		if (getConfig().get("mine-height") == null) {
			getConfig().set("mine-height", 1);
			getConfig().set("mine-reset-milisec", 500);
			getConfig().save();
		}
	}
}
