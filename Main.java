//imports file and scanner
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int lnNmb = 1; //line number counter

    
    try {
      File palis = new File("list.txt"); //file object
      Scanner myReader = new Scanner(palis); //scans file
      while (myReader.hasNextLine()) //takes line by line
      {
        String data = myReader.nextLine(); //data
        String temp = "";
        for (int i = 0; i < data.length(); i++) //loops through line
          {
            char test = data.charAt(i); //runs character by character
            if((test>=48)&&(test<=57)||(test>=97)&&(test<=122)||(test>=65)&&(test<=90))
            {//uses ASCII code to look for letters and numbers
              temp += test; //adds to temp string if letter or number
            }
          }
        temp = temp.toLowerCase(); //makes it all lowercase

        System.out.println(); //prints line inbetween because \n gave me a red line in the bottom line
        //prints line number, original string, and if it is a palindrome or not
        System.out.println(lnNmb +") Is ("+data+ ") a palindrome?: "+isPali(temp));
        lnNmb++;//increments line number
      }
      myReader.close();
    } 
    
    catch (FileNotFoundException e) { //if file isnt found
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


  public static boolean isPali (String inp) //method in main to check for palindrome
  {
    char letter;
    String rev = "";
    for (int i=0; i<inp.length(); i++) //reverses string character by character
      {
        letter = inp.charAt(i); //used reverse technique i found online
        rev = letter+rev; 
      }

    return rev.equals(inp); //check if original(no special characters) matches reversed
    
  }
}
