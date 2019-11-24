package entities;

public enum RoleEnum {
  USER("user"),ADMIN("admin");
  
  private final String name;       

  
  private RoleEnum(String name){
	  this.name = name;
  }
  
  public String toString() {
      return this.name;
   }
  
}
