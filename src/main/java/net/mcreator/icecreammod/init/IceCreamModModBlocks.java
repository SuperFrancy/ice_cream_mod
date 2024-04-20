
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.icecreammod.block.VanillaFlowerBlock;
import net.mcreator.icecreammod.block.PopsicleMachineBlock;
import net.mcreator.icecreammod.block.IceCreamMachineBlock;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, IceCreamModMod.MODID);
	public static final DeferredHolder<Block, Block> ICE_CREAM_MACHINE = REGISTRY.register("ice_cream_machine", () -> new IceCreamMachineBlock());
	public static final DeferredHolder<Block, Block> VANILLA_FLOWER = REGISTRY.register("vanilla_flower", () -> new VanillaFlowerBlock());
	public static final DeferredHolder<Block, Block> POPSICLE_MACHINE = REGISTRY.register("popsicle_machine", () -> new PopsicleMachineBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
