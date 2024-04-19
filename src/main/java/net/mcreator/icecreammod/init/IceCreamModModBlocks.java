
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.icecreammod.block.VanillaFlowerBlock;
import net.mcreator.icecreammod.block.PopsicleMachineBlock;
import net.mcreator.icecreammod.block.IceCreamMachineBlock;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, IceCreamModMod.MODID);
	public static final RegistryObject<Block> VANILLA_FLOWER = REGISTRY.register("vanilla_flower", () -> new VanillaFlowerBlock());
	public static final RegistryObject<Block> ICE_CREAM_MACHINE = REGISTRY.register("ice_cream_machine", () -> new IceCreamMachineBlock());
	public static final RegistryObject<Block> POPSICLE_MACHINE = REGISTRY.register("popsicle_machine", () -> new PopsicleMachineBlock());
}
