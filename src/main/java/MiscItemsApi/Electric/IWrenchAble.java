package MiscItemsApi.Electric;

import net.minecraft.entity.player.EntityPlayer;

public interface IWrenchAble {


    /** Called when a tile is wrenched
     *
     * @param player the player excecuting the wrench
     * @param x the x cord
     * @param y the y cord
     * @param z the z cord
     */
    void OnWrenched(EntityPlayer player, int x, int y, int z);


}
