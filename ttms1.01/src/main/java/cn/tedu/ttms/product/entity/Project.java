package cn.tedu.ttms.product.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.tedu.ttms.common.web.JsonDateTypeConvert;

/**
 * 实体对象（持久化对象）:用于实现与表中数据的映射
 * 1）entity
 * 2) pojo
 * 查询数据：（table:tms_projects)--->List<Project>
 * 保存数据：（insertObject(Project project))
 * 实体对象要求：
 * 1）实体名不用复数
 * 2）实体类中的属性都使用对象类型
 * 3）实体类中的属性名要与表中字段名一致，类型要匹配。
 * 实体类对象扩展要求：
 * 1）应实现Serializable接口，便于序列化
 * 2）应添加序列化版本id.
 * FAQ?
 * 1)  何为序列化，反序列化
 * 对象序列化：将对象转换为字节的过程，
 * 对象反序列化：将字节转换为对象的过程，
 * 2）序列化应用场景？
 * 缓存中的对象落地（持久化-需要进行序列化）
 * RMI调用（跨JVM调用）
 * 3）序列化版本id有什么作用？
 * 对象发生变化时便于反序列化
 * 4）序列化是安全的吗？
 * 5）.....
 * 
 * 
 * @author soft01
 *
 */
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	/**项目编号*/
	private Integer id; //项目编号 //实体类属性，尽量都使用引用类型
	/**项目名称*/
	private String name;//项目名称
	/**项目代码*/
	private String code;//项目代码
	/**开始时间*/
	//如果不写此注解，Spring默认按照"yyyy/MM/dd"格式
	//来将前端传过来的字符串转换为Date类型
	//此注解是spring提供的注解
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;//开始时间
	/**结束时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;//结束时间
	/**状态标记*/
	private Integer valid;//状态标记
	/**项目备注*/
	private String note;//项目说明
	/**创建时间*/
	private Date createdTime;//项目创建时间； 
	/**修改时间*/
	private Date modifiedTime;//修改时间；
	/**创建用户*/
	private String createdUser;//创建者;
	/**修改用户*/
	private String modifiedUser;//修改者；
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	//在将日期类型的属性转换为Json串时
	//可参考JsonSerialize注解指定的类型转换器
	@JsonSerialize(using=JsonDateTypeConvert.class)//JsonSerializer<T>
	public Date getBeginDate() {
		JsonSerializer<Long> js=null;
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	//使用自定义的，继承了JsonSerializer类的类型转换器来将Date类型数据，
	//转换为String类型输出。
	@JsonSerialize(using=JsonDateTypeConvert.class)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", code=" + code + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", valid=" + valid + ", note=" + note + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
	
	
}
