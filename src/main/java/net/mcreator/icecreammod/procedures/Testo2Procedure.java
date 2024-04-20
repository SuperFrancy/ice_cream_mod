package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class Testo2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 1) {
			return Component.translatable("item.ice_cream_mod.vanilla_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 2) {
			return Component.translatable("item.ice_cream_mod.chocolate_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 3) {
			return Component.translatable("item.ice_cream_mod.apple_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 4) {
			return Component.translatable("item.ice_cream_mod.carrot_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 5) {
			return Component.translatable("item.ice_cream_mod.beetroot_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 6) {
			return Component.translatable("item.ice_cream_mod.melon_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 7) {
			return Component.translatable("item.ice_cream_mod.sweet_berry_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 8) {
			return Component.translatable("item.ice_cream_mod.glow_berry_popsicle").getString();
		} else if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 == 9) {
			return Component.translatable("item.ice_cream_mod.chorus_popsicle").getString();
		}
		return "";
	}
}
