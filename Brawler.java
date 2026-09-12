public class Brawler {
    private String name;
    private String[] base_attack;
    private String[] super_attack;
    private String[] gadgets;
    private String[] gears;
    private String[] star_powers;
    private String hypercharge;
    private String[] buffies;
    private String[] traits;

    public Brawler(String name, String[] base_attack, String[] super_attack, String[] gadgets, String[] gears, String[] star_powers, String hypercharge, String[] buffies, String[] traits) {
        this.name = name;
        this.base_attack = base_attack;
        this.super_attack = super_attack;
        this.gadgets = gadgets;
        this.gears = gears;
        this.star_powers = star_powers;
        this.hypercharge = hypercharge;
        this.buffies = buffies;
        this.traits = traits;
    }

    public void setHypercharge(String hypercharge) {
        this.hypercharge = hypercharge;
    }

    public void setBuffies(String[] buffies) {
        this.buffies = buffies;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name + "!");
    }
}