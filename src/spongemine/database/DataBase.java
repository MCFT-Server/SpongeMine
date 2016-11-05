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
	}
}
