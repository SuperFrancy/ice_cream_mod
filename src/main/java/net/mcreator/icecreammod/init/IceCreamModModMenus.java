
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.icecreammod.world.inventory.IceCreamMachineGMenu;
import net.mcreator.icecreammod.world.inventory.FreezerGMenu;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IceCreamModMod.MODID);
	public static final RegistryObject<MenuType<FreezerGMenu>> FREEZER_G = REGISTRY.register("freezer_g", () -> IForgeMenuType.create(FreezerGMenu::new));
	public static final RegistryObject<MenuType<IceCreamMachineGMenu>> ICE_CREAM_MACHINE_G = REGISTRY.register("ice_cream_machine_g", () -> IForgeMenuType.create(IceCreamMachineGMenu::new));
}
