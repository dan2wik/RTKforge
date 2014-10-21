package evil.dan.RTKforge;

import java.io.IOException;

import com.drdanick.McRKit.api.RTKInterface;
import com.drdanick.McRKit.api.RTKInterfaceException;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import evil.dan.RTKforge.server.command.CommandRTKickAll;
import evil.dan.RTKforge.server.command.CommandRTPing;

@Mod(modid = RTKforge.MODID, version = RTKforge.VERSION)
public class RTKforge
{
    public static final String MODID = "RTKforge";
    public static final String VERSION = "0.1";
    
    public Boolean RTKconnected = false;
    
    @EventHandler
    public void preinit(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("Hello, I am looking for a young man known as Remote Toolkit, have you seen him?");
        RTKInterface api = new RTKInterface(25561, "localhost", "user", "pass", "salt");

		try{
			api.executeCommand(RTKInterface.CommandType.VERSION, null);
		} catch(IOException e) {
			System.out.println("RTK Problems!!!");
			e.printStackTrace();
		} catch(RTKInterfaceException e) {
			System.out.println("RTK Problems!!!");
			e.printStackTrace();
		}
		
		try {
			System.out.println("Response from toolkit: "+api.getLastResponse());
		} catch (InterruptedException e) {
			System.out.println("RTK Problems!!!");
			e.printStackTrace();
		}
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
    	System.out.println("Hooking RTK commands");
         MinecraftServer server = MinecraftServer.getServer();
         ICommandManager command = server.getCommandManager();
         ServerCommandManager manager = (ServerCommandManager) command;
         manager.registerCommand(new CommandRTPing());
         manager.registerCommand(new CommandRTKickAll());
    }
}
