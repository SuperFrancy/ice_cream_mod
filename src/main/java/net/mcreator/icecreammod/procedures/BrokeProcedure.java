package net.mcreator.icecreammod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.icecreammod.init.IceCreamModModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BrokeProcedure {
	@SubscribeEvent
	public static void onItemDestroyed(PlayerDestroyItemEvent event) {
		execute(event, event.getEntity(), event.getOriginal());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:ice_cream")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(IceCreamModModItems.CONSUMED_CONE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:cup")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.BOWL);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("ice_cream_mod:popsicle")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.STICK);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
