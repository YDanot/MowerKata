package com.mowitnow.mower;

/*
Que représente cette classe ?
L'environnemnt probablement,
il faurait trouver un nommage plus clair car Program est beaucoup trop générique.
Pourquoi pas Environment ou Garden puisque tu as GardenDimension en attribut?
 */
public record Program(GardenDimension dimensionGarden, Mowers mowers) {

    // On est sur de vouloir identifier un mower via son index dans com.mowitnow.mower.Mowers ?
    public Position getMowerPosition(int index) {
        return mowers.getMoverPositionBy(index);
    }

    // Methode jamais utilisée => a supprimer
    public Instructions getMowerInstructions(int index) {
        return mowers.getInstructionBy(index);
    }

    public void start() {
        mowers.start();
    }
}
