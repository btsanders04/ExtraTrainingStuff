
public class PersonalInfo {

    String name;
	String grade;
	String gender;
	String major;
	String orig;
	
	public PersonalInfo(String n, String gr, String ge, String m, String o){
		name = n;
		grade = gr;
		gender = ge;
		major = m;
		orig = o;
	}
	
//	public PersonalInfo(String n){
//	 name = n;
//	}
	
	public double calcGrade(){
		switch(grade){
		case("A"): return 4.0;
		case("B"): return 3.0;
		case("C"): return 2.0;
		case("D"): return 1.0;
		case("F"): return 0;
		default: return 0;
		}
	}

	@Override
	public String toString() {
		return name + " " + grade + " " + gender + " " + major + " " + orig;
	}
	
}
