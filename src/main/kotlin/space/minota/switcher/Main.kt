package space.minota.switcher

import com.google.common.io.ByteStreams
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.messaging.PluginMessageListener
import space.minota.switcher.commands.EU1
import space.minota.switcher.commands.Hub
import space.minota.switcher.commands.NA1
import space.minota.switcher.commands.NA2


class Main : JavaPlugin(), PluginMessageListener {

    override fun onEnable() {
        server.messenger.registerIncomingPluginChannel(this, "BungeeCord", this);
        server.messenger.registerOutgoingPluginChannel(this, "BungeeCord")

        getCommand("na1").executor = NA1()
        getCommand("eu1").executor = EU1()
        getCommand("hub").executor = Hub()
        getCommand("na2").executor = NA2()

        logger.info("Switcher enabled!")
    }

    override fun onDisable() {
        logger.info("Switcher disabled!")
    }

    @SuppressWarnings("UnstableApiUsage")
    override fun onPluginMessageReceived(channel: String?, player: Player?, message: ByteArray) {
        if (channel != "BungeeCord") {
            return
        }
        val `in` = ByteStreams.newDataInput(message)
        val subChannel = `in`.readUTF()
        if (subChannel.equals("Connect", ignoreCase = true)) {
            val data1 = `in`.readUTF()
            val data2 = `in`.readInt()
        }
    }

}