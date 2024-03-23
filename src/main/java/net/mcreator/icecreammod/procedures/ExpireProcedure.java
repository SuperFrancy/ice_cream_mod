package net.mcreator.icecreammod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import java.util.Map;

public class ExpireProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemstack) : false) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemstack) : false) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, itemstack) != 0) {
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
				if (_enchantments.containsKey(Enchantments.UNBREAKING)) {
					_enchantments.remove(Enchantments.UNBREAKING);
					EnchantmentHelper.setEnchantments(_enchantments, itemstack);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemstack) : false) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MENDING, itemstack) != 0) {
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
				if (_enchantments.containsKey(Enchantments.MENDING)) {
					_enchantments.remove(Enchantments.MENDING);
					EnchantmentHelper.setEnchantments(_enchantments, itemstack);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.BOOK);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			new ItemStack(Items.BOOK).enchant(Enchantments.MENDING, 1);
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemstack) : false) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.VANISHING_CURSE, itemstack) != 0) {
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
				if (_enchantments.containsKey(Enchantments.VANISHING_CURSE)) {
					_enchantments.remove(Enchantments.VANISHING_CURSE);
					EnchantmentHelper.setEnchantments(_enchantments, itemstack);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
