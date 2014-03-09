package mantle.client.pages;

import net.minecraft.util.StatCollector;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TextPage extends BookPage
{
    String text;
    String title;
    
    //\u00a7n

    @Override
    public void readPageFromXML (Element element)
    {
        NodeList nodes = element.getElementsByTagName("text");
        if (nodes != null)
            text = nodes.item(0).getTextContent();
        nodes = element.getElementsByTagName("title");
        if (nodes != null)
        	title = nodes.item(0).getTextContent();
        
    }

    @Override
    public void renderContentLayer (int localWidth, int localHeight, boolean IsTranslatable)
    {
        if (IsTranslatable){
            text = StatCollector.translateToLocal(text);
            title = StatCollector.translateToLocal(title);
        }
        manual.fonts.drawSplitString(text, localWidth, localHeight + 20, 178, 0);
        manual.fonts.drawSplitString("\u00a7n" + title, localWidth, localHeight + 2, 178, 0);
    }
}
