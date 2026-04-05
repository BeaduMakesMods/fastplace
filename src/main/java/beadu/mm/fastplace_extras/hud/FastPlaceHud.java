package beadu.mm.fastplace_extras.hud;

import beadu.mm.fastplace_extras.FastPlace;
import beadu.mm.fastplace_extras.config.FastPlaceConfig;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FastPlaceHud {

    public static void register() {
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.of("fastplace", "hud"),
                FastPlaceHud::render
        );
    }

    private static void render(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        FastPlaceConfig config = FastPlace.CONFIG;

        int x = 6;
        int y = 6;

        if (config.enabled) {
            context.drawText(
                    client.textRenderer,
                    Text.literal("FastPlace: Enabled"),
                    x, y,
                    0xFF00FF00, // ARGB - note the FF alpha prefix
                    true
            );
            y += 10;
        }

        if (config.fastHitEnabled) {
            context.drawText(
                    client.textRenderer,
                    Text.literal("FastHit: " + config.hitSpeedMode.name()),
                    x, y,
                    0xFFFF5555, // ARGB
                    true
            );
        }
    }
}