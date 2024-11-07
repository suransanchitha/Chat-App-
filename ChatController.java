class ChatController{
	private static ChatWindow[] chatClientArray;
	
	ChatController(){
		chatClientArray=new ChatWindow[0];
	}
	public void addChatWindow(ChatWindow chatWindow){
		extendArray();
		chatClientArray[chatClientArray.length-1]=chatWindow;
	}
	public void extendArray(){
		ChatWindow[] tempchatClientArray=new ChatWindow[chatClientArray.length+1];
		for (int i = 0; i < chatClientArray.length; i++){
			tempchatClientArray[i]=chatClientArray[i];
		}
		chatClientArray=tempchatClientArray;
		
		}
	public static void sendMessage(String name ,String message){
		for (int i = 0; i < chatClientArray.length; i++){
			if (name.equals(chatClientArray[i].getSenderName())){
				continue;
			}
			chatClientArray[i].displayMessage(name ,message);
		}
	}
	
}
