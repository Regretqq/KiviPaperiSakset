package kivipaperisakset;

/**
 *  Pelin läpikäynnistä vastaava luokka
 * @author Ira Dook
 */
public class Peli {
    private Pelaaja p1;
    private Pelaaja p2;
    private int tasapelit;
    private int pelatutPelit;
    private boolean peliLoppui;

    /**
     * Pelin läpikäynnistä vastaava metodi
     */
    public void pelaa() {
        alusta();
        do {
            p1.pelaajanValinta();
            p2.pelaajanValinta();
            printInfos();
            switch(tarkistaVoittaja()){
                case 0:
                    tasapelit++;
                    System.out.println("\n\t\t\t Tasapeli \n");
                    break;
                case 1:
                    p1.lisääVoitto();
                    System.out.println("\n\t\t\t Pelaaja 1 voittaa\n");
                    break;
                case 2:
                    p2.lisääVoitto();
                    System.out.println("\n\t\t\t Pelaaja 2 voittaa\n");
                    break;
            }
            pelatutPelit++;
            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
        } while (peliLoppui != true);
    }

    /**
     * tulostaa pelin tilanteen kierrosten välillä
     */
    public void printInfos(){
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
        System.out.println("Pelaaja 1: " + p1.getValinta()
                + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2.getValinta()
                + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
    }

    /**
     * Alustaa kaikki arvot jotta peli voidaan aloittaa
     */
    public void alusta(){
        p1 = new Pelaaja();
        p2 = new Pelaaja();
        pelatutPelit = 0;
        tasapelit = 0;
        peliLoppui = false;
    }

    /**
     * tarkistaa kumpi pelaaja voittaa heidän valintojen perusteella:
     * 0 = tasapeli,
     * 1 = pelaaja 1 voitti,
     * 2 = pelaaja 2 voitti
     * @return kierroksen voittaja
     */
    public int tarkistaVoittaja(){
        if(p1.getValinta().equals("kivi")) {
            if (p2.getValinta().equals("sakset")) {
                return 1;
            } else if (p2.getValinta().equals("paperi")) {
                return 2;
            }
        }else if(p1.getValinta().equals("sakset")) {
            if (p2.getValinta().equals("paperi")) {
                return 1;
            } else if (p2.getValinta().equals("kivi")) {
                return 2;
            }
        }else if(p1.getValinta().equals("paperi")) {
            if(p2.getValinta().equals("kivi")){
                return 1;
            }
            else if(p2.getValinta().equals("sakset")) {
                return 2;
            }
        }
        return 0;
    }

    public boolean getPeliLoppui(){
        return peliLoppui;
    }
}
