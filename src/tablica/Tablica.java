package tablica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

public class Tablica<T> {
	private T [] tablica;
	private int iloscObiektow;
	
	public Tablica(){
		
	}
	
	public Tablica(T [] tablica){
		this.tablica = tablica;
		this.iloscObiektow = tablica.length;
	}

	public void sortowanieBabelkowe (Porownywacz<T> p)
	{
		T obiektPomocniczy;
		boolean czyPosortowane = false;
		
		for(; czyPosortowane == false; )
		{
			czyPosortowane = true;
			for(int j = 0; j < (iloscObiektow - 1); j++)
			{
				if (p.porownaj(this.tablica[j+1], this.tablica[j])) 
				{
					obiektPomocniczy = this.tablica[j];
					this.tablica[j] = this.tablica[j+1];
					this.tablica[j+1] = obiektPomocniczy;
					czyPosortowane = false;
				}
			}
		}
	}
	
	@Override public String toString() //wypisywanie zawartosci tablicy
	{	
		String napisWyjsciowy = "";
		for(int i = 0; i < this.iloscObiektow; i++)
		{
			napisWyjsciowy = napisWyjsciowy + this.tablica[i] + ", ";
		}
		return napisWyjsciowy;
	}
	
	public static void testowanieDzialaniaProgramu() throws IOException
	{		
		Porownywacz<Integer> p1 = new PorownywaczInt();
		Porownywacz<String> p2 = new PorownywaczString();
		Porownywacz<Para<String, Integer>> p3 = new PorownywaczPara1<String, Integer>(p2, p1);
		Porownywacz<Para<String, Integer>> p4 = new PorownywaczPara2<String, Integer>(p2, p1);
		
		Integer [] tab1 = {1, 6, 4, 23, 5, 6, 24, 8, 47, 23, 9, 2};
		String [] tab2 = {"Ala", "ma", "kota", "kot", "ma", "Ale"};
		Para<?, ?> [] tab3 = { new Para<String, Integer>("ghi", 8), new Para<String, Integer>("jkl", 7),
				new Para<String, Integer>("abc", 45), new Para<String, Integer>("def", 7), 
				new Para<String, Integer>("jkl", 34), new Para<String, Integer>("ghi", 2) } ;
		
		Tablica <Integer> tablicaInt = new Tablica <Integer> (tab1);
		Tablica <String> tablicaString = new Tablica <String> (tab2);
		Tablica <Para<String, Integer>> tablicaPar = new Tablica <Para<String, Integer>> (); // konstruktor bezargumentowy zeby ominac problemy zwiazane z tablica sparametryzowana
		
		tablicaPar.tablica = (Para<String, Integer> []) tab3; // ominiecie problemow zwiazanych z tablica sparametryzowana uzywajac rzutowania
		tablicaPar.iloscObiektow = tab3.length;

		char wybor;
		String s;
		BufferedReader wejscie = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println("Testowanie dzialania programu. Nacisnij przycisk 1, 2 lub 3");
			System.out.println("1 ................ Posortuj tablice obiektów typu Integer");
			System.out.println("2 ................ Posortuj tablice obiektów typu String");	
			System.out.println("3 ................ Posortuj tablice par obiektów (String oraz Integer) w kolejnosci rosnacej wzgledem porzadku leksykograficznego Stringu w kazdej parze");	
			System.out.println("4 ................ Posortuj tablice par obiektów (String oraz Integer) w kolejnosci rosnacej wzgledem liczby Integer w kazdej parze");
			System.out.println("5 ................ koniec");	
			s = wejscie.readLine();
			wybor = s.charAt(0);
			switch (wybor)
			{	
			case '1' : 
			{
				System.out.println("Tablica przed sortowaniem");
				System.out.println(tablicaInt);
				tablicaInt.sortowanieBabelkowe(p1);  // sortujemy rosnaco wzgledem wielkosci kazdej liczby
				System.out.println("Tablica po sortowaniu");
				System.out.println(tablicaInt);
				System.out.println();
				
			} break;
			case '2' : 
			{
				System.out.println("Tablica przed sortowaniem");
				System.out.println(tablicaString);     // sortujemy rosnaco wzgledem porzadku leksykograficznego kazdego Stringu
				tablicaString.sortowanieBabelkowe(p2); // podczas porownywania ignorujemy wielkosc liter
				System.out.println("Tablica po sortowaniu");
				System.out.println(tablicaString);
				System.out.println();
				
			} break;
			case '3' : 
			{
				System.out.println("Tablica przed sortowaniem");
				System.out.println(tablicaPar);
				tablicaPar.sortowanieBabelkowe(p3); // sortujemy rosnaco wzgledem porzadku leksykograficznego Stringu w kazdej parze
				System.out.println("Tablica po sortowaniu");
				System.out.println(tablicaPar);
				System.out.println();
				
			} break;
			case '4' : 
			{
				System.out.println("Tablica przed sortowaniem");
				System.out.println(tablicaPar);
				tablicaPar.sortowanieBabelkowe(p4); // sortujemy rosnaco wzgledem liczby Integer w kazdej parze
				System.out.println("Tablica po sortowaniu");
				System.out.println(tablicaPar);
				System.out.println();
				
			} break;
			}
		}	
		while (wybor != '5');
	}	
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Program - Tablica sparametryzowana");
		testowanieDzialaniaProgramu();
	}
}
