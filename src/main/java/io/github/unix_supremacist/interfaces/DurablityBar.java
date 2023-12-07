package io.github.unix_supremacist.interfaces;

import net.minecraft.util.Mth;

public interface DurablityBar {
    default int getColor(int max, int current) {
        float f = Math.max(0.0F, ((float)max - (float)current) / (float)max);
        return Mth.hsvToRgb(f / 1.1F, 1.0F, 1.0F);
    }
}
