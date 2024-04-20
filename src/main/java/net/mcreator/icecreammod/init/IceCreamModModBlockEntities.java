
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.icecreammod.block.entity.PopsicleMachineBlockEntity;
import net.mcreator.icecreammod.block.entity.IceCreamMachineBlockEntity;
import net.mcreator.icecreammod.IceCreamModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IceCreamModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, IceCreamModMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ICE_CREAM_MACHINE = register("ice_cream_machine", IceCreamModModBlocks.ICE_CREAM_MACHINE, IceCreamMachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> POPSICLE_MACHINE = register("popsicle_machine", IceCreamModModBlocks.POPSICLE_MACHINE, PopsicleMachineBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ICE_CREAM_MACHINE.get(), (blockEntity, side) -> ((IceCreamMachineBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, POPSICLE_MACHINE.get(), (blockEntity, side) -> ((PopsicleMachineBlockEntity) blockEntity).getItemHandler());
	}
}
