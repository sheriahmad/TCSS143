/*
 * TCSS 143 - Fall 2015
 * Assignment1.java
 * 
 */
import java.util.Scanner;


public class Programming1{
	
/**
 * @author sahmad
 * @version V1
 * @param args
 * 
 */
	
	public static void main(String[] args){

		int town1population; 
		int town2population; 
		int town3population;
		int town4population;
		int town5population;

		Programming1 p1 = new Programming1();

		Scanner s = new Scanner(System.in);

		town1population = p1.getPopulation(1, s);
		town2population = p1.getPopulation(2, s);
		town3population = p1.getPopulation(3, s);
		town4population = p1.getPopulation(4, s);
		town5population = p1.getPopulation(5, s);

		System.out.println();
		
		p1.drawPopulationBar(1, town1population); 
		p1.drawPopulationBar(2, town2population);
		p1.drawPopulationBar(3, town3population);
		p1.drawPopulationBar(4, town4population);
		p1.drawPopulationBar(5, town5population);
	}
/**
 * 
 * @param n
 * @param s
 * @return population
 */
	public int getPopulation(int n, Scanner s){

		System.out.print("Enter the population of town" + n + ": ");

		int population=s.nextInt();  
		
		return population; 
		
	}
/**
 * 
 * @param n
 * @param townpopulation
 */
	public void drawPopulationBar(int n,int townpopulation){
		
		System.out.print("Town"+n+":");
      
		while(townpopulation >= 1000){
			System.out.print("*");
			townpopulation = townpopulation-1000;
		}
		System.out.print("\n");
		
	}
}





/*

public class Programming1 {


   public static int town1;
   public static int town2;
   public static int town3;
   public static int town4;
   public static int town5;

   public static void main(String[] theArgs) {
	   Scanner population = new Scanner(System.in);  Keyboard input
	      System.out.println("Enter the population of town 1: ");
	      town1 = population.nextInt();  Asks input for town population
	      System.out.println("Enter the population of town 2: ");
	      town2 = population.nextInt();  Changes town(#) to user input
	      System.out.println("Enter the population of town 3: ");
	      town3 = population.nextInt();
	      System.out.println("Enter the population of town 4: ");
	      town4 = population.nextInt();
	      System.out.println("Enter the population of town 5: ");
	      town5 = population.nextInt();
       
       drawPopulationBar();
   }

   public static int getPopulation(int town, Scanner Population) {
	  
	   return Population.nextInt();
     
	
   }  

   public static void drawPopulationBar() {
	   System.out.println();
	   int noOfAsterik = 0;

       noOfAsterik = town1 /1000;
       System.out.print("Town1: ");
       for(int j = 0 ; j < noOfAsterik ; j++){
    	   System.out.print("*");
    	   }
          
       System.out.println();

       noOfAsterik = town2 /1000;
       System.out.print("Town2: ");
       for(int j = 0 ; j < noOfAsterik ; j++)
       {
    	   System.out.print("*");                  
       }

       System.out.println();

       noOfAsterik = town3 /1000;
       System.out.print("Town3: ");
       for(int j = 0 ; j < noOfAsterik ; j++)
       {
    	   System.out.print("*");                  
       }

       System.out.println();

       noOfAsterik = town4 /1000;
       System.out.print("Town4: ");
       for(int j = 0 ; j < noOfAsterik ; j++)
       {
    	   System.out.print("*");                  
       }

       System.out.println();

       noOfAsterik = town5 /1000;
       System.out.print("Town5: ");
       for(int j = 0 ; j < noOfAsterik ; j++)
       {
    	   System.out.print("*");                  
       }
    } 
 }
 */