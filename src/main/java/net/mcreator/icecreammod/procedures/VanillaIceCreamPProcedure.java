package net.mcreator.icecreammod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.icecreammod.network.IceCreamModModVariables;
import net.mcreator.icecreammod.init.IceCreamModModItems;
import net.mcreator.icecreammod.init.IceCreamModModBlocks;

import java.util.function.Supplier;
import java.util.Map;

public class VanillaIceCreamPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (IceCreamModModVariables.MapVariables.get(world).pagen == 1) {
			IceCreamModModVariables.MapVariables.get(world).recipe = Component.translatable("item.ice_cream_mod.vanilla_ice_cream").getString();
			IceCreamModModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(IceCreamModModItems.CONE.get());
				_setstack.setCount(1);
				((Slot) _slots.get(5)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.MILK_BUCKET);
				_setstack.setCount(1);
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.SNOWBALL);
				_setstack.setCount(1);
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(IceCreamModModBlocks.VANILLA_FLOWER.get());
				_setstack.setCount(1);
				((Slot) _slots.get(8)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(IceCreamModModItems.VANILLA_ICE_CREAM.get());
				_setstack.setCount(1);
				((Slot) _slots.get(9)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
