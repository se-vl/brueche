package brueche;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class BruchTest
{
    private final Bruch dreiViertel = Bruch.select(3, 4);
    private final Bruch einHalb = Bruch.select(1, 2);
    private final Bruch fünfSechstel = Bruch.select(5, 6);

    @Test
    public void konstruktorUndGetter()
    {
        assertEquals(3, dreiViertel.gibZähler());
        assertEquals(4, dreiViertel.gibNenner());
    }

    @Test
    public void testToString()
    {
        assertEquals("3 / 4", dreiViertel.toString());
    }

    @Test
    public void multiplikation()
    {
        assertEquals(Bruch.select(3, 8), dreiViertel.mal(einHalb));
    }

    @Test
    public void multiplikationGekürzt()
    {
        assertEquals(Bruch.select(5, 8), dreiViertel.mal(fünfSechstel));
    }

    @Test
    public void addition()
    {
        assertEquals(Bruch.select(38, 24), dreiViertel.plus(fünfSechstel));
    }

    @Test
    public void hashSetEnthältEingefügtenBruch()
    {
        HashSet<Bruch> brueche = new HashSet<Bruch>();
        brueche.add(Bruch.select(22, 7));
        assertTrue(brueche.contains(Bruch.select(22, 7)));
    }

    @Test
    public void dasEnthalteneElementGleichtDemEingefügten()
    {
        HashSet<Bruch> brueche = new HashSet<Bruch>();
        brueche.add(Bruch.select(22, 7));
        for (Bruch bruch : brueche)
        {
            assertEquals(Bruch.select(22, 7), bruch);
        }
    }
}
