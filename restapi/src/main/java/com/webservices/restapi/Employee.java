package com.webservices.restapi;

import javax.xml.bind.annotation.XmlRootElement;

//POJO Clz
@XmlRootElement //Inorder to print the data in XML Format with root and elements inside it
	public class Employee {
		private int id;
		private String name;
		private int marks;
		
		
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


		public int getMarks() {
			return marks;
		}


		public void setMarks(int marks) {
			this.marks = marks;
		}


		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", marks=" + marks + "]";
		}


		
	}