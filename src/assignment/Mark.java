package assignment;

public class Mark {
	private int group;
	
	private static int count = 0;
	
	public Mark(){
		group = ++count;
	}
	
	public int getGroup(){
		return group;
	}
	
	public void setGroup(int group) {
		this.group = group;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Mark && ((Mark)obj).group == group;
	}
}
