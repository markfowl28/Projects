/* Mark Fowler
 * Assignment 2
 * 2/3/22
 * Project designed to display the population for each of the next 5 years
 * assuming that the current population is 312,032,486 and each year is 365 days.
 */

public class Assignment2
{
	public static void main(String[] args)
	{
		//starting population is 312,032,486 
		long startingPop = 312032486;
		
		//each year has 365 days
		final long daysInYear = 365;
		
		//formula to calculate the number of seconds in a year
		final long secondsInYear = (((daysInYear * 24) * 60) * 60);
		
		//calculate births, deaths, and immigrants per year based off the U.S. Census Bureau projections
		double birthsPerYear = secondsInYear / 7.0;
		double deathsPerYear = secondsInYear / 13.0;
		double immigrantsPerYear = secondsInYear / 45.0;
		
		//calculating new population each year by adding births and immigrants and subtracting deaths from each consecutive year
		double popYearOne = startingPop + birthsPerYear - deathsPerYear + immigrantsPerYear;
		double popYearTwo = popYearOne + birthsPerYear - deathsPerYear + immigrantsPerYear;
		double popYearThree = popYearTwo + birthsPerYear - deathsPerYear + immigrantsPerYear;
		double popYearFour = popYearThree + birthsPerYear - deathsPerYear + immigrantsPerYear;
		double popYearFive = popYearFour + birthsPerYear - deathsPerYear + immigrantsPerYear;
		
		//Convert decimals to whole numbers for total population per year
		long finPopYearOne = (long)(popYearOne);
		long finPopYearTwo = (long)(popYearTwo);
		long finPopYearThree = (long)(popYearThree);
		long finPopYearFour = (long)(popYearFour);
		long finPopYearFive = (long)(popYearFive);
		
		//prints out results
		System.out.println("Starting population: " + startingPop);
		System.out.println("Population Year One: " + finPopYearOne);
		System.out.println("Population Year Two: " + finPopYearTwo);
		System.out.println("Population Year Three: " + finPopYearThree);
		System.out.println("Population Year Four: " + finPopYearFour);
		System.out.println("Population Year Five: " + finPopYearFive);
	}
}