package tablica;

public class Para<S,T>{
	S pierwszy;
	T drugi;
	
	public Para(S s, T t){
		this.pierwszy = s;
		this.drugi = t;
	}
	
	@Override public String toString() {
		return "(" + this.pierwszy + ", " + this.drugi + ")";
	}
}
