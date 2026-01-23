package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.IchorSpitEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class IchorSwordLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof Player _plrCldRem1 ? _plrCldRem1.getCooldowns().getCooldownPercent(itemstack.getItem(), 0f) * 100 : 0) <= 0) {
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 0, 5); index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new IchorSpitEntity(TheDeepVoidModEntities.ICHOR_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.setPierceLevel(piercing);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, sourceentity, (float) (double) DeepVoidConfigConfiguration.ICHORSWORDSPIT.get(), 0, (byte) 1);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 1.5), (entity.getZ()));
					_entityToSpawn.shoot((Math.sin(Math.toRadians(entity.getYRot() + 180)) * (-1)), 0.1, (Math.cos(Math.toRadians(entity.getYRot())) * (-1)), 1, 10);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (!(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(TheDeepVoidModMobEffects.ICHOR_BURN.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.ICHOR_BURN.get(), 40, 0));
			}
		}
	}
}
