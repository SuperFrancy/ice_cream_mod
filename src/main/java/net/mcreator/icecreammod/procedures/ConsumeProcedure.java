package net.mcreator.icecreammod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.icecreammod.init.IceCreamModModItems;

public class ConsumeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean succ = false;
		double main = 0;
		double r = 0;
		double ix = 0;
		double iy = 0;
		double iz = 0;
		if (itemstack.getItem().isEdible()) {
			if (itemstack.getItem() == IceCreamModModItems.GLOW_BERRY_ICE_CREAM.get() || itemstack.getItem() == IceCreamModModItems.GLOW_BERRY_ICE_CREAM_CUP.get() || itemstack.getItem() == IceCreamModModItems.GLOW_BERRY_POPSICLE.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 120, 1));
			}
			r = 10;
			ix = (-1) * r;
			iy = (-1) * r;
			iz = (-1) * r;
			succ = true;
			if (itemstack.getItem() == IceCreamModModItems.CHORUS_ICE_CREAM.get() || itemstack.getItem() == IceCreamModModItems.CHORUS_ICE_CREAM_CUP.get() || itemstack.getItem() == IceCreamModModItems.CHORUS_POPSICLE.get()) {
				while (main <= Math.pow(r + 1, 3)) {
					for (int index1 = 0; index1 < (int) (1 * r + 1); index1++) {
						for (int index2 = 0; index2 < (int) (1 * r + 1); index2++) {
							for (int index3 = 0; index3 < (int) (1 * r + 1); index3++) {
								if (world.getBlockState(BlockPos.containing(x + ix, y + iy, z + iz)).canOcclude()) {
									if (!world.getBlockState(BlockPos.containing(x + ix, y + iy, z + iz)).canOcclude() && !world.getBlockState(BlockPos.containing(x + ix, y + iy + 1, z + iz)).canOcclude()) {
										if (Math.random() >= 0.98) {
											{
												Entity _ent = entity;
												_ent.teleportTo((x + ix), (y + iy), (z + iz));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((x + ix), (y + iy), (z + iz), _ent.getYRot(), _ent.getXRot());
											}
											break;
										}
									}
								}
								ix = ix + 1;
							}
							ix = (-1) * r;
							iz = iz + 1;
						}
						iz = (-1) * r;
						iy = iy + 1;
					}
					ix = (-1) * r;
					iy = (-1) * r;
					iz = (-1) * r;
					main = main + 1;
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
			}
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("ice_cream_mod:nice_cream"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
