package cn.tedu.ttms.product.entity;

import java.util.Date;

/**
 * 产品类目管理模块的实体类
 * @author soft01
 *
 */
public class ProductType {
	private static final long serialVersionUID=1L;
	/**分类id*/
	private Integer id;
	/**分类名称*/
	private String name;
	/**上级分类id*/
	private Integer parentId;
	/**排序号*/
	private Integer sort;
	private String createdUser;
	private String modifiedUser;
	private Date createdTime;
	private Date modifiedTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", parentId=" + parentId + ", sort=" + sort
				+ ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
}
