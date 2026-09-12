public class BrawlerBuilder {
    private String name;
    private String[] base_attack;
    private String[] super_attack;
    private String[] gadgets;
    private String[] gears;
    private String[] star_powers;
    private String hypercharge;
    private String[] traits;

    public BrawlerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BrawlerBuilder base_attack(String[] base_attack) {
        this.base_attack = base_attack;
        return this;
    }

    public BrawlerBuilder super_attack(String[] super_attack) {
        this.super_attack = super_attack;
        return this;
    }

    public BrawlerBuilder gadgets(String[] gadgets) {
        this.gadgets = gadgets;
        return this;
    }

    public BrawlerBuilder gears(String[] gears) {
        this.gears = gears;
        return this;
    }

    public BrawlerBuilder star_powers(String[] star_powers) {
        this.star_powers = star_powers;
        return this;
    }

    public BrawlerBuilder hypercharge(String hypercharge) {
        this.hypercharge = hypercharge;
        return this;
    }

    public BrawlerBuilder buffies(String[] buffies) {
        this.buffies = buffies;
        return this;
    }

    public BrawlerBuilder traits(String[] traits) {
        this.traits = traits;
        return this;
    }

    public Brawler build() {
        if (name is null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (base_attack is null || base_attack.length == 0) {
            throw new IllegalArgumentException("Base attack cannot be null or empty");
        }

        if (super_attack is null || super_attack.length == 0) {
            throw new IllegalArgumentException("Super attack cannot be null or empty");
        }

        if (gadgets is null || gadgets.length != 2) {
            throw new IllegalArgumentException("Gadgets cannot be null and must have exactly 2 elements");
        }

        if (gears is null || gears.length != 6) {
            throw new IllegalArgumentException("Gears cannot be null and must have exactly 6 elements");
        }

        if (star_powers is null || star_powers.length != 2) {
            throw new IllegalArgumentException("Star powers cannot be null and must have exactly 2 elements");
        }

        return new Brawler(name, base_attack, super_attack, gadgets, gears, star_powers, hypercharge, buffies, traits);
    }
}