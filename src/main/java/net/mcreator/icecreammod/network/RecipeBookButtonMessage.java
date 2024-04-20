
package net.mcreator.icecreammod.network;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.icecreammod.world.inventory.RecipeBookMenu;
import net.mcreator.icecreammod.procedures.PrevPageProcedure;
import net.mcreator.icecreammod.procedures.NextPageProcedure;
import net.mcreator.icecreammod.procedures.MakeProcedure;
import net.mcreator.icecreammod.procedures.IceCreamMachinePProcedure;
import net.mcreator.icecreammod.procedures.CloseProcedure;
import net.mcreator.icecreammod.IceCreamModMod;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record RecipeBookButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final ResourceLocation ID = new ResourceLocation(IceCreamModMod.MODID, "recipe_book_buttons");
	public RecipeBookButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	@Override
	public void write(final FriendlyByteBuf buffer) {
		buffer.writeInt(buttonID);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handleData(final RecipeBookButtonMessage message, final PlayPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.workHandler().submitAsync(() -> {
				Player entity = context.player().get();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.packetHandler().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = RecipeBookMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PrevPageProcedure.execute(entity);
		}
		if (buttonID == 1) {

			NextPageProcedure.execute(entity);
		}
		if (buttonID == 2) {

			MakeProcedure.execute(entity);
		}
		if (buttonID == 3) {

			IceCreamMachinePProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			CloseProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		IceCreamModMod.addNetworkMessage(RecipeBookButtonMessage.ID, RecipeBookButtonMessage::new, RecipeBookButtonMessage::handleData);
	}
}
