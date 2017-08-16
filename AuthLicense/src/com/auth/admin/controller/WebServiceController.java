package com.auth.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.admin.service.ProductService;
import com.auth.model.ProductModel;
import com.auth.model.UserModel;

@Controller
public class WebServiceController {
	
	@RequestMapping(value="/WapCasino")
	@ResponseBody
	public String getUsers(){
		
		return "ok";
	}
	
	public void parse_license(String str)
	{
		char[] key  = str.toCharArray();
		
		char[]  source = new char[key.length];
		char[] tmpstr= new char[5];
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		int l = 0;
		
		//while(key[l]!='\0') could not use while,because the NULL's ASCII is 00000000 
		for(l = 0;l < key.length;l++)
		{
		//	System.out.print(key[l]);
			switch(key[l])
			{
				case 'A':
					key[l] = 0;
					break;
				case 'B':
					key[l] = 1;
					break;
				case 'C':
					key[l] = 2;
					break;
				case 'D':
					key[l] = 3;
					break;
				case 'E':
					key[l] = 4;
					break;
				case 'F':
					key[l] = 5;
					break;
				case 'G':
					key[l] = 6;
					break;
				case 'H':
					key[l] = 7;
					break;
				case 'I':
					key[l] = 8;
					break;
				case 'J':
					key[l] = 9;
					break;
				case 'K':
					key[l] = 10;
					break;
				case 'L':
					key[l] = 11;
					break;
				case 'M':
					key[l] = 12;
					break;
				case 'N':
					key[l] = 13;
					break;
				case 'O':
					key[l] = 14;
					break;
				case 'P':
					key[l] = 15;
					break;
				case 'Q':
					key[l] = 16;
					break;
				case 'R':
					key[l] = 17;
					break;
				case 'S':
					key[l] = 18;
					break;
				case 'T':
					key[l] = 19;
					break;
				case 'U':
					key[l] = 20;
					break;
				case 'V':
					key[l] = 21;
					break;
				case 'W':
					key[l] = 22;
					break;
				case 'X':
					key[l] = 23;
					break;
				case 'Y':
					key[l] = 24;
					break;
				case 'Z':
					key[l] = 25;
					break;
				case 'a':
					key[l] = 26;
					break;
				case 'b':
					key[l] = 27;
					break;
				case 'c':
					key[l] = 28;
					break;
				case 'd':
					key[l] = 29;
					break;
				case 'e':
					key[l] = 30;
					break;
				case 'f':
					key[l] = 31;
					break;
				case 'g':
					key[l] = 32;
					break;
				case 'h':
					key[l] = 33;
					break;
				case 'i':
					key[l] = 34;
					break;
				case 'j':
					key[l] = 35;
					break;
				case 'k':
					key[l] = 36;
					break;
				case 'l':
					key[l] = 37;
					break;
				case 'm':
					key[l] = 38;
					break;
				case 'n':
					key[l] = 39;
					break;
				case 'o':
					key[l] = 40;
					break;
				case 'p':
					key[l] = 41;
					break;
				case 'q':
					key[l] = 42;
					break;
				case 'r':
					key[l] = 43;
					break;
				case 's':
					key[l] = 44;
					break;
				case 't':
					key[l] = 45;
					break;
				case 'u':
					key[l] = 46;
					break;
				case 'v':
					key[l] = 47;
					break;
				case 'w':
					key[l] = 48;
					break;
				case 'x':
					key[l] = 49;
					break;
				case 'y':
					key[l] = 50;
					break;
				case 'z':
					key[l] = 51;
					break;
				case '0':
					key[l] = 52;
					break;
				case '1':
					key[l] = 53;
					break;
				case '2':
					key[l] = 54;
					break;
				case '3':
					key[l] = 55;
					break;
				case '4':
					key[l] = 56;
					break;
				case '5':
					key[l] = 57;
					break;
				case '6':
					key[l] = 58;
					break;
				case '7':
					key[l] = 59;
					break;
				case '8':
					key[l] = 60;
					break;
				case '9':
					key[l] = 61;
					break;
				case '+':
					key[l] = 62;
					break;
				case '/':
					key[l] = 63;
					break;
			}
		}	
		
		while(i1< key.length)
		{
		//	System.out.print((int)key[i1]);
			for(j1 = 0;j1 < 4;j1++)
			{
				tmpstr[j1] = key[i1];
				i1++;
			}
			source[k1] = (char) (((tmpstr[0]<<2)&0xfc) | ((tmpstr[1]>>4)&0x03));
			if(source[k1] == '$')
				break;
			k1++;
			source[k1] = (char) (((tmpstr[1]<<4)&0xf0) | ((tmpstr[2]>>2)&0x0f));
			if(source[k1] == '$')
				break;
			k1++;
			source[k1] = (char) (((tmpstr[2]<<6)&0xc0) + (tmpstr[3]&0x3f));
			if(source[k1] == '$')
				break;
			k1++;
		}
		
		String out = new String(source);
		System.out.println(out.substring(0,k1));

	}

}
