package tablica;

public class PorownywaczPara2<S,T> implements Porownywacz<Para<S,T>>{
	private Porownywacz<S> p1;
	private Porownywacz<T> p2;
	
	public boolean porownaj (Para<S,T> a, Para<S,T> b){
		if (p2.porownaj(a.drugi, b.drugi)) return true;
		else if (!p2.porownaj(a.drugi, b.drugi) && !p2.porownaj(b.drugi, a.drugi)) // przypadek gdy a.drugi = b.drugi
		{
			if (p1.porownaj(a.pierwszy, b.pierwszy)) return true;
		}
	    return false;
	}

	public PorownywaczPara2(Porownywacz<S> p1, Porownywacz<T> p2){
		this.p1 = p1;
		this.p2 = p2;
	}
}
