package evil.dan.RTKforge.server.command;

import cpw.mods.fml.common.FMLCommonHandler;
import evil.dan.RTKforge.RTKforge;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandServerKick;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandRTKickAll extends CommandBase {
	@Override
	public String getCommandName() {
		return "kickall";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 3;
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		if (icommandsender.getCommandSenderName() == "Server") {
			return "kickall - Kick all users from the server. Console Only";
		} else {
			return "/kickall - Kick all users from the server. Console Only";
		}
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender.getCommandSenderName() == "Server") {
			RTKforge.KickAll("Server is restarting!\nBe back soon!");
		}
		else
		{
			System.out.println("Illegal Command Usage by: " + icommandsender.getCommandSenderName());
		}
	}
}