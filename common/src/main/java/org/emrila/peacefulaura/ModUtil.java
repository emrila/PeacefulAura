package org.emrila.peacefulaura;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import org.emrila.peacefulaura.food.ModFoods;
import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import java.util.Objects;

public class ModUtil {

    public static final Identifier EFFECT_ID = ModUtil.id("peaceful_aura");
    public static final Identifier POTION_ID = ModUtil.id("peaceful_aura");
    public static final Identifier POTION_LONG_ID = ModUtil.id("long_peaceful_aura");
    public static final Identifier BAKED_POISONOUS_POTATO_ID = ModUtil.id("baked_poisonous_potato");

    public static Item createFoodItem(ResourceKey<Item> key) {
        return new Item(ModUtil.createFoodItemProperties(new Item.Properties()).setId(key));
    }

    public static Item.Properties createFoodItemProperties(Item.Properties properties) {
        return properties.food(ModFoods.GRILLED_POISONOUS_POTATO, ModFoods.GRILLED_POISONOUS_POTATO_CONSUMABLE);
    }

    public static Potion constructPotion(boolean isLong) {
        Holder<MobEffect> effectHolder = getHolderForEffect();
        int duration = isLong ? 9600 : 3600;
        return new Potion(POTION_ID.getPath(), new MobEffectInstance(effectHolder, duration));
    }

    public static Holder<MobEffect> getHolderForEffect() {
        return getHolderForEffect(ModUtil.EFFECT_ID);
    }

    public static Holder<MobEffect> getHolderForEffect(Identifier id) {
        MobEffect effect = Objects.requireNonNull(BuiltInRegistries.MOB_EFFECT.getValue(id));
        return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(effect);
    }

    public static Item getItem(Identifier id) {
        return BuiltInRegistries.ITEM.getValue(id);
    }

    public static Holder<Potion> getHolderForPotion(Identifier id) {
        Potion potion = Objects.requireNonNull(BuiltInRegistries.POTION.getValue(id));
        return BuiltInRegistries.POTION.wrapAsHolder(potion);
    }

    @Contract("_ -> new")
    public static @NonNull Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(ModConstants.MOD_ID, path);
    }

}
