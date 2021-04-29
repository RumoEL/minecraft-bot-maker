package aaa.a1.handlers;

import org.apache.commons.lang3.StringUtils;

import com.github.steveice10.mc.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;

public class MoneyHandler {

	public static boolean handle(Session session, PacketReceivedEvent event, String rawMessage) {
		rawMessage = rawMessage.toLowerCase();
		if (rawMessage.contains("Викторина".toLowerCase())) {
			//
			String task = StringUtils.substringBetween(rawMessage, "Реши ".toLowerCase(), " и получи".toLowerCase());
			if (task != null && !task.isEmpty()) {
				MathProblem problem = new MathProblem(task);
				problem.calculate();
				System.err.println("task[" + task + "] answ[" + problem.getAnsw() + ']');
				event.getSession().send(new ClientChatPacket(problem.getAnsw()));
			}
			return true;
		}
		if (rawMessage.toLowerCase().contains("ougi_oshino") && rawMessage.toLowerCase().contains("getbalance")) {
			event.getSession().send(new ClientChatPacket("/balance"));
		}
		return false;
	}

}
