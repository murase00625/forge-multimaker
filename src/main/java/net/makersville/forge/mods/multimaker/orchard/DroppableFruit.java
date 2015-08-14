package net.makersville.forge.mods.multimaker.orchard;

public interface DroppableFruit {
	
	// The drop probability settings for this fruit from a vanilla Leaves block.
	// { base chance, deviation, optimal temp, min temp, max temp, min rainfall,
	//   max rainfall, max number of drops }
	public float[] getDropStats();
}
