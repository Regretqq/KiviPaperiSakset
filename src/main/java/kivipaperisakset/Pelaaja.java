
package kivipaperisakset;

/**
 * Pelaaja luokka sisältää tietoa pelaajana valinnasta pelisää sekä voittojen määrän
 * @author Ira Dook
 */
public class Pelaaja {

    private int voitot;      // Voittojen lukumäärä
    private String valinta;


    public Pelaaja(){
        voitot = 0;
    }

    /**
     * Valistee arpomalla pelajan valinnnan.
     */
    public void pelaajanValinta() {
        valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }

    }

    /**
     * palauttaa pelaajan valinnan
     * @return pelaajan valinta
     */
    public String getValinta(){
        return valinta;
    }

    /**
     * Lisää voiton pelaajan voittoihin
     */
    public void lisääVoitto(){
        voitot++;
    }

    /**
     * palauttaa pelaajan voitot
     * @return pelaajan voitot
     */
    public int getVoitot() {
        return (voitot);
    }
}
