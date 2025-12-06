
/**
 * Write a description of class BlankLinesException here.
 *
 * @author  James Patti
 * @version 12/5/25
 * 
 * 
 * goal here is to make a checked exception for if there more then 2 blank lines in responder.
 */
public class BlankLinesException extends Exception
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class BlankLinesException
     * 
     * @ param a string for the messages,
     */
    public BlankLinesException(String message)
    {
        // initialise instance variables
        super(message);
    }

    /**
     * 
     */
     
    public void BlankLinesException() throws BlankLinesException
    {
        // put your code here
        
    }
}