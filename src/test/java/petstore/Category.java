package petstore;

public class Category{

	private String name;

	public Category(String name) {
		this.name = name;
	}

	private Integer id;
	public Category(Integer id) {
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
