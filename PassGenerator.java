package miniprojects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PassGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String symbols = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
		String allChar = "";
		int passlength=0;
		boolean ps = true;
		while(ps == true) {
			System.out.println("Enter Password length between 8-15");
			passlength = sc.nextInt();
			if(passlength<8 || passlength>15) {
				System.out.println("Invalid length!");
				ps = true;
			}else {
				ps = false;
			}
		}

		
		boolean uppcase=false,lowcase=false,dig=false,sym=false;
		
		System.out.println("Include uppercase letters? (Y/N):");
		char u = sc.next().toUpperCase().charAt(0);
		
		if(u == 'Y') {
			uppcase = true;
		}else if(u == 'N'){
			uppcase = false;
		}else {
		    System.out.println("Invalid Selection! Defaulting to NO.");
		    uppcase = false;
		}
		
		System.out.println("Include lowercase letters? (Y/N):");
		char l = sc.next().toUpperCase().charAt(0);
		if(l == 'Y') {
			lowcase = true;
		}else if(l == 'N'){
			lowcase = false;
		}else {
		    System.out.println("Invalid Selection! Defaulting to NO.");
		    lowcase = false;
		}
		
		System.out.println("Include digits? (Y/N):");
		char d = sc.next().toUpperCase().charAt(0);
		if(d == 'Y') {
			dig = true;
		}else if(d == 'N'){
			dig = false;
		}else {
		    System.out.println("Invalid Selection! Defaulting to NO.");
		    dig = false;
		}
		
		System.out.println("Include symbols? (Y/N):");
		char s = sc.next().toUpperCase().charAt(0);
		if(s == 'Y') {
			sym = true;
		}else if(s == 'N'){
			sym = false;
		}else {
		    System.out.println("Invalid Selection! Defaulting to NO.");
		    sym = false; 
		}
		
		StringBuilder password = new StringBuilder();
		Random rand = new Random();
		
		if(uppcase == true ) {
			allChar += uppercase;
			password.append(uppercase.charAt(rand.nextInt(uppercase.length())));
		}
		if(lowcase == true) {
			allChar += lowercase;
			password.append(lowercase.charAt(rand.nextInt(lowercase.length())));
		}
		if(dig == true) {
			allChar += digits;
			password.append(digits.charAt(rand.nextInt(digits.length())));
		}
		if(sym == true) {
			allChar += symbols;
			password.append(symbols.charAt(rand.nextInt(symbols.length())));
		}
		if (allChar.isEmpty()) {
		    System.out.println("No character types selected. Cannot generate password.");
		    return;
		}
		
		
		
		for(int i=password.length();i<passlength;i++) {
			char randchar = allChar.charAt(rand.nextInt(allChar.length()));
			password.append(randchar);
		}
		
		List<Character> passchar = new ArrayList<>();
		
		for(char c: password.toString().toCharArray()) {
			passchar.add(c);
		}
		
		Collections.shuffle(passchar);
		
		password.setLength(0);
		
		for(char c: passchar) {
			password.append(c);
		}
		
		System.out.println("Generated Password: " + password.toString());
		
		int typeCount = 0;
		if (uppcase) typeCount++;
		if (lowcase) typeCount++;
		if (dig) typeCount++;
		if (sym) typeCount++;

		if (passlength >= 13 && typeCount == 4) {
		    System.out.println("Password Strength: STRONG");
		} else if (passlength >= 10 && typeCount >= 3) {
		    System.out.println("Password Strength: MEDIUM");
		} else {
		    System.out.println("Password Strength: WEAK");
		}

	}

}
