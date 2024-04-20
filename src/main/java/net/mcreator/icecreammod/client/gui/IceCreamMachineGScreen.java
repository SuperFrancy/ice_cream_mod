package net.mcreator.icecreammod.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.icecreammod.world.inventory.IceCreamMachineGMenu;
import net.mcreator.icecreammod.procedures.ArrowButtonProcedure;
import net.mcreator.icecreammod.network.IceCreamMachineGButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class IceCreamMachineGScreen extends AbstractContainerScreen<IceCreamMachineGMenu> {
	private final static HashMap<String, Object> guistate = IceCreamMachineGMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_trasferimentoremovebgpreview;
	ImageButton imagebutton_book;

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
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.ice_cream_mod.ice_cream_machine_g.label_icecreammachine"), 7, 3, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_trasferimentoremovebgpreview = new ImageButton(this.leftPos + 101, this.topPos + 35, 38, 23,
				new WidgetSprites(new ResourceLocation("ice_cream_mod:textures/screens/trasferimento-removebg-preview.png"), new ResourceLocation("ice_cream_mod:textures/screens/button.png")), e -> {
					if (ArrowButtonProcedure.execute(world, x, y, z)) {
						PacketDistributor.SERVER.noArg().send(new IceCreamMachineGButtonMessage(0, x, y, z));
						IceCreamMachineGButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ArrowButtonProcedure.execute(world, x, y, z))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_trasferimentoremovebgpreview", imagebutton_trasferimentoremovebgpreview);
		this.addRenderableWidget(imagebutton_trasferimentoremovebgpreview);
		imagebutton_book = new ImageButton(this.leftPos + 7, this.topPos + 39, 20, 18, new WidgetSprites(new ResourceLocation("ice_cream_mod:textures/screens/book.png"), new ResourceLocation("ice_cream_mod:textures/screens/button_highlighted.png")),
				e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new IceCreamMachineGButtonMessage(1, x, y, z));
						IceCreamMachineGButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_book", imagebutton_book);
		this.addRenderableWidget(imagebutton_book);
	}
}
