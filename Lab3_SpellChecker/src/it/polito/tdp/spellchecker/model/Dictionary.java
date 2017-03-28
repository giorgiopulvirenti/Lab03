package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Dictionary {
//	TreeMap<String,String> dictionary=new TreeMap<String,String>();
	ArrayList<RichWord> rich=new ArrayList<RichWord>();
	LinkedList<String> dictionary=new LinkedList<String>();
	public void loadDictionary(String language){
		
		try {
			FileReader fr = new
			FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
		//	dictionary.put(word,word);
				dictionary.add(word.toLowerCase());
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
	}
	public List<RichWord> spellCheckText(List<String> input){
		String indice="";
		String inizio=dictionary.getFirst();
		String fine=dictionary.getLast();
		String centro=dictionary.get(dictionary.size()/2);
		rich.clear();
		System.out.println(rich.size());
		System.out.println(input);
		for(String s:input){
			System.out.println((inizio+" ").compareTo(fine)+" "+inizio+" "+fine);
			while (indice.compareTo("")==0&&inizio.compareTo(fine)<0){
			
			centro=dictionary.get((dictionary.indexOf(inizio)+dictionary.indexOf(fine))/2);
			System.out.println("AAA "+centro);
			if (centro.compareTo(s)==0){
				indice=s;
				System.out.println(indice+"FFF");
			}
			if (centro.compareTo(s)>0){
				fine=dictionary.get(dictionary.indexOf(centro)-1);
				System.out.println(indice+" "+centro+" "+s+" "+fine+" "+"QQQ");
				System.out.println("OOO "+centro);
			}
			if (centro.compareTo(s)<0){
				inizio=dictionary.get(dictionary.indexOf(centro)+1);
				System.out.println(indice+"LLL");
			}
			System.out.println(inizio+" "+fine+""+inizio.compareTo(fine)+" BBBB");
			}
			if (indice.compareTo("")!=0){
				System.out.println(indice+"FFF");
				rich.add(new RichWord(s,true));
				indice="";
				inizio=dictionary.getFirst();
				fine=dictionary.getLast();
			}
			else{
				rich.add(new RichWord(s,false));
			System.out.println(indice+"GGG");
			indice="";
			 inizio=dictionary.getFirst();
			fine=dictionary.getLast();
			
			}
			}
			
			
			
//			if (this.dictionary.containsKey(s))
//				rich.add(new RichWord(s,true));
//			else rich.add(new RichWord(s,false));
		
				
	return rich;	
	}

}
