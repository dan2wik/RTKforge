package evil.dan.RTKforge;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

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
}
