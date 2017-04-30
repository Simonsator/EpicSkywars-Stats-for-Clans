package de.simonsator.partyandfriends.clans.stats.epicskywars;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.pafplayers.PAFPlayer;
import de.simonsator.partyandfriends.clan.api.Clan;
import de.simonsator.partyandfriends.clan.api.ClanStat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public abstract class MSWStats implements ClanStat {
	private final String NAME;
	protected final MSWStatsConnection CONNECTION;
	private final Matcher KILLS_MESSAGE;
	private final Matcher WINS_MESSAGE;
	private final Matcher GAMES_MESSAGE;
	private final Matcher DEATHS_MESSAGE;

	public MSWStats(String pName, MSWStatsConnection pCon, Matcher pKillsMessage, Matcher pWinsMessage, Matcher pPlayedMessage, Matcher pDeathsMessage) {
		NAME = pName;
		CONNECTION = pCon;
		KILLS_MESSAGE = pKillsMessage;
		WINS_MESSAGE = pWinsMessage;
		GAMES_MESSAGE = pPlayedMessage;
		DEATHS_MESSAGE = pDeathsMessage;
	}

	public void stats(OnlinePAFPlayer pSender, Clan pClan) {
		List<PAFPlayer> players = pClan.getAllPlayers();
		List<PlayerData> playerData = new ArrayList<PlayerData>();
		for (PAFPlayer player : players) {
			PlayerData data = getPlayerData(player.getUniqueId());
			if (data != null)
				playerData.add(data);
		}
		int wins = 0;
		int deaths = 0;
		int games = 0;
		int kills = 0;
		for (PlayerData data : playerData) {
			wins += data.wins;
			deaths += data.deaths;
			kills += data.kills;
			games += data.games;
		}
		pSender.sendMessage(WINS_MESSAGE.replaceFirst(wins + ""));
		pSender.sendMessage(GAMES_MESSAGE.replaceFirst(games + ""));
		pSender.sendMessage(KILLS_MESSAGE.replaceFirst(kills + ""));
		pSender.sendMessage(DEATHS_MESSAGE.replaceFirst(deaths + ""));
	}

	public String getName() {
		return NAME;
	}

	protected abstract PlayerData getPlayerData(UUID pPlayer);
}
