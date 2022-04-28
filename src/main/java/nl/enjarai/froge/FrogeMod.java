package nl.enjarai.froge;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import nl.enjarai.froge.blocks.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrogeMod implements ModInitializer {
	public static final String MODID = "froge";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModBlocks.register();

		LOGGER.info("Ribbit");
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
