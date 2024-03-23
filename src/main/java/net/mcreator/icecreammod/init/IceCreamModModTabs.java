
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IceCreamModMod.MODID);
	public static final RegistryObject<CreativeModeTab> ICE_CREAM = REGISTRY.register("ice_cream",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ice_cream_mod.ice_cream")).icon(() -> new ItemStack(IceCreamModModItems.VANILLA_ICE_CREAM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IceCreamModModBlocks.FREEZER.get().asItem());
				tabData.accept(IceCreamModModBlocks.ICE_CREAM_MACHINE.get().asItem());
				tabData.accept(IceCreamModModItems.DOUGH.get());
				tabData.accept(IceCreamModModItems.WAFFLE.get());
				tabData.accept(IceCreamModModItems.CONE.get());
				tabData.accept(IceCreamModModItems.CONSUMED_CONE.get());
				tabData.accept(IceCreamModModItems.VANILLA_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.VANILLA_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.VANILLA_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.VANILLA_POPSICLE.get());
				tabData.accept(IceCreamModModItems.CHOCOLATE_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.CHOCOLATE_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.CHOCOLATE_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.CHOCOLATE_POPSICLE.get());
				tabData.accept(IceCreamModModItems.APPLE_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.APPLE_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.APPLE_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.APPLE_POPSICLE.get());
				tabData.accept(IceCreamModModItems.CARROT_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.CARROT_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.CARROT_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.CARROT_POPSICLE.get());
				tabData.accept(IceCreamModModItems.BEETROOT_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.BEETROOT_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.BEETROOT_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.BEETROOT_POPSICLE.get());
				tabData.accept(IceCreamModModItems.MELON_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.MELON_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.MELON_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.MELON_POPSICLE.get());
				tabData.accept(IceCreamModModItems.SWEET_BERRY_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.SWEET_BERRY_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.SWEET_BERRY_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.SWEET_BERRY_POPSICLE.get());
				tabData.accept(IceCreamModModItems.GLOW_BERRY_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.GLOW_BERRY_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.GLOW_BERRY_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.GLOW_BERRY_POPSICLE.get());
				tabData.accept(IceCreamModModItems.CHORUS_ICE_CREAM_BALL.get());
				tabData.accept(IceCreamModModItems.CHORUS_ICE_CREAM.get());
				tabData.accept(IceCreamModModItems.CHORUS_ICE_CREAM_CUP.get());
				tabData.accept(IceCreamModModItems.CHORUS_POPSICLE.get());
				tabData.accept(IceCreamModModBlocks.VANILLA_FLOWERS.get().asItem());
			})

					.build());
}
