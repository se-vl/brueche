package brueche;

public class Bruch
{
    private final int _zähler;
    private final int _nenner;

    private static int größterGemeinsamerTeiler(int a, int b)
    {
        // Algorithmus von Euklid
        if (b == 0)
        {
            return a;
        }
        else
        {
            return größterGemeinsamerTeiler(b, a % b);
        }
    }

    private Bruch(int zähler, int nenner)
    {
        int ggt = größterGemeinsamerTeiler(zähler, nenner);
        _zähler = zähler / ggt;
        _nenner = nenner / ggt;
    }

    public static Bruch select(int zähler, int nenner)
    {
        return new Bruch(zähler, nenner);
    }

    public int gibZähler()
    {
        return _zähler;
    }

    public int gibNenner()
    {
        return _nenner;
    }

    @Override
    public String toString()
    {
        return _zähler + " / " + _nenner;
    }

    public Bruch mal(Bruch that)
    {
        int z = this._zähler * that._zähler;
        int n = this._nenner * that._nenner;
        return Bruch.select(z, n);
    }

    public Bruch plus(Bruch that)
    {
        int z = this._zähler * that._nenner + this._nenner * that._zähler;
        int n = this._nenner * that._nenner;
        return Bruch.select(z, n);
    }

    // Wenn a.equals(b) gilt, dann muss a.hashCode() == b.hashCode() gelten
    public boolean equals(Object obj)
    {
        // Typtest
        if (obj instanceof Bruch)
        {
            // Typzusicherung
            Bruch that = (Bruch) obj;

            return this._zähler == that._zähler && this._nenner == that._nenner;
        }
        return false;
    }

    public int hashCode()
    {
        return _zähler * 31 + _nenner;
    }
}
