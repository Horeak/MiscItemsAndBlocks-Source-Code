package MiscItemsApi.Utils;

import com.miscitems.MiscItemsAndBlocks.Book.GuiItemRender;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class BookUtils {

    public static GuiItemRender renderitem = new GuiItemRender();


    //Dont change MaxTabs since it might cause buggynes when over 8
    public static final int MaxTabs = 8;
    public static int Tabs = 0;


    public static HashMap<Integer, String> TabNames = new HashMap<Integer, String>();
    public static HashMap<Integer, ItemStack> TabIcons = new HashMap<Integer, ItemStack>();

    /**
     * 1 = text
     * 2 = item list
     */
    public static HashMap<Integer, Integer> TabType = new HashMap<Integer, Integer>();

    public static HashMap<Integer, ItemStack[]> TabItems = new HashMap<Integer, ItemStack[]>();
    public static HashMap<Integer, String> TextTabString = new HashMap<Integer, String>();





    public static void RegisterTab(int Number, String Name, ItemStack stack, int Type){
        if(TabNames.size() < MaxTabs){
             TabNames.put(Number, Name);
             TabIcons.put(Number, stack);
            TabType.put(Number, Type);
            Tabs++;
        }

    }


    public static void RegisterItemsForTab(int Number, ItemStack[] stacks){
        if(!TabNames.get(Number).isEmpty()){
            TabItems.put(Number, stacks);
        }
    }


    public static void RegisterTextForTab(int Number, String text){
        if(TabType.get(Number) == 1){
            TextTabString.put(Number, text);
        }
    }


    public static String GetTextForTab(int Number){
        return TextTabString.get(Number);
    }

    public static String GetTabName(int Number){
        return TabNames.get(Number);
    }


    public static ItemStack GetTabIconItem(int Number){
        return TabIcons.get(Number);
    }

    public static int GetTabType(int Number){
        return TabType.get(Number);
    }

}
