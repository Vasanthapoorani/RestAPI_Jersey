package com.webservices.restapi;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.xml.bind.annotation.XmlRootElement;
//POJO Clz
@XmlRootElement //Inorder to print the data in XML Format with root and elements inside it
@Getter
@Setter
@ToString
	public class Employee //Use @Data after public to replace all annotations in lombak
	{
	
		private int id;
		private String name;
		private int marks;
		
	}
//@EqualsAndHashCode, NoArgsConstructor etc in Lombak