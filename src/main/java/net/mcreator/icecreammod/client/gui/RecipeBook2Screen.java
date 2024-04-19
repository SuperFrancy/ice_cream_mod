package net.mcreator.icecreammod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.icecreammod.world.inventory.RecipeBook2Menu;
import net.mcreator.icecreammod.procedures.Testo2Procedure;
import net.mcreator.icecreammod.procedures.ArrowButton2Procedure;
import net.mcreator.icecreammod.network.RecipeBook2ButtonMessage;
import net.mcreator.icecreammod.IceCreamModMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RecipeBook2Screen extends AbstractContainerScreen<RecipeBook2Menu> {
	private final static HashMap<String, Object> guistate = RecipeBook2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_make;
	ImageButton imagebutton_trasferimentoremovebgpreview;
	ImageButton imagebutton_button_highlighted;

	public RecipeBook2Screen(RecipeBook2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 177;
	}

	private static final ResourceLocation texture = new ResourceLocation("ice_cream_mod:textures/screens/recipe_book_2.png");

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

		guiGraphics.blit(new ResourceLocation("ice_cream_mod:textures/screens/recipe.png"), this.leftPos + -115, this.topPos + 0, 0, 0, 113, 177, 113, 177);

		guiGraphics.blit(new ResourceLocation("ice_cream_mod:textures/screens/trasferimento-removebg-preview.png"), this.leftPos + -64, this.topPos + 42, 0, 0, 19, 11, 19, 11);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.ice_cream_mod.recipe_book_2.label_icecreammachine"), 7, 3, -12829636, false);
		guiGraphics.drawString(this.font,

				Testo2Procedure.execute(entity), -111, 4, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.ice_cream_mod.recipe_book_2.button_empty"), e -> {
			if (true) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new RecipeBook2ButtonMessage(0, x, y, z));
				RecipeBook2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -92, this.topPos + 129, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.ice_cream_mod.recipe_book_2.button_empty1"), e -> {
			if (true) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new RecipeBook2ButtonMessage(1, x, y, z));
				RecipeBook2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + -56, this.topPos + 129, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_make = Button.builder(Component.translatable("gui.ice_cream_mod.recipe_book_2.button_make"), e -> {
			if (true) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new RecipeBook2ButtonMessage(2, x, y, z));
				RecipeBook2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + -81, this.topPos + 93, 46, 20).build();
		guistate.put("button:button_make", button_make);
		this.addRenderableWidget(button_make);
		imagebutton_trasferimentoremovebgpreview = new ImageButton(this.leftPos + 91, this.topPos + 36, 38, 23, 0, 0, 23, new ResourceLocation("ice_cream_mod:textures/screens/atlas/imagebutton_trasferimentoremovebgpreview.png"), 38, 46, e -> {
			if (ArrowButton2Procedure.execute(world, x, y, z)) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new RecipeBook2ButtonMessage(3, x, y, z));
				RecipeBook2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ArrowButton2Procedure.execute(world, x, y, z))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_trasferimentoremovebgpreview", imagebutton_trasferimentoremovebgpreview);
		this.addRenderableWidget(imagebutton_trasferimentoremovebgpreview);
		imagebutton_button_highlighted = new ImageButton(this.leftPos + 9, this.topPos + 39, 20, 18, 0, 0, 18, new ResourceLocation("ice_cream_mod:textures/screens/atlas/imagebutton_button_highlighted.png"), 20, 36, e -> {
			if (true) {
				IceCreamModMod.PACKET_HANDLER.sendToServer(new RecipeBook2ButtonMessage(4, x, y, z));
				RecipeBook2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_button_highlighted", imagebutton_button_highlighted);
		this.addRenderableWidget(imagebutton_button_highlighted);
	}
}
