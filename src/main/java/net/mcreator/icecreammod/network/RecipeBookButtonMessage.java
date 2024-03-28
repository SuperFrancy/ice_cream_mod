
package net.mcreator.icecreammod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.icecreammod.world.inventory.RecipeBookMenu;
import net.mcreator.icecreammod.procedures.PrevPageProcedure;
import net.mcreator.icecreammod.procedures.NextPageProcedure;
import net.mcreator.icecreammod.procedures.IceCreamMachinePProcedure;
import net.mcreator.icecreammod.procedures.CloseProcedure;
import net.mcreator.icecreammod.IceCreamModMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeBookButtonMessage {
	private final int buttonID, x, y, z;

	public RecipeBookButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public RecipeBookButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(RecipeBookButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(RecipeBookButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = RecipeBookMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PrevPageProcedure.execute(world);
		}
		if (buttonID == 1) {

			NextPageProcedure.execute(world);
		}
		if (buttonID == 2) {

			IceCreamMachinePProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			CloseProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		IceCreamModMod.addNetworkMessage(RecipeBookButtonMessage.class, RecipeBookButtonMessage::buffer, RecipeBookButtonMessage::new, RecipeBookButtonMessage::handler);
	}
}
