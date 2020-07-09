package tablica;

public class PorownywaczPara1<S,T> implements Porownywacz<Para<S,T>> {
	private Porownywacz<S> p1;
	private Porownywacz<T> p2;
	
	public boolean porownaj (Para<S,T> a, Para<S,T> b){
		if (p1.porownaj(a.pierwszy, b.pierwszy)) return true;
		else if (!p1.porownaj(a.pierwszy, b.pierwszy) && !p1.porownaj(b.pierwszy, a.pierwszy)) // przypadek gdy a.pierwszy = b.pierwszy
		{
			if (p2.porownaj(a.drugi, b.drugi)) return true;
		}
		return false;
	}

	public PorownywaczPara1(Porownywacz<S> p1, Porownywacz<T> p2){
		this.p1 = p1;
		this.p2 = p2;
	}
}
