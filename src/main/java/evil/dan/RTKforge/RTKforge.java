package evil.dan.RTKforge;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLCommonHandler;
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
    public final static PrintStream out = new PrintStream(new FileOutputStream(FileDescriptor.out));
    
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
         manager.registerCommand(new CommandRTKickAll());
    }
    
    public static void KickAll(String KickMessage) {
		String[] ServerList = FMLCommonHandler.instance().getMinecraftServerInstance().getAllUsernames();
		for (int i = 0; i < ServerList.length; i++) {
			EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().func_152612_a(ServerList[i]);
			entityplayermp.playerNetServerHandler.kickPlayerFromServer(KickMessage);
		}
    }
}
