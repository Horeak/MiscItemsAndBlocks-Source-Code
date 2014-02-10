package com.miscitems.MiscItemsAndBlocks.Tick;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Lib.ModConfig;
import com.miscitems.MiscItemsAndBlocks.Misc.GameInfo;
import com.miscitems.MiscItemsAndBlocks.Misc.GameInvite;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.gameevent.TickEvent;

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
	
	
    @EventHandler
    public void tick(TickEvent.ServerTickEvent event){

            ServerTick();
    	
 
    }
    
    
    @EventHandler
    public void tick(TickEvent.PlayerTickEvent event){
    	
    	onPlayerTick(event.player);
    	
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
			
			if(ModConfig.AllowFlightChest)
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
				Random rand = new Random();
				if(TickCountParticle == 5){
					
					if(ModConfig.SpawnParticles){
			player.worldObj.spawnParticle("cloud", player.posX, player.posY + 0.6, player.posZ, rand.nextFloat() - 0.5, rand.nextFloat() - 0.2, rand.nextFloat() - 0.5);
					}
					
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
				   //TODO Find a new way!
//				   ti.Player_1.closeScreen();
//				   ti.Player_2.closeScreen();
				   activeGames.remove(i);
			   }
			   
			   
			   
           }
		   
		   
	   }


		
	}
	



