package com.miscitems.MiscItemsAndBlocks.Tick;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Utils.Game.GameInfo;
import com.miscitems.MiscItemsAndBlocks.Utils.Game.GameInvite;

import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ParticleHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ServerTickHandler{
	
	
	/*
	 * Helmet = 3
	 * ChestPlate = 2
	 * Leggings = 1
	 * Boots = 0
	 * 
	 */
	
    public HashMap<String, GameInvite> playerGameRequests = new HashMap<String, GameInvite>();
    
    public ArrayList<GameInfo> activeGames = new ArrayList<GameInfo>();


    ParticleHelper particleHelper;

    @SubscribeEvent
    public void tick(TickEvent event){

        if(event.type == TickEvent.Type.SERVER)
            ServerTick();




    }

    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent event){

        if(Main.AllowPowerArmorEffects)
       if (event.type == TickEvent.Type.PLAYER){
            onPlayerTick(event.player);
        }


        if(particleHelper == null){
            particleHelper = new ParticleHelper(event.player.worldObj);
        }

    }




    boolean Helmet = false;
	boolean ChestPlate = false;
	boolean Leggings = false;
	boolean Boots = false;

	int TickCountParticle = 0;
	
	int Counter = 0;
	



	
	
	public void onPlayerTick(EntityPlayer player) {

		
		if(Counter >= 50){
			Counter = 0;
			
			
		
		if(player.capabilities.isCreativeMode == false){

			Flight(player);
			
			Diving(player);
			Speed(player);
			Jump(player);
			Full(player);
			
			
			}
		}else{
			Counter++;
		}
		}
	
	
	
	public void Diving(EntityPlayer player){
		
		if(player.inventory.armorInventory[3] == null || player.inventory.armorInventory[3].getItem() != ModItems.DivingHelmet){
			Helmet = false;
		}else if(player.inventory.armorInventory[3].getItem() == ModItems.DivingHelmet){
             Helmet = true;
			if(player.isInWater()){
				
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 200, 10));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 10));
				
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	public void Flight(EntityPlayer player){
		if(player.inventory.armorInventory[2] == null || player.inventory.armorInventory[2].getItem() != ModItems.FlightChestPlate ){
			if(player.getEntityData().getBoolean("HadFlightChest") == true){
			
			ChestPlate = false;
			player.capabilities.allowFlying = false;
    		player.getEntityData().setBoolean("HadFlightChest", false);
    		

    		if(player.onGround == false){
			
				
				if(player.capabilities.isFlying){
					player.capabilities.isFlying = false;
				}
					
				}

			}
		}else if(player.inventory.armorInventory[2].getItem() == ModItems.FlightChestPlate){
			
			ChestPlate = true;
			player.capabilities.allowFlying = true;
			
			if(player.onGround == false && player.isInWater() == false && player.capabilities.allowFlying && player.isAirBorne){
				if(TickCountParticle == 5){

			              particleHelper.SpawnParticle("cloud", player.posX, player.posY + 0.6, player.posZ, new Random().nextFloat() - 0.5, new Random().nextFloat() - 0.2, new Random().nextFloat() - 0.5);

					
			TickCountParticle = 0;
				}else{
					
					TickCountParticle++;
				}

			}
		}
		
		}
		
	
	
	
	public void Speed(EntityPlayer player){
		
		
		if(player.inventory.armorInventory[1] == null || player.inventory.armorInventory[1].getItem() != ModItems.RunningLeggings){
			Leggings = false;
		}else if(player.inventory.armorInventory[1].getItem() == ModItems.RunningLeggings){
			Leggings = true;
			if(player.onGround && player.isInWater() == false){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 10));
			}
			
		}
	}
	
	
	public void Jump(EntityPlayer player){
		if(player.inventory.armorInventory[0] == null || player.inventory.armorInventory[0].getItem() != ModItems.JumpingBoots){
			Boots = false;
		}else if(player.inventory.armorInventory[0].getItem() == ModItems.JumpingBoots){
			Boots = true;
			if(player.onGround && player.isInWater() == false && player.isSneaking() == false){
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 200, 3));
			}
		}

		
	}

	
	
	
	public void Full(EntityPlayer player){
		

		if(Helmet && ChestPlate && Leggings && Boots){
			
						
						if(player.shouldHeal()){
							
							player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
							player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 2));
							player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 200, 1));
							
						}
						
						
					}
		
					
				}

	   public void initializeGame(EntityPlayer player, EntityPlayer plyr)
       {
               if(player == null || plyr == null)
               {
                       return;
               }
               activeGames.add((new GameInfo(player, plyr)).initialize());
       }
	   
	   
	   public void ServerTick(){
		   for(int i = activeGames.size() - 1; i >= 0; i--)
           {
			   
			   
               GameInfo ti = activeGames.get(i);
			   if(ti.terminate){
				   //FIX Find a new way!
				   ti.Player_1.openGui(Main.instance, 0, null, 0, 0, 0);
				   ti.Player_2.openGui(Main.instance, 0, null, 0, 0, 0);
//				   ti.Player_1.closeScreen();
//				   ti.Player_2.closeScreen();
				   activeGames.remove(i);
			   }
			   
			   
			   
           }
		   
		   
	   }


		
	}
	



