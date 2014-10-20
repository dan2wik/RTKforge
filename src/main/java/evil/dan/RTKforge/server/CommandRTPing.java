package evil.dan.RTKforge.server;

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
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (icommandsender.getCommandSenderName() == "Server") {
			System.out.println("RTPONG++");
		} else {
			CommandBase kick = new CommandServerKick();
			kick.processCommand(icommandsender, new String[] { icommandsender.getCommandSenderName() });
		}
	}

	@Override
	public int compareTo(Object o)
	{
		if (o instanceof ICommand)
		{
			return this.compareTo((ICommand) o);
		}
		else
		{
			return 0;
		}
	}
}