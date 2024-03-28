package net.mcreator.icecreammod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.icecreammod.world.inventory.RecipeBookMenu;
import net.mcreator.icecreammod.world.inventory.IceCreamMachineGMenu;
import net.mcreator.icecreammod.world.inventory.FreezerGMenu;
import net.mcreator.icecreammod.network.IceCreamModModVariables;
import net.mcreator.icecreammod.init.IceCreamModModItems;

import java.util.function.Supplier;
import java.util.Map;

public class ExpireProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemstack) : false) && IceCreamModModVariables.MapVariables.get(world).time == 0) {
			if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:ice_cream")))) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(IceCreamModModItems.CONSUMED_CONE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:cup")))) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.BOWL);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:popsicle")))) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.STICK);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
		if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:freezer_item"))) && !(entity instanceof Player _plr19 && _plr19.containerMenu instanceof RecipeBookMenu)
				&& !(entity instanceof Player _plr20 && _plr20.containerMenu instanceof IceCreamMachineGMenu) && !(entity instanceof Player _plr21 && _plr21.containerMenu instanceof FreezerGMenu)) {
			if (itemstack.getItem() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(1)).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = itemstack;
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}
