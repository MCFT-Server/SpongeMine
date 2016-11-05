package spongemine.task;

import cn.nukkit.level.Position;
import cn.nukkit.scheduler.PluginTask;
import spongemine.Main;
import spongemine.manage.MineManager;

public class BlockPlaceTask extends PluginTask<Main> {

	Position pos;
	
	public BlockPlaceTask(Main owner, Position pos) {
		super(owner);
		this.pos = pos;
	}

	@Override
	public void onRun(int currentTick) {
		MineManager.getInstance().placeMine(pos);
	}

}
