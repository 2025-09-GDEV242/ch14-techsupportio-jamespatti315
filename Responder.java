import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 *
 * Internally, the reponder uses a HashMap to associate words with response
 * strings and a list of default responses. If any of the input words is found
 * in the HashMap, the corresponding response is returned. If none of the input
 * words is recognized, one of the default responses is randomly chosen.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @ new Author James Patti
 * 
 * goals created a checked exception for 2 or more blank lines,
 * 
 * 
 * @Version 12/8/25
 */
public class Responder
{
    // Used to map key words to responses.
    private HashMap<String, String> responseMap;
    // Default responses to use if we don't recognise a word.
    private ArrayList<String> defaultResponses;
    // The name of the file containing the default responses.
    private static final String FILE_OF_DEFAULT_RESPONSES = "default.txt";
    
    //OK LETS ADD NEW RESPONSES.
    private static final String FILE_OF_NEW_RESPONSES = "responses.txt";
    private Random randomGenerator;

    /**
     * Construct a Responder
     */
    public Responder() throws BlankLinesException
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        randomGenerator = new Random();
    }

    /**
     * Generate a response from a given set of input words.
     * 
     * @param words  A set of words entered by the user
     * @return       A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            String word = it.next();
            String response = responseMap.get(word);
            if(response != null) {
                return response;
            }
        }
        // If we get here, none of the words from the input line was recognized.
        // In this case we pick one of our default responses (what we say when
        // we cannot think of anything else to say...)
        return pickDefaultResponse();
    }

    /**
     * Enter all the known keywords and their associated responses
     * into our response map.
     * 
     * ok changes this so that is handles and populates with new responses? I literally don't get this?
     * get first word the key but what the  is any of this?
     * 
     * ok slowly finally getting this, its now hard codes but we want to read like in past method.. feel like could just reuse code.
     */
    private void fillResponseMap()
    {
        
        Charset charset = Charset.forName("US-ASCII");
        
        Path path = Paths.get(FILE_OF_NEW_RESPONSES);
        
        try (BufferedReader reader = Files.newBufferedReader(path, charset)){
        //using book two strings
        String keyword;
        String response;
        
        while(true) {
            //read keyword
            keyword = reader.readLine();
            if (keyword == null){
                break; //end before breaks
            }
            
            keyword = keyword.trim();
            if(keyword.isEmpty()){
                continue;
            }
            
            //read the response pairs, 
            response = reader.readLine();
             
            response = response.trim();
            
            responseMap.put(keyword,response);
        }
        
     }
     
     catch(FileNotFoundException e) {
            System.err.println("Unable to open " + FILE_OF_NEW_RESPONSES);
        }
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                               FILE_OF_NEW_RESPONSES);
        }
     
     // Make sure we have at least one response.
        if(defaultResponses.size() == 0) {
            defaultResponses.add("Could you elaborate on that?");
        }
     
     
    }

    /**
     * Build up a list of default responses from which we can pick
     * if we don't know what else to say.
     * 
     * ok need to changeit to read the new text file. check if 3 blank lines
     * checked exception  for this.
     * 
     * @throws: thrwos a exception under the condition of 2 or more blank lines in a text,
     * 
     */
    private void fillDefaultResponses() throws BlankLinesException
    {
        Charset charset = Charset.forName("US-ASCII");
       // Path path = Paths.get(FILE_OF_DEFAULT_RESPONSES);
        Path path = Paths.get(FILE_OF_NEW_RESPONSES);
        //ok here thr try, we can now set up a detector for blank lines
        
        int blankLines = 0; //the count for lines, more then  2 we need to use the throw!
        
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String response;
            while((response = reader.readLine()) != null) {
                
                //ok here  will be the counter
                if(response.trim().isEmpty()){
                    blankLines++;
                }
                else{
                    blankLines = 0;
                    defaultResponses.add(response);
                }
                
                //The actual code to start this 
                if(blankLines >= 2){
                throw new BlankLinesException(
                "File contains not enough words"
                );
            }
                
                
                
                
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("Unable to open " + FILE_OF_NEW_RESPONSES);
        }
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                               FILE_OF_NEW_RESPONSES);
        }
        
       
        
        // Make sure we have at least one response.
        if(defaultResponses.size() == 0) {
            defaultResponses.add("Could you elaborate on that?");
        }
    }

    /**
     * Randomly select and return one of the default responses.
     * @return     A random default response
     */
    private String pickDefaultResponse()
    {
        // Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
