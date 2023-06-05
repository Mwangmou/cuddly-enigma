package bean;

public class movies {
	private int id;
	private String name;
	private String duration;
	private String area;
	private float moviedate;
	private String price;
	public movies(){
		
	}
	public movies(int id, String name, String duration, String area,
			float moviedate, String price) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.area = area;
		this.moviedate = moviedate;
		this.price = price;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getduration() {
		return duration;
	}
	public void setduration(String duration) {
		this.duration = duration;
	}
	public String getarea() {
		return area;
	}
	public void setarea(String area) {
		this.area = area;
	}
	public float getmoviedate() {
		return moviedate;
	}
	public void setmoviedate(float moviedate) {
		this.moviedate = moviedate;
	}
	public String getprice() {
		return price;
	}
	public void setprice(String price) {
		this.price = price;
	}
	public void setbookType(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
