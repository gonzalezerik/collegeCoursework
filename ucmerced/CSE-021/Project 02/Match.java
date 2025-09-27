import java.util.Scanner;
import java.io.*;
public class Match {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//array of students
		Student[] Students = new Student[100];
		String file = "FullRoster.txt"; 
		Scanner kbd = new Scanner(new FileReader(file));
		kbd.useDelimiter("[\\t\\r-]");
		//student counter
		int studentCounter = 0;
		//while to read everything from file
		while (kbd.hasNext())	{
			String name = kbd.next();
			char gender = kbd.next().charAt(0);
			Date birthdate = new Date(Integer.valueOf(kbd.next()), Integer.valueOf(kbd.next()), Integer.valueOf(kbd.next()));
			preference pref = new preference(Integer.valueOf(kbd.next()), Integer.valueOf(kbd.next()), Integer.valueOf(kbd.next()), Integer.valueOf(kbd.next()));
			Students[studentCounter] = new Student(name, gender, birthdate, pref);
			studentCounter++;
		}
		for	(int i = 0; i < studentCounter; i++)	{
			int currentScore = 0;
			int MaxScore = 0;
			int bestMatchScore = 0;
			int bestMatchStudent = 0;
			if	(!Students[i].getmatched())	{
				
				for	(int j = 0; j < studentCounter; j++)	{
					 if(!Students[j].getmatched()) {
						 if(i!=j) {
						 currentScore = Students[i].compare(Students[j]);
						 }
					 }
				if	(currentScore > MaxScore)	{
					MaxScore = currentScore;
					bestMatchStudent = j;
					bestMatchScore = MaxScore;
				}
				}
				if(bestMatchScore == 0) {
				 	System.out.println(Students[i].getName()+ " has no matches. ");
				 	}
				 else {
				 		Students[i].setmatched(Students[bestMatchStudent]);
				 		System.out.println(Students[i].getName()+" matches with " + Students[bestMatchStudent].getName()+" with the score " + MaxScore);
				 	}
			}
		}
	}

}
