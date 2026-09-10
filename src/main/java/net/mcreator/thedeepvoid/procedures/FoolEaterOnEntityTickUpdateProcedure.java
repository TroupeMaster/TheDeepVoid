package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.FoolEaterEntity;

public class FoolEaterOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof FoolEaterEntity _datEntL2 && _datEntL2.getEntityData().get(FoolEaterEntity.DATA_cracked)) == false) {
			if (entity instanceof FoolEaterEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FoolEaterEntity.DATA_cracked, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fool_eater_targets")), SoundSource.HOSTILE, 2, (float) 0.8);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:fool_eater_targets")), SoundSource.HOSTILE, 2, (float) 0.8, false);
				}
			}
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
					((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
		} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null && (entity instanceof FoolEaterEntity _datEntL17 && _datEntL17.getEntityData().get(FoolEaterEntity.DATA_cracked)) == true) {
			if (entity instanceof FoolEaterEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FoolEaterEntity.DATA_cracked, false);
		}
	}
}
