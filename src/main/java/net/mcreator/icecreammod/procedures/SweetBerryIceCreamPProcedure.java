package net.mcreator.icecreammod.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.icecreammod.network.IceCreamModModVariables;
import net.mcreator.icecreammod.init.IceCreamModModItems;

import java.util.function.Supplier;
import java.util.Map;

public class SweetBerryIceCreamPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 13) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(IceCreamModModItems.CONE.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(5)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.MILK_BUCKET).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.SNOWBALL).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.SWEET_BERRIES).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(8)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(IceCreamModModItems.SWEET_BERRY_ICE_CREAM.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(9)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}