package pivnystvrtok;

public enum ApplicationExceptionCode {
	DateIsNotThursday("Dátum pre pivný štvrtok musí byť štvrtok");
	ApplicationExceptionCode(String s){
		this.message = s;
	}
	String message;
	
	public String getMessage() {
		return message;
	}
}
