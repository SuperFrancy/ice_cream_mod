package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class PrevPage2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen2 > 1) {
			{
				double _setval = (entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IceCreamModModVariables.PlayerVariables())).pagen2 - 1;
				entity.getCapability(IceCreamModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.pagen2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
