//package it.hurts.metallurgy_reforged.util.handler;
//
//import it.hurts.metallurgy_reforged.Metallurgy;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
//
///*************************************************
// * Author: Davoleo
// * Project: Metallurgy
// * Copyright - � - Davoleo - 2018
// **************************************************/
//
//public class CommonTickHandler {
//
//    public CommonTickHandler()
//    {
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    @SubscribeEvent
//    public void tick(TickEvent.ClientTickEvent event)
//    {
//        switch (event.phase)
//        {
//            case START:
//                break;
//            case END:
//                Metallurgy.ticker++;
//                break;
//        }
//    }
//    
//     @SubscribeEvent
//    public void tick(TickEvent.ServerTickEvent event)
//     {
//         switch (event.phase)
//         {
//             case START:
//                 break;
//             case END:
//                 break;
//         }
//     }
//}
