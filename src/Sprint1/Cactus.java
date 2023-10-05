package Sprint1;

public class Cactus extends Plant implements Nutrition {

    public Cactus(String name, double height){
        super(name, height);
    }

    double liquidNeeded = 0.02;

    @Override
    public double getLiquidNeeded() {
        return liquidNeeded;
    }

    String liquidType = "Mineralvatten";

    @Override
    public String getLiquidType() {
        return liquidType;
    }
}

