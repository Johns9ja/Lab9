import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;


class Main {

  static ArrayList<Person> people;
  static String nameFile;
  static FileReader newFile; 
  
  public static void main(String[] args) {

    people = new ArrayList<Person>();
    String name = " ", age = " ", color = " ";

    people.add(new Person("Jacob", 22, "blue"));
    people.add(new Person("A    ", 87, "pink"));
    people.add(new Person("B    ", 13, "yellow"));
    people.add(new Person("C    ", 55, "black"));
    people.add(new Person("D    ", 4, "green"));



    try{
      FileWriter wFile;  
      wFile = new FileWriter("data.txt");
      BufferedWriter fileOutput = new BufferedWriter(wFile);

      for(int i=0; i<people.size(); i++) {
        fileOutput.write(people.get(i).getName()); 
        fileOutput.newLine();
        fileOutput.write(Integer.toString(people.get(i).getAge())); 
        fileOutput.newLine();
        fileOutput.write(people.get(i).getColor()); 
        fileOutput.newLine();

        fileOutput.flush();
      }
      fileOutput.close();
    }

  catch (IOException exception) 
    { 
    System.out.println("An error occurred: " + exception);
    }

  try{
    FileReader newFile;
    newFile = new FileReader("data.txt");
    BufferedReader bufReader = new BufferedReader(newFile);
      while (bufReader.ready()) {
          name = bufReader.readLine();
          age = bufReader.readLine();
          color = bufReader.readLine();
          System.out.printf("%-10s %n", name + "\t" + age + "\t" + color);
        }
    bufReader.close();
  } 

  catch (IOException exception) 
    {
    System.out.println("An error occurred: " + exception);
    }
  
  }
}
