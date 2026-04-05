package beadu.mm.fastplace_extras;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class Keybinds {
    public static KeyBinding TOGGLE_FASTPLACE;
    public static KeyBinding TOGGLE_FASTHIT;
    public static KeyBinding OPEN_CONFIG;

    private static final KeyBinding.Category CATEGORY =
            new KeyBinding.Category(Identifier.of("fastplace", "category"));

    public static void register() {
        TOGGLE_FASTPLACE = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fastplace.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                CATEGORY
        ));
        TOGGLE_FASTHIT = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fasthit.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                CATEGORY
        ));
        OPEN_CONFIG = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fastplace.config",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                CATEGORY
        ));
    }
}