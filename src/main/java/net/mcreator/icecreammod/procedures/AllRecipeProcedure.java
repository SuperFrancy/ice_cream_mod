package net.mcreator.icecreammod.procedures;

import net.minecraft.world.entity.Entity;

public class AllRecipeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		VanillaIceCreamPProcedure.execute(entity);
		VanillaIceCreamCupPProcedure.execute(entity);
		ChocolateIceCreamPProcedure.execute(entity);
		ChocolateIceCreamCupPProcedure.execute(entity);
		AppleIceCreamPProcedure.execute(entity);
		AppleIceCreamCupPProcedure.execute(entity);
		CarrotIceCreamPProcedure.execute(entity);
		CarrotIceCreamCupPProcedure.execute(entity);
		BeetrootIceCreamPProcedure.execute(entity);
		BeetrootIceCreamCupPProcedure.execute(entity);
		MelonIceCreamPProcedure.execute(entity);
		MelonIceCreamCupPProcedure.execute(entity);
		SweetBerryIceCreamPProcedure.execute(entity);
		SweetBerryIceCreamCupPProcedure.execute(entity);
		GlowBerryIceCreamPProcedure.execute(entity);
		GlowBerryIceCreamCupPProcedure.execute(entity);
		ChorusIceCreamPProcedure.execute(entity);
		ChorusIceCreamCupPProcedure.execute(entity);
	}
}
