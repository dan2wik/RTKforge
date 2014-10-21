package evil.dan.RTKforge.server.command;

import evil.dan.RTKforge.RTKforge;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandServerKick;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

public class CommandRTPing extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "RTPING";
	}

	@Override
    public int getRequiredPermissionLevel()
    {
        return 3;
    }
    
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "Thud Thud.";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (icommandsender.getCommandSenderName() == "Server") {
			RTKforge.out.println("RTPONG++");
		} else {
			System.out.println("Illegal Command Usage by: " + icommandsender.getCommandSenderName());
		}
	}
}