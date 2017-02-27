package pivnystvrtok;

public enum ApplicationExceptionCode {
	DateIsNotThursday("Dátum pre pivný štvrtok musí byť štvrtok"),
	StateIsNotFinished("Minulý Pivný štvrtok ešte nie je ukončený");
	ApplicationExceptionCode(String s){
		this.message = s;
	}
	String message;
	
	public String getMessage() {
		return message;
	}
}
