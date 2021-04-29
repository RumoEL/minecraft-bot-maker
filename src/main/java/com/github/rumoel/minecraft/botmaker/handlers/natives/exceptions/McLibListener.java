package com.github.rumoel.minecraft.botmaker.handlers.natives.exceptions;

import com.github.steveice10.mc.protocol.data.game.ClientRequest;
import com.github.steveice10.mc.protocol.packet.ingame.client.ClientRequestPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerAdvancementsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerBossBarPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDeclareCommandsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDeclareRecipesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDeclareTagsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDifficultyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerJoinGamePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerKeepAlivePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerPlayerListDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerPluginMessagePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerRespawnPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerTitlePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerUnlockRecipesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityAnimationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityDestroyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityEffectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityEquipmentPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityHeadLookPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityMetadataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityPositionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityPositionRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityPropertiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntitySetPassengersPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityStatusPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityTeleportPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityVelocityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerAbilitiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerChangeHeldItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerHealthPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerPositionRotationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.player.ServerPlayerSetExperiencePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnLivingEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPaintingPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.spawn.ServerSpawnPlayerPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.scoreboard.ServerDisplayScoreboardPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.scoreboard.ServerScoreboardObjectivePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.scoreboard.ServerTeamPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.scoreboard.ServerUpdateScorePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.window.ServerConfirmTransactionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.window.ServerSetSlotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.window.ServerWindowItemsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerBlockBreakAnimPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerBlockChangePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerBlockValuePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerChunkDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerMapDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerMultiBlockChangePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerNotifyClientPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerPlayBuiltinSoundPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerPlayEffectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerPlaySoundPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerSpawnParticlePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerSpawnPositionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerUpdateLightPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerUpdateTileEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerUpdateTimePacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerUpdateViewPositionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerWorldBorderPacket;
import com.github.steveice10.mc.protocol.packet.login.server.LoginSetCompressionPacket;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.DisconnectedEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.SessionAdapter;
import com.github.steveice10.packetlib.packet.Packet;

import aaa.a1.MessageHandler;

public class McLibListener extends SessionAdapter {
	private Session session;

	public McLibListener(Session session) {
		this.session = session;
	}

	@Override
	public void packetReceived(PacketReceivedEvent event) {
		Packet eventPacket = event.getPacket();

		String host = session.getHost();
		int port = session.getPort();

		if (eventPacket instanceof LoginSetCompressionPacket || eventPacket instanceof ServerAdvancementsPacket
				|| eventPacket instanceof ServerBlockChangePacket || eventPacket instanceof ServerBlockValuePacket
				|| eventPacket instanceof ServerBossBarPacket || eventPacket instanceof ServerChunkDataPacket
				|| eventPacket instanceof ServerDeclareCommandsPacket
				|| eventPacket instanceof ServerDeclareRecipesPacket || eventPacket instanceof ServerDeclareTagsPacket
				|| eventPacket instanceof ServerDifficultyPacket || eventPacket instanceof ServerDisplayScoreboardPacket
				|| eventPacket instanceof ServerEntityAnimationPacket
				|| eventPacket instanceof ServerEntityDestroyPacket
				|| eventPacket instanceof ServerEntityEquipmentPacket
				|| eventPacket instanceof ServerEntityHeadLookPacket
				|| eventPacket instanceof ServerEntityMetadataPacket
				|| eventPacket instanceof ServerEntityPositionPacket
				|| eventPacket instanceof ServerEntityPositionRotationPacket
				|| eventPacket instanceof ServerEntityPropertiesPacket
				|| eventPacket instanceof ServerEntityRotationPacket
				|| eventPacket instanceof ServerEntitySetPassengersPacket
				|| eventPacket instanceof ServerEntityStatusPacket || eventPacket instanceof ServerEntityTeleportPacket
				|| eventPacket instanceof ServerKeepAlivePacket || eventPacket instanceof ServerMultiBlockChangePacket
				|| eventPacket instanceof ServerNotifyClientPacket
				|| eventPacket instanceof ServerPlayBuiltinSoundPacket
				|| eventPacket instanceof ServerPlayerAbilitiesPacket
				|| eventPacket instanceof ServerPlayerChangeHeldItemPacket
				|| eventPacket instanceof ServerPlayerListDataPacket
				|| eventPacket instanceof ServerPlayerListEntryPacket
				|| eventPacket instanceof ServerPlayerSetExperiencePacket
				|| eventPacket instanceof ServerPluginMessagePacket
				|| eventPacket instanceof ServerScoreboardObjectivePacket || eventPacket instanceof ServerSetSlotPacket
				|| eventPacket instanceof ServerSpawnEntityPacket
				|| eventPacket instanceof ServerSpawnLivingEntityPacket
				|| eventPacket instanceof ServerSpawnParticlePacket || eventPacket instanceof ServerSpawnPlayerPacket
				|| eventPacket instanceof ServerSpawnPositionPacket || eventPacket instanceof ServerTeamPacket
				|| eventPacket instanceof ServerTitlePacket || eventPacket instanceof ServerUnlockRecipesPacket
				|| eventPacket instanceof ServerUpdateLightPacket || eventPacket instanceof ServerUpdateScorePacket
				|| eventPacket instanceof ServerUpdateTileEntityPacket || eventPacket instanceof ServerUpdateTimePacket
				|| eventPacket instanceof ServerUpdateViewPositionPacket
				|| eventPacket instanceof ServerWindowItemsPacket || eventPacket instanceof ServerBlockBreakAnimPacket
				|| eventPacket instanceof ServerWorldBorderPacket
				|| eventPacket instanceof ServerConfirmTransactionPacket || eventPacket instanceof ServerMapDataPacket
				|| eventPacket instanceof ServerSpawnPaintingPacket || eventPacket instanceof ServerPlaySoundPacket
				|| eventPacket instanceof ServerPlayEffectPacket || eventPacket instanceof ServerEntityEffectPacket

		//
		) {
		} else if (eventPacket instanceof ServerRespawnPacket) {
			System.err.println("РЕСПАВН:" + host);
		} else if (eventPacket instanceof ServerEntityVelocityPacket) {
			ServerEntityVelocityPacket velocityPacket = (ServerEntityVelocityPacket) eventPacket;

			int id = velocityPacket.getEntityId();
			double motionX = velocityPacket.getMotionX();
			double motionY = velocityPacket.getMotionY();
			double motionZ = velocityPacket.getMotionZ();

			// System.err.println(host + ":" + id + ":" + motionX + ":" + motionY + ":" +
			// motionZ);
		} else if (eventPacket instanceof ServerPlayerPositionRotationPacket) {
			ServerPlayerPositionRotationPacket rotation = (ServerPlayerPositionRotationPacket) eventPacket;

			// System.out.println(host + ":" + rotation.getX() + ":" + rotation.getY() + ":"
			// + rotation.getZ());
		} else if (eventPacket instanceof ServerPlayerHealthPacket) {
			ServerPlayerHealthPacket healthPacket = (ServerPlayerHealthPacket) eventPacket;
			if (healthPacket.getHealth() <= 0) {
				event.getSession().send(new ClientRequestPacket(ClientRequest.RESPAWN));
			}
		} else if (eventPacket instanceof ServerJoinGamePacket) {
		} else if (eventPacket instanceof ServerChatPacket) {
			MessageHandler.handle(session, event, (ServerChatPacket) eventPacket);
		} else {
			System.err.println(eventPacket.getClass());
		}
	}

	@Override
	public void disconnected(DisconnectedEvent event) {
		System.out.println("Disconnected: " + event.getReason());
		if (event.getCause() != null) {
			event.getCause().printStackTrace();
		}
	}

}
