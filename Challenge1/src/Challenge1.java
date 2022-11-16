import java.util.Iterator;

public class Challenge1 {

	public static void main(String[] args) {		
		System.out.println(OrderText(returnText("TipoA"), "Asc"));
	}

	
	public static String returnText (String tipe) {
		String character = "";
		if(tipe == "TipoA") {
			character= "54";
			for (int i = 0; i < 8; i++) {
				character= character+ (int) (Math.random()*10) ;	
			}
			
		}else {
			if(tipe == "TipoB") {
				character= "08";
				for (int i = 0; i < 8; i++) {
					character= character + (int) (Math.random()*10) ;	
				}
			}
		}
		
		
		return character;
	}
	public static String OrderText (String numbers, String order) {
	    System.out.println(numbers);
		String [] array = new String[10];
	    String answer = "";
	    for (int i = 0; i < array.length; i++) {
			array[i] = numbers.charAt(i)+"";
		}
	    if(order == "Asc") {
	    	for (int i = 0; i < array.length; i++) {
				for (int j = i; j < array.length; j++) {
					if(Integer.parseInt(array[i]) > Integer.parseInt(array[j])) {
						String aux = array[i];
						array [i] = array[j];
						array[j]= aux;
					}
				
				}
			}
	    }else {
	    	if(order=="Desc") {
	    		for (int i = 0; i < array.length; i++) {
					for (int j = i; j < array.length; j++) {
						if(Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
							String aux = array[i];
							array [i] = array[j];
							array[j]= aux;
						}
					
					}
				}
	    	}
	    	
	    }
		for (int i = 0; i < array.length; i++) {
			answer = answer+array[i];
		}
		
		return answer;
	}
}
