package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class TestoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 1) {
			return Component.translatable("item.ice_cream_mod.vanilla_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 2) {
			return Component.translatable("item.ice_cream_mod.vanilla_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 3) {
			return Component.translatable("item.ice_cream_mod.chocolate_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 4) {
			return Component.translatable("item.ice_cream_mod.chocolate_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 5) {
			return Component.translatable("item.ice_cream_mod.apple_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 6) {
			return Component.translatable("item.ice_cream_mod.apple_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 7) {
			return Component.translatable("item.ice_cream_mod.carrot_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 8) {
			return Component.translatable("item.ice_cream_mod.carrot_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 9) {
			return Component.translatable("item.ice_cream_mod.beetroot_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 10) {
			return Component.translatable("item.ice_cream_mod.beetroot_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 11) {
			return Component.translatable("item.ice_cream_mod.melon_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 12) {
			return Component.translatable("item.ice_cream_mod.melon_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 13) {
			return Component.translatable("item.ice_cream_mod.sweet_berry_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 14) {
			return Component.translatable("item.ice_cream_mod.sweet_berry_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 15) {
			return Component.translatable("item.ice_cream_mod.glow_berry_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 16) {
			return Component.translatable("item.ice_cream_mod.glow_berry_ice_cream_cup").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 17) {
			return Component.translatable("item.ice_cream_mod.chorus_ice_cream").getString();
		} else if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen == 18) {
			return Component.translatable("item.ice_cream_mod.chorus_ice_cream_cup").getString();
		}
		return "";
	}
}
