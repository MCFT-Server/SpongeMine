package spongemine.manage;

import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.level.Position;
import cn.nukkit.utils.Config;
import spongemine.Main;
import spongemine.database.DataBase;

public class MineManager {
	private Main plugin;
	private static MineManager instance;
	
	public MineManager(Main plugin) {
		this.plugin = plugin;
		
		if (instance == null) {
			instance = this;
		}
	}
	
	public static MineManager getInstance() {
		return instance;
	}
	
	public void placeMine(Position pos) {
		pos.getLevel().setBlock(pos, getRandomBlock());
	}
	
	@SuppressWarnings("unchecked")
	private Block getRandomBlock() {
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		double randsum = 0;
		Map<Integer, Number> map = (Map<Integer, Number>) getConfig().get("ore-list");
		for (Number probability : map.values()) {
			randsum += probability.doubleValue();
		}
		int randnum = rand.nextInt((int)randsum);
		double sum = 0;
		for (Entry<Integer, Number> entry : map.entrySet()) {
			sum += entry.getValue().doubleValue();
			if (randnum < sum) {
				return Block.get(entry.getKey());
			}
		}
		return Block.get(Block.STONE);
	}
	
	public Item getMineralByOre(int itemid) {
		switch (itemid) {
		case Item.STONE :
			return Item.get(Item.COBBLESTONE);
		case Item.COAL_ORE :
			return Item.get(Item.COAL);
		case Item.IRON_ORE :
			return Item.get(Item.IRON_INGOT);
		case Item.GOLD_ORE :
			return Item.get(Item.GOLD_INGOT);
		case Item.LAPIS_ORE :
			return Item.get(351, 4, (new Random(Calendar.getInstance().getTimeInMillis()).nextInt(4) + 1));
		case Item.REDSTONE_ORE :
			return Item.get(Item.REDSTONE, 0, (new Random(Calendar.getInstance().getTimeInMillis()).nextInt(4) + 1));
		case Item.DIAMOND_ORE :
			return Item.get(Item.DIAMOND);
		case Item.EMERALD_ORE :
			return Item.get(Item.EMERALD);
		default :
			return Item.get(itemid);
		}
	}
	
	public boolean isDirectOre() {
		return getConfig().getBoolean("direct-ore");
	}
	
	private DataBase getDB() {
		return plugin.getDB();
	}
	
	private Config getConfig() {
		return getDB().getConfig();
	}
}
