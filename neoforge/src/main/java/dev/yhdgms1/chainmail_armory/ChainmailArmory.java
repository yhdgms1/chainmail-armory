package dev.yhdgms1.chainmail_armory;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Constants.MOD_ID)
public class ChainmailArmory {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final DeferredItem<Item> CHAINMAIL_PLATE_ITEM = ITEMS.registerSimpleItem("chainmail_plate", new Item.Properties());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHAINMAIL_ARMORY_TAB = CREATIVE_MODE_TABS.register("chainmail_armory_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chainmail_armory"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> CHAINMAIL_PLATE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CHAINMAIL_PLATE_ITEM.get());
            }).build());

    public ChainmailArmory(IEventBus eventBus) {
        CommonClass.init();

        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);

    }
}