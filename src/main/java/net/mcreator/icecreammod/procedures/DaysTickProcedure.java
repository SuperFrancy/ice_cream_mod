package net.mcreator.icecreammod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.icecreammod.network.IceCreamModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DaysTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level());
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		IceCreamModModVariables.MapVariables.get(world).time = IceCreamModModVariables.MapVariables.get(world).time + 1;
		IceCreamModModVariables.MapVariables.get(world).syncData(world);
		if (IceCreamModModVariables.MapVariables.get(world).time == 24000) {
			IceCreamModModVariables.MapVariables.get(world).time = 0;
			IceCreamModModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
