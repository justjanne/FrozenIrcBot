package packets;

public class MessagePacket extends Packet {
	public String sender;
	public String senderExtended;
	public String command;
	public String channel;
	public String message;
	
	public static MessagePacket fromString(String str) {
		MessagePacket msg = new MessagePacket();
		str = str.replace(":", "");
		msg.sender = str.split("!")[0];
		msg.senderExtended = str.split(" ")[0];
		msg.command = str.split(" ")[1];
		if (str.split(" ")[2].contains("#")) {
			msg.channel = str.split(" ")[2];
		} else {
			msg.channel = msg.sender;
		}
		try {
			msg.message = str.substring(str.indexOf(msg.channel)+msg.channel.length()+1);
		} catch (Exception e) {
			msg.message = "";
		}
		
		return msg;
	}
	
	public String toString() {
		return String.format("MSGPCKG SENDER:'%s',COMMAND:'%s',CHANNEL:'%s',MSG:'%s'",sender,command,channel,message);
	}
}
