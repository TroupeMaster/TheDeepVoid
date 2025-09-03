package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;

import java.util.List;
import java.util.Comparator;

public class BloodyRibCageTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:rib_cage_wont_attack")))
						&& !(!world.getEntitiesOfClass(MisanthropicHivemindEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 40, 40, 40), e -> true).isEmpty())
						&& !((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
							.getItem() == TheDeepVoidModItems.BLOODY_RIB_CAGE_CHESTPLATE.get()) {
						if (entityiterator instanceof Mob) {
							try {
								((Mob) entityiterator).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.POISON)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.POISON);
		}
		if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MobEffects.CONFUSION)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.CONFUSION);
		}
	}
}
