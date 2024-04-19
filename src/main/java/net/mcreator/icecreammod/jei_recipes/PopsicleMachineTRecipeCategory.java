
package net.mcreator.icecreammod.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.icecreammod.init.IceCreamModModJeiPlugin;
import net.mcreator.icecreammod.init.IceCreamModModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class PopsicleMachineTRecipeCategory implements IRecipeCategory<PopsicleMachineTRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("ice_cream_mod", "popsicle_machine_t");
	public final static ResourceLocation TEXTURE = new ResourceLocation("ice_cream_mod", "textures/screens/jei2.png");
	private final IDrawable background;
	private final IDrawable icon;

	public PopsicleMachineTRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 178, 104);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(IceCreamModModBlocks.POPSICLE_MACHINE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<PopsicleMachineTRecipe> getRecipeType() {
		return IceCreamModModJeiPlugin.PopsicleMachineT_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Popsicle Machine");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, PopsicleMachineTRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 53, 67).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 53, 40).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 53, 22).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 152, 40).addItemStack(recipe.getResultItem(null));
	}
}
