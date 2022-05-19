package com.mowitnow.mower;

import java.util.Optional;
import java.util.stream.Stream;

/* Ici tu lies une instruction à sa représentation dans le fichier
 * Imagine que tu es plusieurs moyen de donner des instructions à ton mower
 * via fichier d'instructions ou via autre chose ? tu serais coincer.
 * D'un point de vue général il vaut mieux séparer
 * la représentation d'une entrée ou sortie de ton programme du model métier
 */
public enum Instruction {
    LEFT("G"),
    RIGHT("D"),
    FORWARD("A");

    private final String action;

    Instruction(String action) {
        this.action = action;
    }

    public static Optional<Instruction> of(String commandRaw) {
        return Stream.of(values())
                .filter(command -> command.getAction().equals(commandRaw))
                .findFirst();
    }

    public String getAction() {
        return action;
    }

}
