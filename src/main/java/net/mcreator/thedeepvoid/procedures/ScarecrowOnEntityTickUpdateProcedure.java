package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.SwarmerEntity;
import net.mcreator.thedeepvoid.entity.EyekinFlyingEntity;
import net.mcreator.thedeepvoid.entity.EyekinEntity;

import java.util.List;
import java.util.Comparator;

public class ScarecrowOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (!world.getEntitiesOfClass(SwarmerEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty() || !world.getEntitiesOfClass(EyekinEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()
					|| !world.getEntitiesOfClass(EyekinFlyingEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SwarmerEntity || entityiterator instanceof EyekinEntity || entityiterator instanceof EyekinFlyingEntity) {
							if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
								if (entityiterator instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("deep_void:crowCall") >= 5) {
			entity.getPersistentData().putDouble("deep_void:crowCall", (Mth.nextInt(RandomSource.create(), 0, 2)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -15, 15), y + Mth.nextInt(RandomSource.create(), -2, 2), z + Mth.nextInt(RandomSource.create(), -15, 15)),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crow_call")), SoundSource.AMBIENT, 2, (float) Mth.nextDouble(RandomSource.create(), 1, 1.1));
				} else {
					_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -15, 15)), (y + Mth.nextInt(RandomSource.create(), -2, 2)), (z + Mth.nextInt(RandomSource.create(), -15, 15)),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:crow_call")), SoundSource.AMBIENT, 2, (float) Mth.nextDouble(RandomSource.create(), 1, 1.1), false);
				}
			}
		}
	}
}
