
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.icecreammod.client.gui.RecipeBookScreen;
import net.mcreator.icecreammod.client.gui.RecipeBook2Screen;
import net.mcreator.icecreammod.client.gui.PopsicleMachineGScreen;
import net.mcreator.icecreammod.client.gui.IceCreamMachineGScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IceCreamModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(IceCreamModModMenus.ICE_CREAM_MACHINE_G.get(), IceCreamMachineGScreen::new);
			MenuScreens.register(IceCreamModModMenus.RECIPE_BOOK.get(), RecipeBookScreen::new);
			MenuScreens.register(IceCreamModModMenus.POPSICLE_MACHINE_G.get(), PopsicleMachineGScreen::new);
			MenuScreens.register(IceCreamModModMenus.RECIPE_BOOK_2.get(), RecipeBook2Screen::new);
		});
	}
}
