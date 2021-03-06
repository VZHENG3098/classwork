package chatbot;

public class Chatbot {
	private String username;
	private boolean chatting;
	private Topic vincent;
	
	public Chatbot() {
		vincent = new ChatbotVin();
		username = "Uknown User";
		chatting = true;
	}
	public String getUsername() {
		return username;
	}
	public Topic getVin() {
		return vincent;
	}
	public void startChatting() {
		//whenever you print or get input, use these methods;
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(vincent.isTriggered(response)) {
				chatting = false;//exit the while loop. 
				vincent.talk(response);
			}else {
				ChatbotMain.print("Im sorry. I don't understand. I never said I was perfect.");
			}
		}
	}
}
