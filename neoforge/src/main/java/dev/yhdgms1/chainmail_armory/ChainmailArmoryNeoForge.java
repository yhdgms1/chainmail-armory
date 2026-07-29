package dev.yhdgms1.chainmail_armory;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class ChainmailArmoryNeoForge {
    public ChainmailArmoryNeoForge(IEventBus modEventBus) {
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        event.register(Registries.ITEM, registry ->
                registry.register(
                        ChainmailArmoryCommon.CHAINMAIL_PLATE_KEY.identifier(),
                        ChainmailArmoryCommon.CHAINMAIL_PLATE
                )
        );

        event.register(Registries.CREATIVE_MODE_TAB, registry ->
                registry.register(
                        ChainmailArmoryCommon.id("creative_tab"),
                        CreativeModeTab.builder()
                                .icon(() -> new ItemStack(ChainmailArmoryCommon.CHAINMAIL_PLATE))
                                .title(Component.translatable("creativeTab.chainmail_armory"))
                                .displayItems((params, output) ->
                                        output.accept(ChainmailArmoryCommon.CHAINMAIL_PLATE))
                                .build()
                )
        );
    }
}
