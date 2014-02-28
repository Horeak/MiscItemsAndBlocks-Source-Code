package mantle.books;

import mantle.client.block.SmallFontRenderer;
import net.minecraft.util.ResourceLocation;

import org.w3c.dom.Document;

public class BookData
{
    public String unlocalizedName = new String();
    public String toolTip = new String();
    public String modID = new String();
    public ResourceLocation leftImage = new ResourceLocation("miscitems", "textures/gui/bookleft.png");
    public ResourceLocation rightImage = new ResourceLocation("miscitems", "textures/gui/bookright.png");
    public ResourceLocation itemImage = new ResourceLocation("miscitems", "textures/items/book.png");
    public Document doc = ManualReader.readManual("/assets/miscitems/manuals/guide.xml");
    //font can be left null if so, the default from mantle will be used
    public SmallFontRenderer font;
    public Boolean isTranslatable = false;

    public Document getDoc ()
    {
        return this.doc;
    }

    public String getFullUnlocalizedName ()
    {
        return this.modID + ":" + this.unlocalizedName;
    }

}
