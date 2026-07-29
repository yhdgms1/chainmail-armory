package dev.yhdgms1.chainmail_armory;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public final class ChainmailArmoryCommon {
    public static final ResourceKey<Item> CHAINMAIL_PLATE_KEY = ResourceKey.create(
            Registries.ITEM,
            id("chainmail_plate")
    );

    public static final Item CHAINMAIL_PLATE = new Item(new Item.Properties().setId(CHAINMAIL_PLATE_KEY));

    private ChainmailArmoryCommon() {
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(Constants.MOD_ID, path);
    }

    public static void registerItem() {
        Registry.register(BuiltInRegistries.ITEM, CHAINMAIL_PLATE_KEY, CHAINMAIL_PLATE);
    }
}
