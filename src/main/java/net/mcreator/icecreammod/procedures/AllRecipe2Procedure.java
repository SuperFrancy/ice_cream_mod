package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;

public class AllRecipe2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		VanillaPopsiclePProcedure.execute(entity);
		ChocolatePopsiclePProcedure.execute(entity);
		ApplePopsiclePProcedure.execute(entity);
		CarrotPopsiclePProcedure.execute(entity);
		BeetrootPopsiclePProcedure.execute(entity);
		MelonPopsiclePProcedure.execute(entity);
		SweetBerryPopsiclePProcedure.execute(entity);
		GlowBerryPopsiclePProcedure.execute(entity);
		ChorusPopsiclePProcedure.execute(entity);
	}
}
