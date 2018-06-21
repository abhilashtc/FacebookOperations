package com.facebook.features;

public class PrintNonExistantChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "McAfee";
		String str2 = "TechCheff";
		String str3 = "";
		
		str3 = getNonExistChar(str1, str2);
		System.out.println("Non Existant Characters in " + str1 + " over " + str2 + " is " + str3);
		
		str3 = getNonExistChar(str2, str1);
		System.out.println("Non Existant Characters in " + str2 + " over " + str1 + " is " + str3);
		

	}
	
	private static String getNonExistChar(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		String str3 = "";
		
		for(int i=0; i<l1; i++) {
			String ch1 = str1.substring(i, i+1);
			for(int j=0; j<l2; j++) {
				String ch2 = str2.substring(j, j+1);
				if(ch2.equals(ch1)) 
					break;
				else if(j == l2-1){
					str3 = str3 + ch1;
					break;
				}
			}
		}
		return str3;
	}
}
