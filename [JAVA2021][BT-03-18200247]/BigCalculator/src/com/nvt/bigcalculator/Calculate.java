package com.nvt.bigcalculator;

import java.math.BigInteger;

public class Calculate {
	public String plus(String num1,String num2) {
		String result = "";
		int n1[] = new int[num1.length()/9+1],n2[] = new int[num2.length()/9+1];
		n1 = convertForPlus(num1);
		n2 = convertForPlus(num2);
		int carry = 0;
		int size1 = n1.length,size2=n2.length;
		if(size1>=size2) {
			for(int i=size1-1,j=size2-1;i>=0&&j>=0;i--,j--) {
				if(i>=0&&j>=0) n1[i]+= n2[j]; 
			}
			for(int j=size1-1;j>=0;j--) {
				n1[j]+= carry; 
				if(n1[j]/1000000000 != 0 ) {
					carry = n1[j]/ 1000000000;
					n1[j] = n1[j] % 1000000000;
				}
				else carry = 0;
			}
			for(int i:n1) result =  result.concat(String.valueOf(i));
		}
		else {
			for(int i=size2-1,j=size1-1;i>=0&&j>=0;i--,j--) {
				if(i>=0&&j>=0) n2[i]+= n1[j]; 
			}
			for(int j=size2-1;j>=0;j--) {
				n2[j]+= carry; 
				if(n2[j]/1000000000 != 0 ) {
					carry = n2[j]/ 1000000000;
					n2[j] = n2[j] % 1000000000;
				}
				else carry = 0;
			}
			for(int i:n2) result =  result.concat(String.valueOf(i));
		}
		return result;
	}
	public String subtract(String num1,String num2) {
		String result = "";
		int n1[] = new int[num1.length()/9+1],n2[] = new int[num2.length()/9+1];
		n1 = convertForPlus(num1);
		n2 = convertForPlus(num2);
		int carry = 0;
		int size1 = n1.length,size2=n2.length;
		if(size1>=size2) {
			for(int i=size1-1,j=size2-1;i>=0&&j>=0;i--,j--) {
				if(i>=0&&j>=0) n1[i] -= n2[j]; 
			}
			for(int i:n1) System.out.print(i+" ");
			for(int j=size1-1;j>=0;j--) {
				n1[j] += carry;
				if(n1[j] < 0 && j!=0 && n1[0]>0) {
					n1[j] += 1000000000;
					carry = -1;
				}
				else if(n1[j] < 0 && j!=0 && n1[0]<0)
				{
					n1[j] = Math.abs(n1[j]);
					carry = 0;
				}
				else carry = 0;
			}
			for(int i:n1) result =  result.concat(String.valueOf(i));
		}
		else {
			for(int i=size2-1,j=size1-1;i>=0&&j>=0;i--,j--) {
				if(i>=0&&j>=0) n2[i]-= n1[j]; 
			}
			for(int j=size2-1;j>=0;j--) {
				n2[j] += carry;
				if(n2[j] < 0 && j != 0) {
					n2[j] += 1000000000;
					carry = -1;
				}
				else carry = 0;
			}
			result = result.concat("-");
			for(int i:n2) result =  result.concat(String.valueOf(i));
		}
		return result;
	}
	public String multiply(String num1,String num2) {
		String result = "";
		int n1[] = new int[num1.length()],n2[] = new int[num2.length()];
		n1 = convertForMul(num1);
		n2 = convertForMul(num2);
		int size1 = n1.length, size2 = n2.length;
		int temp[] = new int[size1+size2];
		for(int i=0;i<size1+size2;i++)
				temp[i] = 0;
		for(int i = size1-1;i>=0;i--)
			for(int j=size2-1;j>=0;j--)
			{
				temp[i+1+j] += n1[i]*n2[j]; 
			}
		for (int i=size1+size2-1;i>=0;i--)
		{
			if(temp[i]>9) {
				temp[i-1] += temp[i]/10;
				temp[i] %= 10; 
			}
		}
		for(int i = 0;i<size1+size2;i++)
		{
			result = result.concat(String.valueOf(temp[i]));
		}
		return result;
	}
	public String divide(String num1,String num2) {
		String result = null;
		BigInteger bigInt1 = new BigInteger(num1);
		BigInteger bigInt2 = new BigInteger(num2);
		BigInteger resultBig = bigInt1.divide(bigInt2);
		result = resultBig.toString();
		return result;
	}
	
	public boolean checknum(String num) {
		boolean check = false;
		int j;
		for(int i=0;i<num.length();i++) {
			j = Integer.valueOf(num.charAt(i));
			if(j<48||j>57) {
				check = false;
			}
			else check = true;
		}
		return check;
	}
	
	public static int[] convertForPlus(String string) {
		int n = string.length();
		int j=n/9;
		int array[] = new int[n/9+1];
		String[] temp = new String[n/9+1];
		for (int i=n-1;i>=0;i--) {
			if((n-i)%9 == 0&&j!=0) {
				temp[j] = string.substring(i,i+9); 
				array[j] = Integer.valueOf(temp[j]);
				j--;
			}
			else if(j == 0) {
				temp[j] = string.substring(0,i+1);
				array[j] = Integer.valueOf(temp[j]);
				break;
			}
		}
		return array;
	}
	
	public static int[] convertForMul(String string) {
		int n = string.length();
		int array[] = new int[string.length()];
		for(int i=0;i<n;i++) {
			array[i] = Integer.valueOf(string.substring(i,i+1));
		}
		return array;
	}
}
