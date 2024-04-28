package net.mcreator.icecreammod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.icecreammod.init.IceCreamModModItems;

public class ConsumeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double ix = 0;
		double iy = 0;
		double iz = 0;
		if (itemstack.getItem() == IceCreamModModItems.GLOW_BERRY_ICE_CREAM.get() || itemstack.getItem() == IceCreamModModItems.GLOW_BERRY_ICE_CREAM_CUP.get() || itemstack.getItem() == IceCreamModModItems.GLOW_BERRY_POPSICLE.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 120, 1));
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("ice_cream_mod:im_glowing"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (itemstack.getItem() == IceCreamModModItems.CHORUS_ICE_CREAM.get() || itemstack.getItem() == IceCreamModModItems.CHORUS_ICE_CREAM_CUP.get() || itemstack.getItem() == IceCreamModModItems.CHORUS_POPSICLE.get()) {
			ix = Mth.nextInt(RandomSource.create(), -8, 8);
			iy = Mth.nextInt(RandomSource.create(), -8, 8);
			iz = Mth.nextInt(RandomSource.create(), -8, 8);
			while (true) {
				if (!world.getBlockState(BlockPos.containing(x + ix, y + iy, z + iz)).canOcclude() && !(world.getBlockState(BlockPos.containing(x + ix, y + iy, z + iz))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
						&& !world.getBlockState(BlockPos.containing(x + ix, y + iy + 1, z + iz)).canOcclude() && (world.getBlockState(BlockPos.containing(x + ix, y + iy + 1, z + iz))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
						&& world.getBlockState(BlockPos.containing(x + ix, y + iy - 1, z + iz)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo((x + ix), (y + iy), (z + iz));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + ix), (y + iy), (z + iz), _ent.getYRot(), _ent.getXRot());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 5, 3, 3, 3, 1);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
					break;
				} else {
					ix = Mth.nextInt(RandomSource.create(), -8, 8);
					iy = Mth.nextInt(RandomSource.create(), -2, 2);
					iz = Mth.nextInt(RandomSource.create(), -8, 8);
				}
			}
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("ice_cream_mod:where_i_am"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
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
