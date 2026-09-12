public class BrawlerDirector {
    private BrawlerBuilder builder;

    public BrawlerDirector(BrawlerBuilder builder) {
        this.builder = builder;
    }

    public Brawler constructShelly() {
        return builder.name("Shelly")
                .base_attack(new String[]{"Buckshot"})
                .super_attack(new String[]{"Super Shell"})
                .gadgets(new String[]{"Fast Forward", "Clay Pigeons"})
                .gears(new String[]{"Speed", "Vision", "Health", "Shield", "Damage", "Gadget Cooldown"})
                .star_powers(new String[]{"Shell Shock", "Band-Aid"})
                .hypercharge("Double Barrel")
                .buffies(new String[]{"Gadget Buffie", "Starr Buffie", "Hyper Buffie"});
    }

    public Brawler constructBull() {
        return builder.name("Bull")
                .base_attack(new String[]{"Double-Barrel"})
                .super_attack(new String[]{"Bulldozer"})
                .gadgets(new String[]{"T-Bone Missle", "Stomper"})
                .gears(new String[]{"Speed", "Vision", "Health", "Shield", "Damage", "Gadget Cooldown"})
                .star_powers(new String[]{"Berserker", "Tough Guy"})
                .hypercharge("Jaws of Steel")
                .buffies(new String[]{"Gadget Buffie", "Starr Buffie", "Hyper Buffie"})
                .traits(new String[]{"Tank Trait"});
    }

    public Brawler constructCosmo() {
        return builder.name("Cosmo")
                .base_attack(new String[]{"Orbit"})
                .super_attack(new String[]{"Gravitational Pull"})
                .gadgets(new String[]{"Planetary Pushback", "Telescope Trap"})
                .gears(new String[]{"Speed", "Vision", "Health", "Shield", "Damage", "Gadget Cooldown"})
                .star_powers(new String[]{"Precession", "Ammo Attraction"});
    }
}