
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.icecreammod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.icecreammod.item.WaffleItem;
import net.mcreator.icecreammod.item.VanillaPopsicleItem;
import net.mcreator.icecreammod.item.VanillaIceCreamItem;
import net.mcreator.icecreammod.item.VanillaIceCreamCupItem;
import net.mcreator.icecreammod.item.SweetBerryPopsicleItem;
import net.mcreator.icecreammod.item.SweetBerryIceCreamItem;
import net.mcreator.icecreammod.item.SweetBerryIceCreamCupItem;
import net.mcreator.icecreammod.item.MelonPopsicleItem;
import net.mcreator.icecreammod.item.MelonIceCreamItem;
import net.mcreator.icecreammod.item.MelonIceCreamCupItem;
import net.mcreator.icecreammod.item.GlowBerryPopsicleItem;
import net.mcreator.icecreammod.item.GlowBerryIceCreamItem;
import net.mcreator.icecreammod.item.GlowBerryIceCreamCupItem;
import net.mcreator.icecreammod.item.DoughItem;
import net.mcreator.icecreammod.item.ConsumedConeItem;
import net.mcreator.icecreammod.item.ConeItem;
import net.mcreator.icecreammod.item.ChorusPopsicleItem;
import net.mcreator.icecreammod.item.ChorusIceCreamItem;
import net.mcreator.icecreammod.item.ChorusIceCreamCupItem;
import net.mcreator.icecreammod.item.ChocolatePopsicleItem;
import net.mcreator.icecreammod.item.ChocolateIceCreamItem;
import net.mcreator.icecreammod.item.ChocolateIceCreamCupItem;
import net.mcreator.icecreammod.item.CarrotPopsicleItem;
import net.mcreator.icecreammod.item.CarrotIceCreamItem;
import net.mcreator.icecreammod.item.CarrotIceCreamCupItem;
import net.mcreator.icecreammod.item.BeetrootPopsicleItem;
import net.mcreator.icecreammod.item.BeetrootIceCreamItem;
import net.mcreator.icecreammod.item.BeetrootIceCreamCupItem;
import net.mcreator.icecreammod.item.ApplePopsicleItem;
import net.mcreator.icecreammod.item.AppleIceCreamItem;
import net.mcreator.icecreammod.item.AppleIceCreamCupItem;
import net.mcreator.icecreammod.IceCreamModMod;

public class IceCreamModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, IceCreamModMod.MODID);
	public static final RegistryObject<Item> DOUGH = REGISTRY.register("dough", () -> new DoughItem());
	public static final RegistryObject<Item> WAFFLE = REGISTRY.register("waffle", () -> new WaffleItem());
	public static final RegistryObject<Item> CONE = REGISTRY.register("cone", () -> new ConeItem());
	public static final RegistryObject<Item> CONSUMED_CONE = REGISTRY.register("consumed_cone", () -> new ConsumedConeItem());
	public static final RegistryObject<Item> VANILLA_ICE_CREAM = REGISTRY.register("vanilla_ice_cream", () -> new VanillaIceCreamItem());
	public static final RegistryObject<Item> VANILLA_ICE_CREAM_CUP = REGISTRY.register("vanilla_ice_cream_cup", () -> new VanillaIceCreamCupItem());
	public static final RegistryObject<Item> VANILLA_POPSICLE = REGISTRY.register("vanilla_popsicle", () -> new VanillaPopsicleItem());
	public static final RegistryObject<Item> CHOCOLATE_ICE_CREAM = REGISTRY.register("chocolate_ice_cream", () -> new ChocolateIceCreamItem());
	public static final RegistryObject<Item> CHOCOLATE_ICE_CREAM_CUP = REGISTRY.register("chocolate_ice_cream_cup", () -> new ChocolateIceCreamCupItem());
	public static final RegistryObject<Item> CHOCOLATE_POPSICLE = REGISTRY.register("chocolate_popsicle", () -> new ChocolatePopsicleItem());
	public static final RegistryObject<Item> APPLE_ICE_CREAM = REGISTRY.register("apple_ice_cream", () -> new AppleIceCreamItem());
	public static final RegistryObject<Item> APPLE_ICE_CREAM_CUP = REGISTRY.register("apple_ice_cream_cup", () -> new AppleIceCreamCupItem());
	public static final RegistryObject<Item> APPLE_POPSICLE = REGISTRY.register("apple_popsicle", () -> new ApplePopsicleItem());
	public static final RegistryObject<Item> CARROT_ICE_CREAM = REGISTRY.register("carrot_ice_cream", () -> new CarrotIceCreamItem());
	public static final RegistryObject<Item> CARROT_ICE_CREAM_CUP = REGISTRY.register("carrot_ice_cream_cup", () -> new CarrotIceCreamCupItem());
	public static final RegistryObject<Item> CARROT_POPSICLE = REGISTRY.register("carrot_popsicle", () -> new CarrotPopsicleItem());
	public static final RegistryObject<Item> BEETROOT_ICE_CREAM = REGISTRY.register("beetroot_ice_cream", () -> new BeetrootIceCreamItem());
	public static final RegistryObject<Item> BEETROOT_ICE_CREAM_CUP = REGISTRY.register("beetroot_ice_cream_cup", () -> new BeetrootIceCreamCupItem());
	public static final RegistryObject<Item> BEETROOT_POPSICLE = REGISTRY.register("beetroot_popsicle", () -> new BeetrootPopsicleItem());
	public static final RegistryObject<Item> MELON_ICE_CREAM = REGISTRY.register("melon_ice_cream", () -> new MelonIceCreamItem());
	public static final RegistryObject<Item> MELON_ICE_CREAM_CUP = REGISTRY.register("melon_ice_cream_cup", () -> new MelonIceCreamCupItem());
	public static final RegistryObject<Item> MELON_POPSICLE = REGISTRY.register("melon_popsicle", () -> new MelonPopsicleItem());
	public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM = REGISTRY.register("sweet_berry_ice_cream", () -> new SweetBerryIceCreamItem());
	public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM_CUP = REGISTRY.register("sweet_berry_ice_cream_cup", () -> new SweetBerryIceCreamCupItem());
	public static final RegistryObject<Item> SWEET_BERRY_POPSICLE = REGISTRY.register("sweet_berry_popsicle", () -> new SweetBerryPopsicleItem());
	public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM = REGISTRY.register("glow_berry_ice_cream", () -> new GlowBerryIceCreamItem());
	public static final RegistryObject<Item> GLOW_BERRY_ICE_CREAM_CUP = REGISTRY.register("glow_berry_ice_cream_cup", () -> new GlowBerryIceCreamCupItem());
	public static final RegistryObject<Item> GLOW_BERRY_POPSICLE = REGISTRY.register("glow_berry_popsicle", () -> new GlowBerryPopsicleItem());
	public static final RegistryObject<Item> CHORUS_ICE_CREAM = REGISTRY.register("chorus_ice_cream", () -> new ChorusIceCreamItem());
	public static final RegistryObject<Item> CHORUS_ICE_CREAM_CUP = REGISTRY.register("chorus_ice_cream_cup", () -> new ChorusIceCreamCupItem());
	public static final RegistryObject<Item> CHORUS_POPSICLE = REGISTRY.register("chorus_popsicle", () -> new ChorusPopsicleItem());
	public static final RegistryObject<Item> VANILLA_FLOWER = block(IceCreamModModBlocks.VANILLA_FLOWER);
	public static final RegistryObject<Item> FREEZER = block(IceCreamModModBlocks.FREEZER);
	public static final RegistryObject<Item> ICE_CREAM_MACHINE = block(IceCreamModModBlocks.ICE_CREAM_MACHINE);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
