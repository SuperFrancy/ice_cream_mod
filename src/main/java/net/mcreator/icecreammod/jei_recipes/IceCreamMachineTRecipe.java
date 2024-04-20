package net.mcreator.icecreammod.jei_recipes;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.SimpleContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.NonNullList;

import javax.annotation.Nullable;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Codec;

public class IceCreamMachineTRecipe implements Recipe<SimpleContainer> {
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public IceCreamMachineTRecipe(ItemStack output, NonNullList<Ingredient> recipeItems) {
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		if (pLevel.isClientSide()) {
			return false;
		}
		return false;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess access) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess access) {
		return output.copy();
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<IceCreamMachineTRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "ice_cream_machine_t";
	}

	public static class Serializer implements RecipeSerializer<IceCreamMachineTRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		private static final Codec<IceCreamMachineTRecipe> CODEC = RecordCodecBuilder
				.create(builder -> builder.group(ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("output").forGetter(recipe -> recipe.output), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap(ingredients -> {
					Ingredient[] aingredient = ingredients.toArray(Ingredient[]::new); // Skip the empty check and create the array.
					if (aingredient.length == 0) {
						return DataResult.error(() -> "No ingredients found in custom recipe");
					} else {
						return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
					}
				}, DataResult::success).forGetter(recipe -> recipe.recipeItems)).apply(builder, IceCreamMachineTRecipe::new));

		@Override
		public Codec<IceCreamMachineTRecipe> codec() {
			return CODEC;
		}

		@Override
		public @Nullable IceCreamMachineTRecipe fromNetwork(FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buf));
			}
			return new IceCreamMachineTRecipe(buf.readItem(), inputs);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, IceCreamMachineTRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buf);
			}
			buf.writeItem(recipe.getResultItem(null));
		}
	}
}
