package com.brag.fastplace;

import com.brag.fastplace.mixin.MinecraftClientAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class FastPlace implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client != null && client.player != null) {
                ((MinecraftClientAccessor) client).setItemUseCooldown(0);
            }
        });
    }
}
