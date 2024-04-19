
package net.mcreator.icecreammod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.icecreammod.world.inventory.RecipeBook2Menu;
import net.mcreator.icecreammod.procedures.PrevPage2Procedure;
import net.mcreator.icecreammod.procedures.PopsicleMachinePProcedure;
import net.mcreator.icecreammod.procedures.NextPage2Procedure;
import net.mcreator.icecreammod.procedures.Make2Procedure;
import net.mcreator.icecreammod.procedures.Close2Procedure;
import net.mcreator.icecreammod.IceCreamModMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeBook2ButtonMessage {
	private final int buttonID, x, y, z;

	public RecipeBook2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public RecipeBook2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(RecipeBook2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(RecipeBook2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = RecipeBook2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PrevPage2Procedure.execute(entity);
		}
		if (buttonID == 1) {

			NextPage2Procedure.execute(entity);
		}
		if (buttonID == 2) {

			Make2Procedure.execute(entity);
		}
		if (buttonID == 3) {

			PopsicleMachinePProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			Close2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		IceCreamModMod.addNetworkMessage(RecipeBook2ButtonMessage.class, RecipeBook2ButtonMessage::buffer, RecipeBook2ButtonMessage::new, RecipeBook2ButtonMessage::handler);
	}
}
