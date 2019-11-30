package startmenu;
import java.text.ParseException;

import create.UserService;
import entities.Order;
import entities.User;
import entities.RoleEnum;
import exceptions.UserInputException;

public class MainMenu {
	
	Order order;

	public void mainMenu(){
		UserService userService = new UserService();		
		User user = userService.getUser();
		if(user.getRole().name().equals(RoleEnum.ADMIN.name())){
			System.out.println("In StratMenuAdmin...");
			StartMenuAdmin sma = new StartMenuAdmin(user);		
			try {
				sma.mainMenu();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
