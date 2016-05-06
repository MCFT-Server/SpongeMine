package spongemine.manage;

import java.util.Calendar;
import java.util.Random;

import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.level.Position;

public class MineManager {
	public static void placeMine(Position pos) {
		pos.getLevel().setBlock(pos, getRandomBlock());
	}
	
	private static Block getRandomBlock() {
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		int randnum = rand.nextInt(100);
		if (randnum < 50) {
			return Block.get(Block.STONE);
		} else if (randnum < 68) {
			return Block.get(Block.COAL_ORE);
		} else if (randnum < 78) {
			return Block.get(Block.IRON_ORE);
		} else if (randnum < 86) {
			return Block.get(Block.GOLD_ORE);
		} else if (randnum < 92) {
			return Block.get(Block.LAPIS_ORE);
		} else if (randnum < 97) {
			return Block.get(Block.REDSTONE_ORE);
		} else if (randnum < 99) {
			return Block.get(Block.DIAMOND_ORE);
		} else if (randnum < 100) {
			return Block.get(Block.EMERALD_ORE);
		} else {
			return Block.get(Block.STONE);
		}
	}
	
	public static Item getMineralByOre(int itemid) {
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
}
