package Sprint1;

public class Carnivore extends Plant implements Nutrition{
    private String liquidType = "Proteindryck";
    private double liquidNeeded = 0.1 + 0.2 * getHeight();
    public Carnivore(String name, double height){
        super(name, height);
    }


    @Override
    public double getLiquidNeeded() {
        return liquidNeeded;
    }


    @Override
    public String getLiquidType() {
        return liquidType;
    }

}
