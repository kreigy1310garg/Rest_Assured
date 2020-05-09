package Spring.Rest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetPOJO {

	public int id;
	
	public Category category;
	
	public String name;
	
	public String[]  photoUrls;
	
	public Tag[] tags;
	
	public String status;
	
}
