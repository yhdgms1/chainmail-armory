package dev.yhdgms1.chainmail_armory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ChainmailArmory implements ModInitializer {
    public static final Item CHAINMAIL_PLATE = new Item(new Item.Settings());

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CHAINMAIL_PLATE))
            .displayName(Text.translatable("itemGroup.chainmail_armory"))
            .entries((context, entries) -> {
                entries.add(CHAINMAIL_PLATE);
            })
            .build();

    @Override
    public void onInitialize() {
        CommonClass.init();

        Registry.register(Registries.ITEM, id("chainmail_plate"), CHAINMAIL_PLATE);
        Registry.register(Registries.ITEM_GROUP, id("chainmail_armory_tab"), ITEM_GROUP);
    }

    public static Identifier id(String path) {
        return Identifier.of(Constants.MOD_ID, path);
    }
}
