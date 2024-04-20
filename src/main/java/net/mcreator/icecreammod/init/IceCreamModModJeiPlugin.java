
package net.mcreator.icecreammod.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.icecreammod.jei_recipes.PopsicleMachineTRecipeCategory;
import net.mcreator.icecreammod.jei_recipes.PopsicleMachineTRecipe;
import net.mcreator.icecreammod.jei_recipes.IceCreamMachineTRecipeCategory;
import net.mcreator.icecreammod.jei_recipes.IceCreamMachineTRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class IceCreamModModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<IceCreamMachineTRecipe> IceCreamMachineT_Type = new mezz.jei.api.recipe.RecipeType<>(IceCreamMachineTRecipeCategory.UID, IceCreamMachineTRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<PopsicleMachineTRecipe> PopsicleMachineT_Type = new mezz.jei.api.recipe.RecipeType<>(PopsicleMachineTRecipeCategory.UID, PopsicleMachineTRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("ice_cream_mod:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new IceCreamMachineTRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new PopsicleMachineTRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<IceCreamMachineTRecipe> IceCreamMachineTRecipes = recipeManager.getAllRecipesFor(IceCreamMachineTRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(IceCreamMachineT_Type, IceCreamMachineTRecipes);
		List<PopsicleMachineTRecipe> PopsicleMachineTRecipes = recipeManager.getAllRecipesFor(PopsicleMachineTRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(PopsicleMachineT_Type, PopsicleMachineTRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(IceCreamModModBlocks.ICE_CREAM_MACHINE.get().asItem()), IceCreamMachineT_Type);
		registration.addRecipeCatalyst(new ItemStack(IceCreamModModBlocks.POPSICLE_MACHINE.get().asItem()), PopsicleMachineT_Type);
	}
}
