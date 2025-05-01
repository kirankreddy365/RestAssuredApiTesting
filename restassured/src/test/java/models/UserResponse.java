package models;

public class UserResponse {
	
    private String name;
    private String job;
    private String id;
    private String createdAt;
    private String updatedAt;
    
    
	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getId() {
		return id;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public String toString() {
		return "id: "+id+" name: "+name+" job: "+job+" update at: "+updatedAt;
	}

}
