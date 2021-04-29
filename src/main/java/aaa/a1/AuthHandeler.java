package aaa.a1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.steveice10.mc.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;

public class AuthHandeler {

	public static boolean handle(Session session, PacketReceivedEvent event, String msg) {
		String host = session.getHost();
		if (itReg(session, event, msg)) {
			System.err.println(host + ":msg(reg)[" + msg + "]msg");
			StringBuilder commandBuilder = new StringBuilder();
			commandBuilder.append(getCommandForReg(msg));
			commandBuilder.append(' ').append(getPassWord()).append(' ').append(getPassWord());
			System.err.println(host + ":cmd(reg)[[" + commandBuilder + "]");
			event.getSession().send(new ClientChatPacket(commandBuilder.toString()));
			// send reg

			return true;
		}
		if (itLogin(session, event, msg)) {

			System.err.println(host + ":msg(login)[" + msg + "]msg");
			StringBuilder commandBuilder = new StringBuilder();
			commandBuilder.append(getCommandForLogin(msg));
			commandBuilder.append(' ').append(getPassWord());
			System.err.println(host + ":cmd(login)[[" + commandBuilder + "]");
			event.getSession().send(new ClientChatPacket(commandBuilder.toString()));
		}

		return false;
	}

	private static boolean itLogin(Session session, PacketReceivedEvent event, String msg) {
		if (msg.toLowerCase().contains("/login")) {
			return true;
		}
		return false;
	}

	private static String getUserName() {
		return MinecraftProtocolTest.USERNAME;
	}

	private static String getPassWord() {
		return MinecraftProtocolTest.PASSWORD;
	}

	private static Object getCommandForLogin(String msg) {
		final String regex = "/login[a-z0-9A-Z]{0,33}";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(msg);

		while (matcher.find()) {
			String full = matcher.group(0);
			// System.out.println(host + ":Full match: " + matcher.group(0));

			for (int i = 1; i <= matcher.groupCount(); i++) {
				// System.out.println(host + ":Group " + i + ": " + matcher.group(i));
			}
			return full;
		}
		return null;
	}

	private static String getCommandForReg(String msg) {
		final String regex1 = "/reg[a-z0-9A-Z]{0,33}";
		final Pattern pattern1 = Pattern.compile(regex1, Pattern.MULTILINE);
		final Matcher matcher1 = pattern1.matcher(msg);

		while (matcher1.find()) {
			String full = matcher1.group(0);
			System.out.println("Full match: " + full);

			for (int i = 1; i <= matcher1.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher1.group(i));
			}
			return full;
		}

		final String regex2 = "/ｒｅｇ[a-z0-9A-Z]{0,33}";
		final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE);
		final Matcher matcher2 = pattern2.matcher(msg);

		while (matcher2.find()) {
			String full = matcher2.group(0);
			System.out.println("Full match: " + full);
			if (full.toLowerCase().contains("ｒｅｇ")) {
				System.err.println("UNICODE ｒｅｇ");
				return "/reg";
			}
			for (int i = 1; i <= matcher2.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher2.group(i));
			}
			return full;
		}

		return null;
	}

	private static boolean itReg(Session session, PacketReceivedEvent event, String msg) {
		if (msg.toLowerCase().contains("/reg")) {
			return true;
		}
		if (msg.toLowerCase().contains("/ｒｅｇ")) {
			return true;
		}

		return false;
	}

}
