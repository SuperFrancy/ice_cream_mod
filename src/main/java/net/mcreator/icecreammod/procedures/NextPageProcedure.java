package net.mcreator.icecreammod.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class NextPageProcedure {
	public static void execute(LevelAccessor world) {
		if (IceCreamModModVariables.MapVariables.get(world).pagen < 18) {
			IceCreamModModVariables.MapVariables.get(world).pagen = IceCreamModModVariables.MapVariables.get(world).pagen + 1;
			IceCreamModModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
