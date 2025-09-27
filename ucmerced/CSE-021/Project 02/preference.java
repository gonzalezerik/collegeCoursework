public class preference {
	int quietTime;
	int music;
	int reading;
	int chatting;
	
	preference(int quietTime, int music, int reading, int chatting)	{
		this.quietTime=quietTime;
		this.music=music;
		this.reading=reading;
		this.chatting=chatting;
	}
	int getquietTime()	{
		return quietTime;
	}
	
	int getmusic()	{
		return music;
	}
	
	int getreading()	{
		return reading;
	}
	
	int getchatting()	{
		return chatting;
	}
	
	public int compare(preference pref) {
		int diffPref = 0;
		diffPref += Math.abs(pref.getquietTime() - getquietTime());
		
		diffPref += Math.abs(pref.getmusic() - getmusic());
		
		diffPref += Math.abs(pref.getreading() - getreading());
		
		diffPref += Math.abs(pref.getchatting() - getchatting());
		
		return diffPref;
	}
}	
	
	
	
	