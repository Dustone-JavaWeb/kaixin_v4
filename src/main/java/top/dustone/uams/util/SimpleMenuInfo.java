package top.dustone.uams.util;

import java.io.Serializable;
import java.util.List;

public class SimpleMenuInfo implements Serializable{
	private int id;
	private String name;
	private String pic;
	private String url;
	private int parentId;
	private List<SimpleMenuInfo> childs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public List<SimpleMenuInfo> getChilds() {
		return childs;
	}
	public void setChilds(List<SimpleMenuInfo> childs) {
		this.childs = childs;
	}
	@Override
	public String toString() {
		return "SimpleMenuInfo [id=" + id + ", name=" + name + ", pic=" + pic + ", url=" + url + ", parentId="
				+ parentId + ", childs=" + childs + "]";
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
