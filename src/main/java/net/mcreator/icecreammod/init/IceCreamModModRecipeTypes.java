package net.mcreator.icecreammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.icecreammod.jei_recipes.PopsicleMachineTRecipe;
import net.mcreator.icecreammod.jei_recipes.IceCreamMachineTRecipe;
import net.mcreator.icecreammod.IceCreamModMod;

@Mod.EventBusSubscriber(modid = IceCreamModMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IceCreamModModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "ice_cream_mod");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("ice_cream_machine_t", () -> IceCreamMachineTRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("popsicle_machine_t", () -> PopsicleMachineTRecipe.Serializer.INSTANCE);
		});
	}
}
