
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.icecreammod.world.inventory.RecipeBookMenu;
import net.mcreator.icecreammod.world.inventory.RecipeBook2Menu;
import net.mcreator.icecreammod.world.inventory.PopsicleMachineGMenu;
import net.mcreator.icecreammod.world.inventory.IceCreamMachineGMenu;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IceCreamModMod.MODID);
	public static final RegistryObject<MenuType<IceCreamMachineGMenu>> ICE_CREAM_MACHINE_G = REGISTRY.register("ice_cream_machine_g", () -> IForgeMenuType.create(IceCreamMachineGMenu::new));
	public static final RegistryObject<MenuType<RecipeBookMenu>> RECIPE_BOOK = REGISTRY.register("recipe_book", () -> IForgeMenuType.create(RecipeBookMenu::new));
	public static final RegistryObject<MenuType<PopsicleMachineGMenu>> POPSICLE_MACHINE_G = REGISTRY.register("popsicle_machine_g", () -> IForgeMenuType.create(PopsicleMachineGMenu::new));
	public static final RegistryObject<MenuType<RecipeBook2Menu>> RECIPE_BOOK_2 = REGISTRY.register("recipe_book_2", () -> IForgeMenuType.create(RecipeBook2Menu::new));
}
