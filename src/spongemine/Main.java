package spongemine;

import cn.nukkit.plugin.PluginBase;
import spongemine.database.DataBase;
import spongemine.listener.EventListener;
import spongemine.manage.MineManager;

public class Main extends PluginBase {
	EventListener listener;
	DataBase db;
	private MineManager manager;
	
	@Override
	public void onEnable() {
		listener = new EventListener(this);
		db = new DataBase(this);
		manager = new MineManager(this);
		
		getServer().getPluginManager().registerEvents(listener, this);
	}
	
	public DataBase getDB() {
		return db;
	}
	
	public MineManager getManager() {
		return manager;
	}
}
