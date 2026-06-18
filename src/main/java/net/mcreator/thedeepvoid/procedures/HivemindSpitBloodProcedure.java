package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.BloodSpitEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class HivemindSpitBloodProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_bloodSpit) : 0) == 10) {
				if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_attacking, false);
			}
			if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_bloodSpit) : 0) > 0) {
				if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_bloodSpit, (int) ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_bloodSpit) : 0) - 1));
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new BloodSpitEntity(TheDeepVoidModEntities.BLOOD_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.HIVEMINDBLOODSPITDAMAGE.get(), 1);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1), (entity.getZ()));
					_entityToSpawn.shoot((Mth.nextInt(RandomSource.create(), -2, 2)), 0.06, (Mth.nextInt(RandomSource.create(), -2, 2)), (float) 1.25, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
				if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
						}
					}
				}
			}
		}
	}
}
