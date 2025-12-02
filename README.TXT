TechSupport - the DodgySoft Technical support system.

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Sixth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2016

This project is discussed in chapters 5 and 12.

This project implements a technical support system for customers of the 
DodgySoft software company. Users can describe their software problems and 
get advice instantly!

The idea is based on Eliza - a famous program described by Joseph Weizenbaum 
in 1966. (Do a web search for "Eliza" and "Weizenbaum" if you want to know 
more about this.)

In fact, it is much more primitive than Eliza. But that's enough to match the 
quality of many software companies' technical support advice...  ;-)

To start this program, create a SupportSystem object and execute the "start" 
method.

Then start describing your problem by typing in the terminal window.

The purpose of this project is to demonstrate and study library classes, such 
as ArrayList, HashMap, HashSet, and Random.


ok James Patti

1. change the  fillDefaultResponses method to read the new format of the repsonses.txt file. 

lines of text get appended if they appear on the next consecutive line. 

A blank line marks the end of the response.

ie. 




2  

. Change the method that populates the response hash map fillResponseMap to read from the file. responses.txt 

 

The file format is a comma separated list of values (or single value) for key for the responses, any number of lines that are non blank constitute the response. A blank line indicates the end of a key, value pair.  Write your file reading code to your specifications and test 

ie

crash, crashes
Well, it never crashes on our system. It must have something
to do with your system. Tell me more about your configuration.

 
