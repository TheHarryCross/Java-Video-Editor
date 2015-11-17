package asg.jcodec.codecs.mpeg4.es;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * @author The JCodec project
 * 
 */
public class DescriptorFactory {
    private static Map<Integer, Class<? extends Descriptor>> map = new HashMap<Integer, Class<? extends Descriptor>>();
    static {
        map.put(ES.tag(), ES.class);
        map.put(SL.tag(), SL.class);
        map.put(DecoderConfig.tag(), DecoderConfig.class);
        map.put(DecoderSpecific.tag(), DecoderSpecific.class);
    }

    public Class<? extends Descriptor> byTag(int tag) {
        return map.get(tag);
    }
}
