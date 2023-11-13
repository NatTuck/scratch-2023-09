/*
public class Types {
	public static void main(String args[]) {
	// PRIMITIVE TYPES:

		// computer store data
		// the basic unit of data is a bit: 0 or 1
		//   two bits could be: 00, 01, 10, 11
		//         as integers:  0   1   2   3
		//   three bits could be: 
		//     000, 001, 010, 011, 100, 101, 110, 111
		//       0    1    2    3    4    5    6    7
		// a byte is 8 bits:
		//       unsigned: 0 - 255
		//       signed: -128 - 127
		byte b0;
	
		// short is 16 bits (2 bytes)
		//   unsigned: 0 - (2^16 - 1) = 65535 (64k)
		//   signed: (-2^15) -32k - 32k (2^15-1)
		short s0;
		
		// int is 32 bits (4 bytes)
		//    2^32 different values
		//    signed: -2^31 - (2^31 - 1)
		//     2^31 ~ 2 billion
		int x = 5;
	
		// long is 64 bits (8 bytes)
		//    signed: -2^63 - (2^63 - 1)
		//    2^63 is 8 quintillion 
		long l0;

		// sign
		// exp
		// significant
		// sign * significand * 2^exp
		//
		// 3.4 * 10^7   sig = 3.4, exp = 7
		float f0; // 32 bit
	
		double d0; // 64 bit
			   //
		boolean bool0; // one bit, true or false
			       //
			       //


		// Built in classes
		String foo = "hello";

		// Primitive wrapper classes
		// one for each primitive type
		Double d1;
	}
}
*/
public class Types {
	static Bird biggerBird(Bird aa, Bird bb) {
		if (aa.weight > bb.weight) {
			return aa;
		}
		else {
			return bb;
		}
	}

	public static void main(String args[]) {
		Bird b1 = new Bird();
		b1.color = "blue";
		b1.weight = 7.0; // pounds
				 //
		Bird b2 = new Bird();
		b2.color = "red";
		b2.weight = 9.0; // pounds

		var b3 = biggerBird(b1, b2);

		System.out.println("Bird is " + b3.color 
				+ " and weighs " + b3.weight);
	}
}

class Bird {
	String color;
	double weight;
}





