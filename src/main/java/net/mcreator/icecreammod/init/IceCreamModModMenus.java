
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.icecreammod.world.inventory.RecipeBookMenu;
import net.mcreator.icecreammod.world.inventory.RecipeBook2Menu;
import net.mcreator.icecreammod.world.inventory.PopsicleMachineGMenu;
import net.mcreator.icecreammod.world.inventory.IceCreamMachineGMenu;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, IceCreamModMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<IceCreamMachineGMenu>> ICE_CREAM_MACHINE_G = REGISTRY.register("ice_cream_machine_g", () -> IMenuTypeExtension.create(IceCreamMachineGMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RecipeBookMenu>> RECIPE_BOOK = REGISTRY.register("recipe_book", () -> IMenuTypeExtension.create(RecipeBookMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PopsicleMachineGMenu>> POPSICLE_MACHINE_G = REGISTRY.register("popsicle_machine_g", () -> IMenuTypeExtension.create(PopsicleMachineGMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RecipeBook2Menu>> RECIPE_BOOK_2 = REGISTRY.register("recipe_book_2", () -> IMenuTypeExtension.create(RecipeBook2Menu::new));
}
