import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class p61 {
	public static void main(String[] args) {
		Vector<Vector<Integer>> v_of_v = new Vector<Vector<Integer>>();
		Vector<Vector<Integer>> resvec = new Vector<Vector<Integer>>();
		Vector<Integer> T_numbers = new Vector<Integer>();
		Vector<Integer> S_numbers= new Vector<Integer>();
		Vector<Integer> P_numbers= new Vector<Integer>();
		Vector<Integer> H_numbers= new Vector<Integer>();
		Vector<Integer> He_numbers= new Vector<Integer>();
		Vector<Integer> O_numbers= new Vector<Integer>();
		for (int i = 1; i < 151; i++) {
			int tri = triangle(i);
			int sq = square(i);
			int pn = pentagonal(i);
			int hx = hexagonal(i);
			int he = heptagonal(i);
			int oct = octagonal(i);
			if( tri > 999 && tri <= 9999)
				T_numbers.add(tri);
			if(sq > 999 && sq <= 9999)
				S_numbers.add(sq);
			if(pn > 999 && pn <= 9999)
				P_numbers.add(pn);
			if(hx > 999 && hx <= 9999)
				H_numbers.add(hx);
			if(he > 999 && he <= 9999)
				He_numbers.add(he);
			if(oct > 999 && oct <= 9999)
				O_numbers.add(oct);
		}
		v_of_v.add(T_numbers);
		v_of_v.add(S_numbers);
		v_of_v.add(P_numbers);
		v_of_v.add(H_numbers);
		v_of_v.add(He_numbers);
		v_of_v.add(O_numbers);


		int nums[] = new int[6];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}

		permutate(nums,nums.length,nums.length,v_of_v);

		System.out.println("end");
	}


	private static void permutate(int a[], int size, int n,Vector<Vector<Integer>> v_of_v) {
		 // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
        	check(a, n,v_of_v);
 
        for (int i = 0; i < size; i++) {
        	permutate(a, size - 1, n,v_of_v);
 
            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }
 
            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
		
	}


	private static void check(int a[], int n,Vector<Vector<Integer>> v_of_v) {
		
		for (int tnum : v_of_v.elementAt(a[0])) {
			for (int snum : v_of_v.elementAt(a[1])) {
				if(is_rotation(tnum,snum))
				{
					for (int pnum : v_of_v.elementAt(a[2])) {
						if(is_rotation(snum,pnum))
						{
							for (int hnum : v_of_v.elementAt(a[3])) {
								if(is_rotation(pnum,hnum))
								{
									for (int henum : v_of_v.elementAt(a[4])) {
										if(is_rotation(hnum,henum))
										{
											for (int onum : v_of_v.elementAt(a[5])) {
												if(is_rotation(henum,onum)) {
													if(is_rotation(onum,tnum)) {
														System.out.println(tnum +" "+ a[0]);
														System.out.println(snum +" "+ a[1]);
														System.out.println(pnum +" "+ a[2]);
														System.out.println(hnum +" "+ a[3]);
														System.out.println(henum +" "+ a[4]);
														System.out.println(onum +" "+ a[5]);
														System.out.println();
													}
												}
											}
										}
									}
								}
							}	
						}
					}
				}
			}
		}
	}


	static void swap(int arr[],int a,int b)
	{
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}


	public static int triangle(int n)
	{
		return n*(n+1)/2;
	}
	public static int square(int n)
	{
		return n*n;
	}
	public static int pentagonal(int n)
	{
		return n*(3*n-1)/2;
	}
	public static int hexagonal(int n)
	{
		return n*(2*n-1);
	}
	public static int heptagonal(int n)
	{
		return n*(5*n-3)/2;
	}
	public static int octagonal(int n)
	{
		return n*(3*n-2);
	}

	public static int rotation(int num)
	{
		int t = num%10;
		int t_num = num;
		int c = 0;
		while(t_num/10 > 0) {
			c++;
			t_num/=10;
		}
		num /= 10;
		return t * (int)Math.pow(10, c) + num;
	}

	public static boolean is_rotation(int num,int s_num)
	{
		if((num%10 == (s_num/100)%10) && ((num/10)%10 == (s_num/1000)))
			return true;
		/*if((s_num%10 == (num/100)%10) && ((s_num/10)%10 == (num/1000)))
			return true;*/
		return false;
	}
	public static void count_digits(int digits[],int num)
	{
		int t_num = num;
		while(t_num > 0)
		{
			digits[t_num %10]++;
			t_num/=10;
		}
	}
}




/*	int one = rotation(num);
int two = rotation(num);
int three = rotation(num);
int four = rotation(num);
int five = rotation(num);
if(S_numbers.contains(one) ||S_numbers.contains(two)||S_numbers.contains(three)||S_numbers.contains(four)||S_numbers.contains(five))
	if(S_numbers.contains(one) ||S_numbers.contains(two)||S_numbers.contains(three)||S_numbers.contains(four)||S_numbers.contains(five))
		if(P_numbers.contains(one) ||P_numbers.contains(two)||P_numbers.contains(three)||P_numbers.contains(four)||P_numbers.contains(five))
			if(H_numbers.contains(one) ||H_numbers.contains(two)||H_numbers.contains(three)||H_numbers.contains(four)||H_numbers.contains(five))
				if(He_numbers.contains(one) ||He_numbers.contains(two)||He_numbers.contains(three)||He_numbers.contains(four)||He_numbers.contains(five))
					if(O_numbers.contains(one) ||O_numbers.contains(two)||O_numbers.contains(three)||O_numbers.contains(four)||O_numbers.contains(five))
					{
						System.out.println(num);
						System.out.println(one);
						System.out.println(two);
						System.out.println(three);
						System.out.println(four);
						System.out.println(five);
						System.out.println();
					}
 */