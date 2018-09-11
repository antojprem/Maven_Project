package wrappers;

import java.util.Scanner;
public class sample {

	public static void main(String[] args) {
				// fill code here
		        int m, n, sum = 0;
		        Scanner s = new Scanner(System.in);
		        m = s.nextInt();
		        if(m<0){
		        	System.out.println("Invalid Input");
		        }
		        else{
		        while(m > 0)
		        {
		            n = m % 10;
		            sum = sum + n;
		            m = m / 10;
		        }
		         int last = sum % 10;
		         if(last == 5 || last == 8)
		             System.out.println("Lucky Customer");
		         else if(last != 5 || last != 8 )
		             System.out.println("Unlucky Customer");
		    }
	}
		}

