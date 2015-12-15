package com.jacobsjo.portal2stronghold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Random;

import com.jacobsjo.portal2stronghold.MapGenStronghold.Start;
import com.jacobsjo.portal2stronghold.StructureStrongholdPieces.Stronghold;


public class Portal2Stronghold {
	public static void main(String[] args){

		FileInputStream fstream = null;
		FileOutputStream ostream = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String strLine;
		try{
			ostream = new FileOutputStream("output.txt");
			fstream = new FileInputStream("log.txt");
			out = new DataOutputStream(ostream);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in)); 
			bw = new BufferedWriter(new OutputStreamWriter(out));
	        while ((strLine = br.readLine()) != null){
	        	String[] tokens = strLine.split(" ");
	        	checkSeedAndCoords(bw, Long.parseLong(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
	        }
	    } catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					br.close();
					in.close();
					fstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					bw.close();
					out.close();
					ostream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void checkSeedAndCoords(BufferedWriter out, long worldSeed, int filledCnt, int PortalChunkX, int PortalChunkZ) throws IOException{
		Random rand = new Random();
		
        int var4 = (PortalChunkX << 4) + 8;
        int var5 = (PortalChunkZ << 4) + 8;
		
		rand.setSeed(worldSeed);
        long seedXMult = rand.nextLong();
        long seedZMult = rand.nextLong();

		for (int x = PortalChunkX - 16 ; x <= PortalChunkX + 16 ; x++){
			for (int z = PortalChunkZ - 16 ; z <= PortalChunkZ + 16 ; z++){
                long var13 = (long)x * seedXMult;
                long var15 = (long)z * seedZMult;
                rand.setSeed(var13 ^ var15 ^ worldSeed);
				
                rand.nextInt();
                
				MapGenStronghold stronghold = new MapGenStronghold(rand);
				Start strongholdStart = stronghold.getStructureStart(x, z);
				
//				if (((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getBoundingBox()
//						.intersectsWith(var4, var5, var4 + 15, var5 + 15)){
					
					
//				int maxX = ((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getBoundingBox().maxX;
//				int maxZ = ((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getBoundingBox().maxZ;
//				int minX = ((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getBoundingBox().minX;
//				int minZ = ((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getBoundingBox().minZ;
				
//			    if (maxX >= var4 && maxX <= var4 + 15 && maxZ >= var5 && maxZ <= var5 + 15){
				
		        Iterator components = strongholdStart.components.iterator();

		        while (components.hasNext())
		        {
		            StructureComponent component = (StructureComponent)components.next();

		            if (component.getBoundingBox().intersectsWith(var4, var5, var4 + 15, var5 + 15))  // TODO: Liquid in BB
		            {
		            	if (component instanceof StructureStrongholdPieces.PortalRoom){
		    				int Chunkx = ((((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getPosition().x) - 8) >> 4;
		    				int Chunkz = ((((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom.getPosition().z) - 8) >> 4;
		    				if (Chunkx == PortalChunkX && Chunkz == PortalChunkZ){
		    					System.out.println(worldSeed + " " + filledCnt + " " + x + " " + z);
		    					out.write(worldSeed + " " + filledCnt + " " + x + " " + z);
		    					out.newLine();
		    				}
		            	}
	            		break;
		            }
				}
			}
		}		
	}
	
}
