package P;
import java.util.*;
public class Child {

	public int age;
	public int height;
	public boolean withparent;
	public boolean heartDisease;
	private String[] attractions;
	
	public Child(int age, int height, boolean withparent, boolean heartDisease) {
		
		this.age = age;
		this.height = height;
		this.withparent = withparent;
		this.heartDisease = heartDisease;
		this.attractions = attractions;

		

	}
	@Override
	public String toString() {
		//return String.format("%d\t%d\t%s\t%s",age , height,heartDisease,withparent);
		String rtn = null;
		StringBuilder sb = new StringBuilder();
		for(String attraction : attractions) {
			sb.append(attraction);
			sb.append(",");
		}
		rtn = String.format("%d\t%d\t%s\t%s",age , height,heartDisease,withparent);
		rtn += sb.toString();
		
		return rtn;
	}
	public Child() {

	}
	public boolean getCanRide() {
						
		boolean rtn =false;
    	if(this.heartDisease == false) {
    		if (this.age >= 6 && this.height >= 120) {
    			rtn = true;
    		} else {
    			if (this.height >=120 && this.withparent == true) {
    				rtn = true;
    			} else {
    				rtn = false;
    			}
    		}
    	}else {
    		rtn = false;
    	}
		return rtn;
		
		
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isWithparent() {
		return withparent;
	}

	public void setWithparent(boolean withparent) {
		this.withparent = withparent;
	}

	public boolean isHeartDisease() {
		return heartDisease;
	}

	public void setHeartDisease(boolean heartDisease) {
		this.heartDisease = heartDisease;
	}

	public String[] getAttractions() {
		if(this.attractions ==null) {
			this.attractions = new String[0];
		}
		return attractions;
	}

	public void setAttractions(String[] attractions) {
		this.attractions = attractions;
	}
	
}
