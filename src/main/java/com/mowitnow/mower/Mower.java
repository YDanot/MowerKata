package com.mowitnow.mower;

/*
Le choix de mettre la série d'instruction dans mower est discutable.
Est-ce vraiment au Mower de porter les instructions ?
A mon sens un méthode move avec une instruction en paramètre serait sûrement mieux
 */
public record Mower(Position position, Instructions instructions) {


    public void start() {
        MowerMovement mowerMovement = new MowerMovement(position);
        instructions.launchActions(mowerMovement::doAction);
    }
}
