package me.spartacus04.jext.command.adapter

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

abstract class Parameter(val isRequired: Boolean) {

    abstract val name: String?

    abstract fun onComplete(parameter: String, sender: CommandSender): List<String>?

    override fun toString(): String {
        return if (isRequired) {
            "[${ChatColor.RESET}${ChatColor.LIGHT_PURPLE}${name}${ChatColor.RESET}]"
        } else {
            "<${ChatColor.RESET}${ChatColor.DARK_PURPLE}${name}${ChatColor.RESET}>"
        }
    }
}