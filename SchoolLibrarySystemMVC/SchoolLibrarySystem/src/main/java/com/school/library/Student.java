package com.school.library;


public class Student {
	
	String  name, classname, book, issuedate, returndate;

	public Student(String name, String classname, String book, String issuedate, String returndate) {
		this.name = name;
		this.classname = classname;
		this.book = book;
		this.issuedate = issuedate;
		this.returndate = returndate;
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}



	@Override
	public String toString() {
		return "<br>Student Name =  " + name +", <br> Book =  " + book + ", <br> Issue Date =  " + issuedate
				+ ", <br> Return Date =  " + returndate;
	}
	
	

}
