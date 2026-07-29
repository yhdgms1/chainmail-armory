package dev.yhdgms1.chainmail_armory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ChainmailArmoryFabric implements ModInitializer {
    private static final ResourceKey<CreativeModeTab> CREATIVE_MODE_TAB_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            ChainmailArmoryCommon.id("creative_tab")
    );

    public static final CreativeModeTab CREATIVE_MODE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ChainmailArmoryCommon.CHAINMAIL_PLATE))
            .title(Component.translatable("creativeTab.chainmail_armory"))
            .displayItems((params, output) -> output.accept(ChainmailArmoryCommon.CHAINMAIL_PLATE))
            .build();

    @Override
    public void onInitialize() {
        ChainmailArmoryCommon.registerItem();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_MODE_TAB_KEY, CREATIVE_MODE_TAB);
    }
}
