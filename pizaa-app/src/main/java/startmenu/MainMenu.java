package startmenu;
import create.UserFactory;
import entities.Order;
import entities.User;
import entities.RoleEnum;
import exceptions.UserInputException;

public class MainMenu {
	
	Order order;

	public void mainMenu(){
		UserFactory userFactory = new UserFactory();		
		User user = userFactory.getUser();
		if(user.getRole().name().equals(RoleEnum.ADMIN.name())){
			System.out.println("In StratMenuAdmin...");
			StartMenuAdmin sma = new StartMenuAdmin(user);		
			sma.mainMenu();
		} else {	
			try{
			System.out.println("In StartMenuUser...");			
			StartMenuUser smu = new StartMenuUser(user);			
			smu.mainMenu();			
			}catch(UserInputException e){
				System.out.println(e.getErrorMessage());
			}
		}
	}
}
