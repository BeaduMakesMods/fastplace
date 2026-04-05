package beadu.mm.fastplace_extras;

import beadu.mm.fastplace_extras.config.FastPlaceConfig;
import beadu.mm.fastplace_extras.config.FastPlaceConfigScreen;
import beadu.mm.fastplace_extras.hud.FastPlaceHud;
import beadu.mm.fastplace_extras.mixin.MinecraftClientAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class FastPlace implements ClientModInitializer {

    public static final FastPlaceConfig CONFIG = new FastPlaceConfig();

    @Override
    public void onInitializeClient() {
        Keybinds.register();
        FastPlaceHud.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            while (Keybinds.TOGGLE_FASTPLACE.wasPressed()) {
                CONFIG.enabled = !CONFIG.enabled; // toggle fast place on/off
            }

            while (Keybinds.TOGGLE_FASTHIT.wasPressed()) {
                CONFIG.fastHitEnabled = !CONFIG.fastHitEnabled; // toggle fast hit on/off
            }

            while (Keybinds.OPEN_CONFIG.wasPressed()) {
                client.setScreen(FastPlaceConfigScreen.create(null, CONFIG)); // open config screen
            }

            if (CONFIG.enabled && client instanceof MinecraftClientAccessor accessor) {
                int current = accessor.getItemUseCooldown();

                if (current > CONFIG.placeDelay) {
                    accessor.setItemUseCooldown(CONFIG.placeDelay);
                }
            }
        });
    }
}