package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

public class PrevPageProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen > 1) {
			{
				IceCreamModModVariables.PlayerVariables _vars = entity.getData(IceCreamModModVariables.PLAYER_VARIABLES);
				_vars.pagen = entity.getData(IceCreamModModVariables.PLAYER_VARIABLES).pagen - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
