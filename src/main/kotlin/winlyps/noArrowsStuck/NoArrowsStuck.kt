package winlyps.noArrowsStuck

import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.plugin.java.JavaPlugin

class NoArrowsStuck : JavaPlugin(), Listener {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    fun onArrowHit(event: EntityDamageByEntityEvent) {
        if (event.entity is Player && event.damager is Arrow) {
            val player = event.entity as Player
            server.scheduler.runTaskLater(this, Runnable {
                player.arrowsInBody = 0
            }, 1L)
        }
    }
}
