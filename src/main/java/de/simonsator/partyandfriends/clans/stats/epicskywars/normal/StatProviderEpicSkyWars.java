package de.simonsator.partyandfriends.clans.stats.epicskywars.normal;

import de.simonsator.partyandfriends.clans.stats.epicskywars.MSWStats;
import de.simonsator.partyandfriends.clans.stats.epicskywars.MSWStatsConnection;
import de.simonsator.partyandfriends.clans.stats.epicskywars.PlayerData;

import java.util.UUID;
import java.util.regex.Matcher;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class StatProviderEpicSkyWars extends MSWStats {
	public StatProviderEpicSkyWars(String pName, MSWStatsConnection pCon, Matcher pKillsMessage, Matcher pWinsMessage, Matcher pPlayedMatcher, Matcher pDeathsMessage) {
		super(pName, pCon, pKillsMessage, pWinsMessage, pPlayedMatcher, pDeathsMessage);
	}

	protected PlayerData getPlayerData(UUID pPlayer) {
		return CONNECTION.getPlayerData(pPlayer);
	}
}
