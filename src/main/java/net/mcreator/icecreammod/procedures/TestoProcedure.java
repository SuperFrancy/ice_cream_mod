package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class TestoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 1) {
			return Component.translatable("item.ice_cream_mod.vanilla_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 2) {
			return Component.translatable("item.ice_cream_mod.vanilla_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 3) {
			return Component.translatable("item.ice_cream_mod.chocolate_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 4) {
			return Component.translatable("item.ice_cream_mod.chocolate_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 5) {
			return Component.translatable("item.ice_cream_mod.apple_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 6) {
			return Component.translatable("item.ice_cream_mod.apple_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 7) {
			return Component.translatable("item.ice_cream_mod.carrot_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 8) {
			return Component.translatable("item.ice_cream_mod.carrot_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 9) {
			return Component.translatable("item.ice_cream_mod.beetroot_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 10) {
			return Component.translatable("item.ice_cream_mod.beetroot_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 11) {
			return Component.translatable("item.ice_cream_mod.melon_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 12) {
			return Component.translatable("item.ice_cream_mod.melon_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 13) {
			return Component.translatable("item.ice_cream_mod.sweet_berry_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 14) {
			return Component.translatable("item.ice_cream_mod.sweet_berry_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 15) {
			return Component.translatable("item.ice_cream_mod.glow_berry_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 16) {
			return Component.translatable("item.ice_cream_mod.glow_berry_ice_cream_cup").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 17) {
			return Component.translatable("item.ice_cream_mod.chorus_ice_cream").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen == 18) {
			return Component.translatable("item.ice_cream_mod.chorus_ice_cream_cup").getString();
		}
		return "";
	}
}
