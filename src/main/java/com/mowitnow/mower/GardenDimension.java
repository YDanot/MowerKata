package com.mowitnow.mower;

/*
Tu peux avoir n'importe quelle taille de Garden ?
Qu'en est-il des X:Y négatifs ?
Il faudrait mieux wrapper tes int dans un record nommé Dimension par exemple
qui aurait comme responsabilité de valider que l'entier soit positif
Ou a minima valider ici dans un constructeur la validité des limitX et limitY
 */
public record GardenDimension(int limitX, int limitY) {

}
