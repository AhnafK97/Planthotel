package Sprint1;

import javax.swing.*;

abstract class Plant implements Nutrition {
    private String name;
    private double height;

    public Plant(String name, double height){
        this.name = name;
        this.height = height;

    }

    public String getName(){
        return name;
    }

    public double getHeight(){
        return height;
    }

    public void calculateNutrition(Nutrition n) {
        double nutritionNeeded = getLiquidNeeded();
        String liquidType = n.getLiquidType();
        String message = getName() + " behöver " + nutritionNeeded + " liter " + liquidType + " per dag.";
        JOptionPane.showMessageDialog(null, message);
    }




}

