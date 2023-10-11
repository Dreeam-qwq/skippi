package com.blakehurley.expansion.skippi;

import ch.njol.skript.variables.Variables;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.jetbrains.annotations.NotNull;

public class SkriptExpansion extends PlaceholderExpansion {
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(this.getRequiredPlugin()) != null;
    }

    public boolean register() {
        return this.canRegister() && super.register();
    }

    public @NotNull String getAuthor() {
        return "Snow-Pyon";
    }

    public @NotNull String getIdentifier() {
        return "skript";
    }

    public @NotNull String getRequiredPlugin() {
        return "Skript";
    }

    public @NotNull String getVersion() {
        return "1.0.1";
    }

    public String onPlaceholderRequest(final Player p, final @NotNull String identifier) {
        final String variable = (p != null) ? identifier.replace("{player}", p.getName()).replace("{uuid}", p.getUniqueId().toString()) : identifier;
        return (Variables.getVariable(variable.toLowerCase(), null, false) != null) ? String.valueOf(Variables.getVariable(variable.toLowerCase(), null, false)) : "false";
    }
}