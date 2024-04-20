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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.icecreammod.world.inventory.RecipeBookMenu;
import net.mcreator.icecreammod.procedures.TestoProcedure;
import net.mcreator.icecreammod.procedures.ArrowButtonProcedure;
import net.mcreator.icecreammod.network.RecipeBookButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RecipeBookScreen extends AbstractContainerScreen<RecipeBookMenu> {
	private final static HashMap<String, Object> guistate = RecipeBookMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_make;
	ImageButton imagebutton_trasferimentoremovebgpreview;
	ImageButton imagebutton_button_highlighted;

	public RecipeBookScreen(RecipeBookMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 177;
	}

	private static final ResourceLocation texture = new ResourceLocation("ice_cream_mod:textures/screens/recipe_book.png");

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

		guiGraphics.blit(new ResourceLocation("ice_cream_mod:textures/screens/icm.png"), this.leftPos + -115, this.topPos + 0, 0, 0, 112, 177, 112, 177);

		guiGraphics.blit(new ResourceLocation("ice_cream_mod:textures/screens/trasferimento-removebg-preview.png"), this.leftPos + -52, this.topPos + 42, 0, 0, 19, 11, 19, 11);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.ice_cream_mod.recipe_book.label_icecreammachine"), 7, 3, -12829636, false);
		guiGraphics.drawString(this.font,

				TestoProcedure.execute(entity), -111, 4, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.ice_cream_mod.recipe_book.button_empty"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new RecipeBookButtonMessage(0, x, y, z));
				RecipeBookButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -92, this.topPos + 129, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.ice_cream_mod.recipe_book.button_empty1"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new RecipeBookButtonMessage(1, x, y, z));
				RecipeBookButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + -56, this.topPos + 129, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_make = Button.builder(Component.translatable("gui.ice_cream_mod.recipe_book.button_make"), e -> {
			if (true) {
				PacketDistributor.SERVER.noArg().send(new RecipeBookButtonMessage(2, x, y, z));
				RecipeBookButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + -81, this.topPos + 93, 46, 20).build();
		guistate.put("button:button_make", button_make);
		this.addRenderableWidget(button_make);
		imagebutton_trasferimentoremovebgpreview = new ImageButton(this.leftPos + 101, this.topPos + 36, 38, 23,
				new WidgetSprites(new ResourceLocation("ice_cream_mod:textures/screens/trasferimento-removebg-preview.png"), new ResourceLocation("ice_cream_mod:textures/screens/button.png")), e -> {
					if (ArrowButtonProcedure.execute(world, x, y, z)) {
						PacketDistributor.SERVER.noArg().send(new RecipeBookButtonMessage(3, x, y, z));
						RecipeBookButtonMessage.handleButtonAction(entity, 3, x, y, z);
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
		imagebutton_button_highlighted = new ImageButton(this.leftPos + 9, this.topPos + 39, 20, 18,
				new WidgetSprites(new ResourceLocation("ice_cream_mod:textures/screens/button_highlighted.png"), new ResourceLocation("ice_cream_mod:textures/screens/button_highlighted.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new RecipeBookButtonMessage(4, x, y, z));
						RecipeBookButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_highlighted", imagebutton_button_highlighted);
		this.addRenderableWidget(imagebutton_button_highlighted);
	}
}
