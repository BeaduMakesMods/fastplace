package beadu.mm.fastplace_extras.config;

public class FastPlaceConfig {

    public boolean enabled = false;

    public int placeDelay = 0; // slider

    public boolean fastHitEnabled = false;

    public HitSpeedMode hitSpeedMode = HitSpeedMode.FAST;

    public enum HitSpeedMode {
        SLOW,
        AVERAGE,
        FAST,
        BANNABLE
    }
}
