package com.speedphoenix.Display;
import com.speedphoenix.Modele.*;
public class Position {
    
    public static final String ECOLE="ecole";
    public static final String CLASSES=  "Classes";
    public static final String TRIMESTRES ="Trimestres";
    public static final String ETUDIANTS ="Eleves";
    public static final String ENSEIGNANTS ="Enseignants";
    public static final String DISCIPLINES="Disciplines";
    public static final String BULLETINS="Bulletins";
    public static final String ETUDIANT="Etudiant";
    public static final String ENSEIGNANT="Enseignant";
    public static final String BULLETIN="Bulletin";
    //utilise en cas si position est ETUDIANT ENSEIGNANT OU BULLETEN pour savoir quest ce que tu veux modifier dans ta base des donnees
    public Eleve eleveChoisie;
    public Enseignant enseignantChoisie;
    public Bulletin bulletinChoisie;
}
