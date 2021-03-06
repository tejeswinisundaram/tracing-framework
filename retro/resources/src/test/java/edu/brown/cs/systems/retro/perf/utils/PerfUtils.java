package edu.brown.cs.systems.retro.perf.utils;

import edu.brown.cs.systems.baggage.Baggage;
import edu.brown.cs.systems.baggage.DetachedBaggage;
import edu.brown.cs.systems.retro.Retro;

/**
 * This class should not be woven
 */
public class PerfUtils {

    public static DetachedBaggage getContext(int tenantClass) {
        try {
            Baggage.discard();
            Retro.setTenant(tenantClass);
            return Baggage.stop();
        } finally {
            Baggage.discard();
        }
    }

    public static byte[] getBytes(int tenantClass) {
        try {
            Baggage.discard();
            Retro.setTenant(tenantClass);
            return Baggage.stop().toByteArray();
        } finally {
            Baggage.discard();
        }
    }
}
