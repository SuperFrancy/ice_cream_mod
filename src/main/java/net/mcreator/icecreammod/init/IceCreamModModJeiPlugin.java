
package net.mcreator.icecreammod.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.icecreammod.jei_recipes.IceCreamMachineTRecipeCategory;
import net.mcreator.icecreammod.jei_recipes.IceCreamMachineTRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class IceCreamModModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<IceCreamMachineTRecipe> IceCreamMachineT_Type = new mezz.jei.api.recipe.RecipeType<>(IceCreamMachineTRecipeCategory.UID, IceCreamMachineTRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("ice_cream_mod:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new IceCreamMachineTRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<IceCreamMachineTRecipe> IceCreamMachineTRecipes = recipeManager.getAllRecipesFor(IceCreamMachineTRecipe.Type.INSTANCE);
		registration.addRecipes(IceCreamMachineT_Type, IceCreamMachineTRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(IceCreamModModBlocks.ICE_CREAM_MACHINE.get().asItem()), IceCreamMachineT_Type);
	}
}
