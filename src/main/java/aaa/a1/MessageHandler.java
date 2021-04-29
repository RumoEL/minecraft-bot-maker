package aaa.a1;

import com.github.steveice10.mc.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;

import aaa.a1.handlers.MoneyHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

public class MessageHandler {

	public static void handle(Session session, PacketReceivedEvent event, ServerChatPacket packet) {
		Component msgComponent = packet.getMessage();
		String rawMessage = componentToPlainText(msgComponent);

		if (AuthHandeler.handle(session, event, rawMessage)) {
			return;
		} else if (MoneyHandler.handle(session, event, rawMessage)) {

		}
		if (rawMessage.toLowerCase().contains("tmpe")) {
			String who = "Ougi_Oshino";
			event.getSession().send(new ClientChatPacket("/tpa " + who));
		}

		else {
			// IGNORE
			String rawMessageLower = rawMessage.toLowerCase();
			if (rawMessageLower.contains("Наш домен".toLowerCase())) {
				return;
			}

			System.out.println(session.getHost() + ":" + rawMessage);
		}
	}

	public static String componentToPlainText(Component c) {
		if (!(c instanceof TextComponent))
			return c.toString();
		TextComponent tc = (TextComponent) c;

		StringBuilder b = new StringBuilder(tc.content());
		for (Component child : tc.children()) {
			b.append(componentToPlainText(child));
		}

		return b.toString();
	}
}
