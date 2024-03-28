package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;

public class AllRecipeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		VanillaIceCreamPProcedure.execute(entity);
	}
}
