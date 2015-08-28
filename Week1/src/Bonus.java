import java.io.*;
import java.util.*;

public class Bonus {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<PersonalInfo> info = new ArrayList<PersonalInfo>();
		
		//Read In input file if using a file
		File f = new File("C:/Users/Classroom/workspace/FirstProject/bin/InfoFile.txt");
		Scanner sc = new Scanner(f);
		
		//otherwise read in from command line
		//Scanner sc = new Scanner(System.in);
		//initialize total number of students, male students, and female students
		int numStudents=0, maleStudents=0, femaleStudents = 0;
		
		//initialize booleans to determine if state and major were already specified
		boolean stateExists, majorExists;
		
		//initialize sum of all gpas and individual gpa
		double overallGPA = 0, gpa = 0;
		
		//initialize gpa array for both male and female
		double[] genderGPA = new double[2];
		
		//initialize gpa array list depending on specific state and specific major
		ArrayList<StringDouble> stateGPA = new ArrayList<StringDouble>();
		ArrayList<StringDouble> majorGPA = new ArrayList<StringDouble>();
		
		//initialize string variables that input data is set to
		String cont, name, grade, gender, major, orig;
		cont="y";
		
		//loop through file until no more data is given. set each line to its specified variable
		while(sc.hasNextLine()){
		//while(cont.equals("y")){
			System.out.println("Name: ");
			name = sc.nextLine();
			System.out.println("Grade: ");
			grade = sc.nextLine();
			System.out.println("Gender: ");
			gender = sc.nextLine();
			System.out.println("Major: ");
			major = sc.nextLine();
			System.out.println("State of Origin: ");
			orig = sc.nextLine();
			//add to total number of students
			numStudents++;
			//add an PersonalInfo object to an array list that stores each piece of information
			info.add(new PersonalInfo(name, grade, gender, major, orig));
			System.out.println("Continue? (y/n)");
			//cont = sc.nextLine().toLowerCase();
		}
		System.out.println();
		sc.close();
		
		//set first person into the system
		
		PersonalInfo firstP = info.get(0);
		System.out.println(firstP);
		gpa=firstP.calcGrade();
		
		stateGPA.add(new StringDouble(firstP.orig, gpa));
		majorGPA.add(new StringDouble(firstP.major, gpa));
		overallGPA += firstP.calcGrade();
		
		if(firstP.gender.equals("M")){
			genderGPA[0]+=gpa;
			maleStudents++;
		}
		else if(firstP.gender.equals("F")){
			genderGPA[1]+=gpa;
			femaleStudents++;
		}
		
		//now check for every other person now that there is already one person in the system
		for(int i = 1; i<info.size(); i++){
			PersonalInfo p = info.get(i);
			System.out.println(p);
			gpa = p.calcGrade();
			overallGPA += gpa;
			if(p.gender.equals("M")){
				genderGPA[0]+=gpa;
				maleStudents++;
			}
			else if(p.gender.equals("F")){
				genderGPA[1]+=gpa;
				femaleStudents++;
			}
			
			//determine if state has already been inputted into the state array
			stateExists=false;
			for(int x = 0; x< stateGPA.size(); x++){
				StringDouble state = stateGPA.get(x);
				if(p.orig.equals(state.str)){
					state.d += gpa;
					state.students++;
					stateExists = true;
				}
			}
			//if it hasn't add it to the array
			if(!stateExists)
				stateGPA.add(new StringDouble(p.orig, gpa));
			
			//do the same for the major array
			majorExists=false;
			for(int x = 0; x< majorGPA.size(); x++){
				StringDouble m = majorGPA.get(x);
				if(p.major.equals(m.str)){
					m.d += gpa;
					m.students++;
					majorExists=true;
				}
			}
			if(!majorExists)
				majorGPA.add(new StringDouble(p.major, gpa));
		}
		
		System.out.println();
		//Print out all Data gathered based on averages of overall, gender, state, and major
		System.out.println("Overall Average GPA is " + overallGPA/numStudents);
		System.out.println("Overall Male Average GPA is " + genderGPA[0]/ maleStudents);
		System.out.println("Overall Female Average GPA is " + genderGPA[1]/ femaleStudents);
		
		for(StringDouble maj : majorGPA){
			System.out.println(maj.str + " average gpa is " + maj.d/maj.students);
		}
		
		for(StringDouble state : stateGPA){
			System.out.println(state.str + " average gpa is " + state.d/state.students);
		}
		
	}

}
