package pojo.gorestpojo;

import java.util.List;

public class PetStore{
	private List<DataItem> data;
	private Meta meta;

	public PetStore() {
	}

	public PetStore(List<DataItem> data, Meta meta) {
		this.data = data;
		this.meta = meta;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"PetStore{" + 
			"data = '" + data + '\'' + 
			",meta = '" + meta + '\'' + 
			"}";
		}
}