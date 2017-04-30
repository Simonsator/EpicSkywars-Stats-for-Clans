package de.simonsator.partyandfriends.clans.stats.epicskywars;

/**
 * @author simonbrungs
 * @version 1.0.0 30.11.16
 */
public class PlayerData {
	public final int wins;
	public final int games;
	public final int deaths;
	public final int kills;

	public PlayerData(int wins, int games, int deaths, int kills) {
		this.wins = wins;
		this.games = games;
		this.deaths = deaths;
		this.kills = kills;
	}
}
