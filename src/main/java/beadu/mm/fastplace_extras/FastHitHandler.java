package beadu.mm.fastplace_extras;

import beadu.mm.fastplace_extras.config.FastPlaceConfig;
import beadu.mm.fastplace_extras.mixin.MinecraftClientInvoker;
import net.minecraft.client.MinecraftClient;

import java.util.Random;

public class FastHitHandler {

    private static final Random RANDOM = new Random();
    private static long lastHitTime = 0;

    public static void tick(MinecraftClient client, FastPlaceConfig config) {
        if (!config.fastHitEnabled) return;
        if (!client.options.attackKey.isPressed()) return;
        if (client.player == null) return;

        int cps = getCps(config, client);
        long delayMs = 1000L / cps;

        long now = System.currentTimeMillis();
        if (now - lastHitTime < delayMs) return;

        ((MinecraftClientInvoker) client).invokeDoAttack();
        lastHitTime = now;
    }

    private static int getCps(FastPlaceConfig config, MinecraftClient client) {
        int min, max;

        switch (config.hitSpeedMode) {
            case SLOW -> { min = 2; max = 6; }
            case FAST -> { min = 9; max = 12; }
            case BANNABLE -> { min = 15; max = 18; }
            default -> { min = 6; max = 8; }
        }

        if (client.player.getMainHandStack().isIn(net.minecraft.registry.tag.ItemTags.SWORDS)) {
            // sword logic
        } else if (client.player.getMainHandStack().isIn(net.minecraft.registry.tag.ItemTags.AXES)) {
            // axe logic
        }

        return RANDOM.nextInt(max - min + 1) + min;
    }
}
