package de.simonsator.partyandfriends.clans.stats.epicskywars;

import de.simonsator.partyandfriends.clan.commands.ClanCommands;
import de.simonsator.partyandfriends.clan.commands.subcommands.Stats;
import de.simonsator.partyandfriends.clans.stats.epicskywars.normal.StatProviderEpicSkyWars;
import de.simonsator.partyandfriends.utilities.Language;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author simonbrungs
 * @version 1.0.0 17.01.17
 */
public class MSWStatsMain extends Plugin {
	private Configuration config;
	private MSWStatsConnection connection;
	private Configuration messagesConfig;

	public void onEnable() {
		try {
			config = (new MSWStatsConfig(new File(getDataFolder(), "config.yml"))).getCreatedConfiguration();
			messagesConfig = (new MSWStatsMessages(Language.OWN, new File(getDataFolder(), "messages.yml"))).getCreatedConfiguration();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connection = new MSWStatsConnection(config.getString("database.db"), "jdbc:mysql://" + config.getString("database.host") + ":" + config.getInt("database.port"), config.getString("database.user"), config.getString("database.password"));
		((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new StatProviderEpicSkyWars(messagesConfig.getString("Name"), connection, Pattern.compile("[KILLS]", Pattern.LITERAL).matcher(messagesConfig.getString("Kills")), Pattern.compile("[WINS]", Pattern.LITERAL).matcher(messagesConfig.getString("Wins")), Pattern.compile("[PLAYED]", Pattern.LITERAL).matcher(messagesConfig.getString("Played")), Pattern.compile("[DEATHS]", Pattern.LITERAL).matcher(messagesConfig.getString("Deaths"))), this);
	}
}
