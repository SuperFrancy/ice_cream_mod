package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.icecreammod.jei_recipes.PopsicleMachineTRecipe;
import net.mcreator.icecreammod.jei_recipes.IceCreamMachineTRecipe;
import net.mcreator.icecreammod.IceCreamModMod;

@Mod.EventBusSubscriber(modid = IceCreamModMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IceCreamModModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "ice_cream_mod");

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
