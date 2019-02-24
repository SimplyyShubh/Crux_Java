package Lecture19;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.add("art");
		trie.add("arts");
		trie.add("bug");
		trie.add("boy");
		trie.add("see");
		trie.add("sea");
		trie.add("seen");
		//trie.displayAll("ar");
		trie.display();
		System.out.println(trie.search("artist"));
		System.out.println("********************");
		trie.remove("art");
		trie.display();
		System.out.println("********************");
		trie.remove("arts");
		trie.display();	
		System.out.println(patternSearch("codeblocks", "blocks"));
	}
	
	public static int patternSearch(String src,String pat){
		for(int i=0;i<=src.length()-pat.length();i++){
			int j=0;
			for(j=0;j<pat.length();j++){
				if(pat.charAt(j)!=src.charAt(i+j)){
					break;
				}
			}
			if(j==pat.length()){
				return i;
			}
		}
		return -1;
	}

}
