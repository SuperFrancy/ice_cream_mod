package net.mcreator.icecreammod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DaysBedProcedure {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		IceCreamModModVariables.MapVariables.get(world).time = 0;
		IceCreamModModVariables.MapVariables.get(world).syncData(world);
	}
}
