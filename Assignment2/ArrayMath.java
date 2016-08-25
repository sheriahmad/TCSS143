
//ArrayMath.java


public class ArrayMath {

   /**
   * @param args
   */

	public static int[][] arrayAddition(int[][] theA, int[][] theB) {
	      int[][] sum = new int[theA.length][theA.length]; 
	      for (int i = 0; i < theA.length; i++) {
	         for (int k = 0; k < theA[i].length; k++) {
	            sum[i][k] = theA[i][k] + theB[i][k];
	         }        
	      }  
	      return sum;  
	  }   
	
	      
	public static int[][] arrayMultiply(int[][] theA, int[][] theB) {
		
		int[][] mul = new int[theA.length][theB.length];
		for (int i = 0; i < theA.length; i++){
			for (int j = 0; j < theB.length; j++)
			{
				mul[i][j] = 0;
				for (int k = 0; k < theB.length; k++)
					mul[i][j] += theA[i][k]*theB[k][j];
			}
		}
		return mul;
	}


	public static int[][] arraySubtraction(int[][] theA, int[][] theB) {
		// TODO Auto-generated method stub
		
		   int[][] sub = new int[theA.length][theA.length]; 
		      for (int i = 0; i < theA.length; i++) {
		         for (int k = 0; k < theA[i].length; k++) {
		            sub[i][k] = theA[i][k] - theB[i][k];
		         }        
		      }  
		      return sub;  
		
	}
		
		
	}
