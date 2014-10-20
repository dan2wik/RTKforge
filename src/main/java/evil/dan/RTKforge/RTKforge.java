package evil.dan.RTKforge;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import evil.dan.RTKforge.server.CommandRTPing;

@Mod(modid = RTKforge.MODID, version = RTKforge.VERSION)
public class RTKforge
{
    public static final String MODID = "RTKforge";
    public static final String VERSION = "0.1";
    
    @EventHandler
    public void preinit(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("Hello, I am looking for a young man known as Remote Toolkit, have you seen him?");
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
    	System.out.println("Hooking RTK commands");
         MinecraftServer server = MinecraftServer.getServer();
         ICommandManager command = server.getCommandManager();
         ServerCommandManager manager = (ServerCommandManager) command;
         manager.registerCommand(new CommandRTPing());
    }
}
