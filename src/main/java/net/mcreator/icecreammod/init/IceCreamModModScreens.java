
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.icecreammod.client.gui.RecipeBookScreen;
import net.mcreator.icecreammod.client.gui.RecipeBook2Screen;
import net.mcreator.icecreammod.client.gui.PopsicleMachineGScreen;
import net.mcreator.icecreammod.client.gui.IceCreamMachineGScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IceCreamModModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(IceCreamModModMenus.ICE_CREAM_MACHINE_G.get(), IceCreamMachineGScreen::new);
		event.register(IceCreamModModMenus.RECIPE_BOOK.get(), RecipeBookScreen::new);
		event.register(IceCreamModModMenus.POPSICLE_MACHINE_G.get(), PopsicleMachineGScreen::new);
		event.register(IceCreamModModMenus.RECIPE_BOOK_2.get(), RecipeBook2Screen::new);
	}
}
