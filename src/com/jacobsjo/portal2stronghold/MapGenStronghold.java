package com.jacobsjo.portal2stronghold;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class MapGenStronghold
{
	Random rand;
	ChunkCoordIntPair[] structureCoords;
    /**
     * is spawned false and set true once the defined BiomeGenBases were compared with the present ones
     */

    public MapGenStronghold(Random rnd)
    {
        this.structureCoords = new ChunkCoordIntPair[3];
        this.rand = rnd;
    }


		/*
			use this.rand to generate Strongholds until there is one that has a portal room.
		*/

    public Start getStructureStart(int posx, int posy)
    {
        MapGenStronghold.Start strongholdStart;

        for (strongholdStart = new MapGenStronghold.Start(this.rand, posx, posy);				//TODO: What exactly is this.rand?	
        			strongholdStart.getComponents().isEmpty()
        					|| ((StructureStrongholdPieces.Stairs2)strongholdStart.getComponents().get(0)).strongholdPortalRoom == null;
        			strongholdStart = new MapGenStronghold.Start(this.rand, posx, posy)
        		)
        {
            ;
        }

        return strongholdStart;
    }

    public static class Start
    {
        private int posx;
        private int posy;
        protected LinkedList components;

        public LinkedList getComponents(){return components;};
        
        public int get_PosX(){ return posx; }
        public int get_PosY(){ return posy; }
        

        public Start(Random rnd, int posx, int posy)
        {
        	components = new LinkedList();
            this.posx = posx; this.posy = posy;
            StructureStrongholdPieces.prepareStructurePieces();
            StructureStrongholdPieces.Stairs2 startPiece = new StructureStrongholdPieces.Stairs2(0, rnd, (posx << 4) + 2, (posy << 4) + 2);
            this.components.add(startPiece);
            startPiece.buildComponent(startPiece, this.components, rnd);
            List remainingPieces = startPiece.field_75026_c;

            while (!remainingPieces.isEmpty())
            {
                int nextPieceNo = rnd.nextInt(remainingPieces.size());
                StructureComponent nextPiece = (StructureComponent)remainingPieces.remove(nextPieceNo);
                nextPiece.buildComponent(startPiece, this.components, rnd);
            }

        }
    }
}
