package beadu.mm.fastplace_extras.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class FastPlaceConfigScreen {

    public static Screen create(Screen parent, FastPlaceConfig config) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("FastPlace"));

        ConfigCategory general = builder.getOrCreateCategory(Text.literal("General"));

        general.addEntry(builder.entryBuilder()
                .startBooleanToggle(Text.literal("Enabled"), config.enabled)
                .setSaveConsumer(val -> config.enabled = val)
                .build());

        general.addEntry(builder.entryBuilder()
                .startIntSlider(Text.literal("Place Delay"), config.placeDelay, 0, 10)
                .setSaveConsumer(val -> config.placeDelay = val)
                .build());

        general.addEntry(builder.entryBuilder()
                .startBooleanToggle(Text.literal("Fast Hit"), config.fastHitEnabled)
                .setSaveConsumer(val -> config.fastHitEnabled = val)
                .build());

        general.addEntry(builder.entryBuilder()
                .startEnumSelector(
                        Text.literal("Hit Speed"),
                        FastPlaceConfig.HitSpeedMode.class,
                        config.hitSpeedMode
                )
                .setSaveConsumer(val -> config.hitSpeedMode = val)
                .build());

        return builder.build();
    }
}
