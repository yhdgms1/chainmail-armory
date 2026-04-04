package dev.yhdgms1.chainmail_armory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ChainmailArmory implements ModInitializer {
	public static final String MOD_ID = "chainmail_armory";

	private static final ResourceKey<Item> CHAINMAIL_PLATE_KEY = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChainmailArmory.MOD_ID, "chainmail_plate"));
	private static final ResourceKey<CreativeModeTab> CREATIVE_MODE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(ChainmailArmory.MOD_ID, "creative_tab"));

	public static final Item CHAINMAIL_PLATE = new Item(new Item.Properties().setId(CHAINMAIL_PLATE_KEY));
	public static final CreativeModeTab CREATIVE_MODE_TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(CHAINMAIL_PLATE))
			.title(Component.translatable("creativeTab.chainmail_armory"))
			.displayItems((params, output) -> {
				output.accept(CHAINMAIL_PLATE);
			})
			.build();

	@Override
	public void onInitialize() {
		Registry.register(BuiltInRegistries.ITEM, CHAINMAIL_PLATE_KEY, CHAINMAIL_PLATE);
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_MODE_TAB_KEY, CREATIVE_MODE_TAB);
	}
}