/*
 * Megan McNamee CSC 330  LAB#2 NumericAnalyer CSC 330
 * Passing numbers through the command line and displaying information 
 * */
package edu.cuny.csi.csc330.lab2;

import java.util.Arrays; //collection of framework

public class NumericAnalyzer 
{
//Initializing variables
    private double input[];
    private double mean;
    private double sum;
    private double median;
    private double variance; //The average of the squared differences from the Mean
    private double min;
    private double max;
    private double range;
    private double std; //the square root of the Variance
    private int count;

   
    public NumericAnalyzer(String args[])
    {
        input = new double[args.length];
        for (int i = 0; i < args.length; i++)
            input[i] = Integer.parseInt(args[i]);
    }

    private void sortNumbers(double input[])
    {
        Arrays.sort(input);
        for (double n : input) 
        {
            System.out.printf("%-8.2f", n);
        }
        System.out.print("\n");
    }

    private int getCount(double input[]) 
    {
        return input.length;
    }

    private double getMax(double input[])
    {
        double max = input[0];
        for (int i = 1; i < input.length; i++) 
        {
            if (input[i] > max) 
            {
                max = input[i];
            }
        }
        return max;
    }

    private double getMin(double input[]) 
    {
        double min = input[0];
        for (int i = 1; i < input.length; i++) 
        {
            if (input[i] < min) 
            {
                min = input[i];
            }
        }
        return min;
    }

    private double getSum(double input[]) 
    {
        double total = 0;
        for (int i = 0; i < input.length; i++)
            total += input[i];
        return total;
    }

    private double getMean(double input[]) 
    {
        double total = 0;
        for (int i = 0; i < input.length; i++) 
        {
            total = total + input[i];
        }
        return (total / input.length);
    }

    private double getMedian(double input[]) 
    {
        Arrays.sort(input);
        double median = 0;
        double pos1 = Math.floor((input.length - 1.0) / 2.0);
        double pos2 = Math.ceil((input.length - 1.0) / 2.0);
        if (pos1 == pos2) 
        {
            median = input[(int) pos1];
        } else {
            median = (input[(int) pos1] + input[(int) pos2]) / 2.0;
        }
        return median;
    }

    public double getRange(double input[]) 
    {
        
        return this.getMax(input) - this.getMin(input);
    }

    private double getVariance(double inputs[]) 
    {
        double variance = 0;
        for (int i = 0; i < inputs.length; ++i) 
        {
           
            variance += (inputs[i] - this.getMean(inputs)) * (inputs[i] - this.getMean(inputs));
        }
        variance /= inputs.length;
        return variance;
    }

    private double getStd(double inputs[])
    {
        return Math.sqrt(getVariance(inputs));
    }

    private void calculate()
    {
        sum = (int) getSum(input);
        count = getCount(input);
        max = getMax(input);
        min = getMin(input);
        mean = getMean(input);
        median = getMedian(input);
        range = getRange(input);
        variance = getVariance(input);
        std = getStd(input);
    }

    private void output() 
    {
        sortNumbers(input);
        System.out.println(); 
        System.out.printf("Count:\t\t\t\t\t\t%d\n", count);
        System.out.printf("Min:\t\t\t\t\t\t%.2f\n", min);
        System.out.printf("Max:\t\t\t\t\t\t%.2f\n", max);
        System.out.printf("Range:\t\t\t\t\t\t%.2f\n", range);
        System.out.printf("Sum:\t\t\t\t\t\t%.2f\n", sum);
        System.out.printf("Mean:\t\t\t\t\t\t%.2f\n", mean);
        System.out.printf("Median:\t\t\t\t\t\t%.2f\n", median);
        System.out.printf("Variance:\t\t\t\t\t%.2f\n", variance);
        System.out.printf("Standard Deviation:\t\t\t\t%.2f\n", std);
    }

    public static void main(String args[]) 
    {
    	
        if (args.length == 0) 
        {
        	//Error checking to see if user has entered numerical data 
            System.err.print("ERROR. Sorry this has failed. Please enter 1 or more integers.");
            System.exit(1); 
        }
        


        NumericAnalyzer analyzer = new NumericAnalyzer(args);
        analyzer.calculate();
        analyzer.output();
    }
}
