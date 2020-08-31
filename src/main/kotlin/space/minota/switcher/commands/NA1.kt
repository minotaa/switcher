package space.minota.switcher.commands

import com.google.common.io.ByteStreams
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import space.minota.switcher.Main

class NA1 : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        val player = sender as Player
        val out = ByteStreams.newDataOutput()
        out.writeUTF("Connect")
        out.writeUTF("NA-UHC1")
        player.sendPluginMessage(JavaPlugin.getPlugin(Main::class.java), "BungeeCord", out.toByteArray())
        return true
    }
}