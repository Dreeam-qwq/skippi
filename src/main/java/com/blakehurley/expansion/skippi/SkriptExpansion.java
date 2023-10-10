package com.blakehurley.expansion.skippi;

import ch.njol.skript.variables.Variables;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class SkriptExpansion extends PlaceholderExpansion
{
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(this.getPlugin()) != null;
    }
    
    public boolean register() {
    	return this.canRegister() && super.register();
    
        
    }
    
    public String getAuthor() {
        return "Snow-Pyon";
    }
    
    public String getIdentifier() {
        return "skript";
    }
    
    public String getPlugin() {
        return "Skript";
    }
    
    public String getVersion() {
        return "1.0.0";
    }
    
    public String onPlaceholderRequest(final Player p, final String identifier) {
        final String variable = (p != null) ? identifier.replace("{player}", p.getName()).replace("{uuid}", p.getUniqueId().toString()) : identifier;
        return (Variables.getVariable(variable.toLowerCase(), null, false) != null) ? String.valueOf(Variables.getVariable(variable.toLowerCase(), null, false)) : "N/A";
    }}