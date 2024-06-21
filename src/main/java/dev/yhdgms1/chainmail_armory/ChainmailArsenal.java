package dev.yhdgms1.chainmail_armory;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ChainmailArsenal.MODID)
public class ChainmailArsenal
{
    public static final String MODID = "chainmail_armory";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredItem<Item> CHAINMAIL_PLATE_ITEM = ITEMS.registerSimpleItem("chainmail_plate", new Item.Properties());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHAINMAIL_ARMORY_TAB = CREATIVE_MODE_TABS.register("chainmail_armory_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chainmail_armory"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> CHAINMAIL_PLATE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CHAINMAIL_PLATE_ITEM.get());
            }).build());

    public ChainmailArsenal(IEventBus modEventBus, ModContainer modContainer)
    {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
