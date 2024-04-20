package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class NextPage2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 < 9) {
			{
				IceCreamModModVariables.PlayerVariables _vars = entity.getData(IceCreamModModVariables.PLAYER_VARIABLES);
				_vars.pagen2 = entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen2 + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
