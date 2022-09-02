package com.schoollibrary.system;

public class CheckLogin {

	String id;
	String password;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	int  check(){
		
		if("admin".equalsIgnoreCase(id)&&"admin".equals(password))
		{
			System.out.print("\n\tLogging you as an Admin: ");

			for (int i = 0; i < 5; i++) {

				System.out.print("*");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.print(e.getMessage());
				}

		}
			return 1;
		}else
			return 2;
		
   	}
	
	
}
