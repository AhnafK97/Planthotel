package Sprint1;

import javax.swing.*;

public class Planthotel {
    public static void main(String[] args) {


        String selectedPlantName = JOptionPane.showInputDialog(null, " Igge (Cactus) " + "\n Olof (Palm) " + "\n Laura (Palm) " + "\n Meatloaf (Carnivore) " + "\nVilken växt ska få mat?");
        if (selectedPlantName != null) {
            Plant selectedPlant = null;

            // Skapa växtobjekt baserat på användarens inmatning
            switch (selectedPlantName.toLowerCase()) {
                case "igge":
                    selectedPlant = new Cactus("Igge", 0.2);
                    break;
                case "olof":
                    selectedPlant = new Palm("Olof", 1);
                    break;
                case "laura":
                    selectedPlant = new Palm("Laura", 5);
                    break;
                case "meatloaf":
                    selectedPlant = new Carnivore("Meatloaf", 0.7);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Okänd växt.");
            }

            if (selectedPlant != null) {
                selectedPlant.calculateNutrition(selectedPlant);
            }
        }



            }
        }
