
public class Date {
	//instance variables 
	int year;
	int month;
	int day;
	
	//constructor
	Date(int month, int day, int year)	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//accessor methods #1
	int getmonth()	{
		return month;
	}
	//accessor #2
	int getday()	{
		return day;
	}
	//accessor # 3
	int getyear()	{
		return year;
	}

	public int compare(Date dt) {
		int yearsDifferenceInDays = Math.abs((dt.getyear() - year) * 365);
		int daysDifference = Math.abs(dt.dayOfYear() - dayOfYear());
		int totalDifference = Math.abs(yearsDifferenceInDays - daysDifference);
		int monthsDifference = totalDifference / 30;
		if	(monthsDifference > 60)	{
			monthsDifference = 60;
		}
		return monthsDifference;
	}
	
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
		}
	
}