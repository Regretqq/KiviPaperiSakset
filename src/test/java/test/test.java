package test;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class test {

    @Test
    public void testaaPelaajanLuonti(){
        Pelaaja p = new Pelaaja();
        assertEquals(0, p.getVoitot());
    }

    @Test
    public void pelaajanVoitonLisääminen(){
        Pelaaja p = new Pelaaja();
        p.lisääVoitto();
        assertEquals(1, p.getVoitot());
    }

    @Test
    public void PelaajanValinnanArpominen(){
        Pelaaja p = new Pelaaja();
        p.pelaajanValinta();
        assertThat(p.getValinta(), Matchers.anyOf(is("kivi"), is("sakset"), is("paperi")));
    }

    @Test
    public void pelinAlustaminen(){
        Peli peli = new Peli();
        peli.alusta();
        assertEquals(false, peli.getPeliLoppui());
    }

    @Test
    public void pelinLäpikäynti(){
        Peli peli = new Peli();
        peli.pelaa();
        assertEquals(true, peli.getPeliLoppui());
    }
}
