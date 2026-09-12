public class BrawlerClient {
    public static void main(String[] args) {
        BrawlerBuilder builder = new BrawlerBuilder();
        BrawlerDirector director = new BrawlerDirector(builder);

        Brawler shelly = director.constructShelly();
        shelly.greet();

        Brawler bull = director.constructBull();
        bull.greet();

        Brawler cosmo = director.constructCosmo();
        cosmo.greet();
    }
}