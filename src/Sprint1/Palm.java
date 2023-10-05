package Sprint1;

public class Palm extends Plant implements Nutrition {
  private String liquidtype = "Kranvatten";
  private double liquidNeeded = 0.5 * getHeight();
  public Palm (String name, double height){
    super(name, height);

  }

  @Override
  public String getLiquidType() {
    return liquidtype;
  }
  @Override
  public double getLiquidNeeded() {
    return liquidNeeded;
  }
}

