
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.icecreammod.block.entity.PopsicleMachineBlockEntity;
import net.mcreator.icecreammod.block.entity.IceCreamMachineBlockEntity;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, IceCreamModMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ICE_CREAM_MACHINE = register("ice_cream_machine", IceCreamModModBlocks.ICE_CREAM_MACHINE, IceCreamMachineBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POPSICLE_MACHINE = register("popsicle_machine", IceCreamModModBlocks.POPSICLE_MACHINE, PopsicleMachineBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
