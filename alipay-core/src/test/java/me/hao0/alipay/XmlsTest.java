package me.hao0.alipay;

import me.hao0.common.xml.XmlReaders;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 21/11/15
 */
public class XmlsTest {

    @Test
    public void testGetNode(){
        XmlReaders xmls = XmlReaders.create("<?xml version=\"1.0\" encoding=\"GBK\" ?>" +
                "<alipay>" +
                "<is_success>T</is_success>" +
                "</alipay>");
        assertTrue(xmls.getNodeStr("is_success").equals("T"));
        assertNull(xmls.getNodeStr("not_found"));

        xmls = XmlReaders.create("");
        assertNull(xmls.getNode("is_success"));
    }
}
