package spongemine.listener;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;
import spongemine.Main;
import spongemine.manage.MineManager;
import spongemine.task.BlockPlaceTask;

public class EventListener extends BaseListener<Main> {

	public EventListener(Main plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		if (block.getLevel().getBlock(new Vector3(block.x, block.y - 1, block.z)).getId() != Block.SPONGE) {
			return;
		}
		if (MineManager.getInstance().isDirectOre()) {
			player.getInventory().addItem(MineManager.getInstance().getMineralByOre(block.getId()));
		} else {
			player.getInventory().addItem(event.getDrops());
		}
		event.setDrops(new Item[0]);
		Server.getInstance().getScheduler().scheduleDelayedTask(new BlockPlaceTask(plugin, block), 5);
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();
		if (block.getId() != Block.SPONGE) {
			return;
		}
		MineManager.getInstance().placeMine(new Position(block.x, block.y + 1, block.z, block.level));
	}
}
