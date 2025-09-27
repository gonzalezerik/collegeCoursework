
public class Student {
	//instance variables
	String name;
	char gender;
	Date birthdate;
	preference pref;
	Boolean matched = false;
	
	//constructor with the input parameters
	public Student(String name, char gender, Date birthdate, preference pref)	{
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.pref = pref;
	}
	//accessor method #1
	String getName()	{
		return this.name;
	}
	//accessor method #2
	char getgender()	{
		return this.gender;
	}
	//accessor method #3
	Date getbirthdate()	{
		return this.birthdate;
	}
	//accessor method #4
	preference getpref()	{
		return this.pref;
	}
	//accessor method #5
	Boolean getmatched()	{
		return this.matched;
	}
	
	//mutator method
	public void	setmatched(Student student)	{
		student.matched = true;
		matched = true;
	}
	
	//compare method
	public int compare(Student st) {
		int compScore = 0;
		if	(gender == st.getgender())	
			//why do we need to use get
			compScore = (40 - Math.abs(pref.compare(st.getpref()))) + (60 - (Math.abs(birthdate.compare(st.getbirthdate()))));
		
		return compScore;
	}
}
	
	
	
	