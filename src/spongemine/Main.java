package spongemine;

import cn.nukkit.plugin.PluginBase;
import spongemine.database.DataBase;
import spongemine.listener.EventListener;

public class Main extends PluginBase {
	EventListener listener;
	DataBase db;
	
	@Override
	public void onEnable() {
		listener = new EventListener(this);
		db = new DataBase(this);
		
		getServer().getPluginManager().registerEvents(listener, this);
	}
}
