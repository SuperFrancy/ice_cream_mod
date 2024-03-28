package net.mcreator.icecreammod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.icecreammod.world.inventory.IceCreamMachineGMenu;
import net.mcreator.icecreammod.procedures.ArrowButtonProcedure;
import net.mcreator.icecreammod.network.IceCreamMachineGButtonMessage;
import net.mcreator.icecreammod.IceCreamModMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class IceCreamMachineGScreen extends AbstractContainerScreen<IceCreamMachineGMenu> {
	private final static HashMap<String, Object> guistate = IceCreamMachineGMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_trasferimentoremovebgpreview;
	ImageButton imagebutton_recipe_book;

	public IceCreamMachineGScreen(IceCreamMachineGMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 177;
	}

	private static final ResourceLocation texture = new ResourceLocation("ice_cream_mod:textures/screens/ice_cream_machine_g.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.ice_cream_mod.ice_cream_machine_g.label_icecreammachine"), 7, 3, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_trasferimentoremovebgpreview = new ImageButton(this.leftPos + 101, this.topPos + 35, 38, 23, 0, 0, 23, new ResourceLocation("ice_cream_mod:textures/screens/atlas/imagebutton_trasferimentoremovebgpreview.png"), 38, 46, e -> {
			if (ArrowButtonProcedure.execute(world, x, y, z)) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new IceCreamMachineGButtonMessage(0, x, y, z));
				IceCreamMachineGButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ArrowButtonProcedure.execute(world, x, y, z))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_trasferimentoremovebgpreview", imagebutton_trasferimentoremovebgpreview);
		this.addRenderableWidget(imagebutton_trasferimentoremovebgpreview);
		imagebutton_recipe_book = new ImageButton(this.leftPos + 7, this.topPos + 39, 20, 18, 0, 0, 18, new ResourceLocation("ice_cream_mod:textures/screens/atlas/imagebutton_recipe_book.png"), 20, 36, e -> {
			if (true) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new IceCreamMachineGButtonMessage(1, x, y, z));
				IceCreamMachineGButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_recipe_book", imagebutton_recipe_book);
		this.addRenderableWidget(imagebutton_recipe_book);
	}
}
