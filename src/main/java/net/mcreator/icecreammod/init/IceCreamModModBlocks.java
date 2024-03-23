
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.icecreammod.block.IceCreamMachineBlock;
import net.mcreator.icecreammod.block.FreezerBlock;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, IceCreamModMod.MODID);
	public static final RegistryObject<Block> FREEZER = REGISTRY.register("freezer", () -> new FreezerBlock());
	public static final RegistryObject<Block> ICE_CREAM_MACHINE = REGISTRY.register("ice_cream_machine", () -> new IceCreamMachineBlock());
}
