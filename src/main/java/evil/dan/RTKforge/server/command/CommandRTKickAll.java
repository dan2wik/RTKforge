package evil.dan.RTKforge.server.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandServerKick;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

public class CommandRTKickAll extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "kickall";
	}

	@Override
    public int getRequiredPermissionLevel()
    {
        return 3;
    }
    
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		if (icommandsender.getCommandSenderName() == "Server") {
			return "kickall - Kick all users from the server. Console Only";
		} else {
			return "/kickall - Kick all users from the server. Console Only";
		}
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		CommandBase kick = new CommandServerKick();
		kick.processCommand(icommandsender, new String[] { icommandsender.getCommandSenderName() });
	}
}