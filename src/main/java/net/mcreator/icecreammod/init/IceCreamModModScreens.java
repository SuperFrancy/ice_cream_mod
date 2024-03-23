
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.icecreammod.client.gui.IceCreamMachineGScreen;
import net.mcreator.icecreammod.client.gui.FreezerGScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IceCreamModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(IceCreamModModMenus.FREEZER_G.get(), FreezerGScreen::new);
			MenuScreens.register(IceCreamModModMenus.ICE_CREAM_MACHINE_G.get(), IceCreamMachineGScreen::new);
		});
	}
}
