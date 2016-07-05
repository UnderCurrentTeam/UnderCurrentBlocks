package undercurrent;

import cpw.mods.fml.common.event.*;
import undercurrent.blocks.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import undercurrent.proxy.CommonProxy;
import undercurrent.reference.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import undercurrent.tileEntity.TileEntityHandler;

import java.util.logging.Logger;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = "1.7.10")
public class UnderCurrentBlocks {

    public static CreativeTabs underCurrentTab = new UnderCurrentTab(ModInfo.ID);
    public static Logger logger = Logger.getLogger("UnderCurrentBlocks");

    @SidedProxy(clientSide = "undercurrent.proxy.ClientProxy", serverSide = "undercurrent.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance(ModInfo.ID)
    public static UnderCurrentBlocks instance;

    @EventHandler
    public void init(FMLInitializationEvent event) {

        logger.info("UnderCurrentBlocks: Initializing.");
        Blocks.init();
        TileEntityHandler.init();
        proxy.initRenderers();
        proxy.initHandlers();


    }
}
