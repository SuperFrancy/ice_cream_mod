package net.mcreator.icecreammod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class RandomTPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(1 == Mth.nextInt(RandomSource.create(), 1, 10))) {
			{
				Entity _ent = entity;
				_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), -10, 10)), y, (z + Mth.nextInt(RandomSource.create(), -10, 10)));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), -10, 10)), y, (z + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
			}
			for (int index0 = 0; index0 < 7; index0++) {
				if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z, _ent.getYRot(), _ent.getXRot());
					}
					if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
						{
							Entity _ent = entity;
							_ent.teleportTo(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z, _ent.getYRot(), _ent.getXRot());
						}
					}
				} else {
					if (!world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
						{
							Entity _ent = entity;
							_ent.teleportTo(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z, _ent.getYRot(), _ent.getXRot());
						}
						if (!world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
							{
								Entity _ent = entity;
								_ent.teleportTo(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z, _ent.getYRot(), _ent.getXRot());
							}
						}
					} else {
						if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
							{
								Entity _ent = entity;
								_ent.teleportTo(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z, _ent.getYRot(), _ent.getXRot());
							}
							if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
								{
									Entity _ent = entity;
									_ent.teleportTo(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(x, (y + Mth.nextInt(RandomSource.create(), -10, 10)), z, _ent.getYRot(), _ent.getXRot());
								}
							}
						}
					}
				}
			}
		}
	}
}
