package com.jacobsjo.portal2stronghold;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class StructureStrongholdPieces extends StructureComponent
{
    private static final StructureStrongholdPieces.PieceWeight[] pieceWeightArray = new StructureStrongholdPieces.PieceWeight[] 
    	{
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Straight.class, 40, 0), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Prison.class, 5, 5), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.LeftTurn.class, 20, 0), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.RightTurn.class, 20, 0), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.RoomCrossing.class, 10, 6), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.StairsStraight.class, 5, 5), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Stairs.class, 5, 5), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Crossing.class, 5, 4), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.ChestCorridor.class, 5, 4), 
    		new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Library.class, 10, 2)
        {
            public boolean canSpawnMoreStructuresOfType(int p_75189_1_)
            {
                return super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 4;
            }
        }, new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.PortalRoom.class, 20, 1)
        {
            public boolean canSpawnMoreStructuresOfType(int p_75189_1_)
            {
                return super.canSpawnMoreStructuresOfType(p_75189_1_) && p_75189_1_ > 5;
            }
        }
    };
    private static List structurePieceList;
    private static Class strongComponentType;
    static int totalWeight;

    /**
     * sets up Arrays with the Structure pieces and their weights
     */
    public static void prepareStructurePieces()
    {
        structurePieceList = Lists.newArrayList();
        int pwa_length = pieceWeightArray.length;

        for (int i = 0; i < pwa_length; ++i)
        {
            StructureStrongholdPieces.PieceWeight pw = pieceWeightArray[i];
            pw.instancesSpawned = 0;
            structurePieceList.add(pw);
        }

        strongComponentType = null;
    }

		/**
		 * returns if there are Structure pieces left that have not reachted the limit and have not a infinite limit
		 *
		 * also sets totalWeight to the correct value
		 */

    private static boolean canAddStructurePieces()
    {
        boolean var0 = false;
        totalWeight = 0;
        StructureStrongholdPieces.PieceWeight var2;

        for (Iterator var1 = structurePieceList.iterator(); var1.hasNext(); totalWeight += var2.pieceWeight)
        {
            var2 = (StructureStrongholdPieces.PieceWeight)var1.next();

            if (var2.instancesLimit > 0 && var2.instancesSpawned < var2.instancesLimit)
            {
                var0 = true;
            }
        }

        return var0;
    }

		//TODO: WHAT?
    private static StructureStrongholdPieces.Stronghold func_175954_a(Class p_175954_0_, List p_175954_1_, Random p_175954_2_, int p_175954_3_, int p_175954_4_, int p_175954_5_, EnumFacing p_175954_6_, int p_175954_7_)
    {
        Object var8 = null;

        if (p_175954_0_ == StructureStrongholdPieces.Straight.class)
        {
            var8 = StructureStrongholdPieces.Straight.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.Prison.class)
        {
            var8 = StructureStrongholdPieces.Prison.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.LeftTurn.class)
        {
            var8 = StructureStrongholdPieces.LeftTurn.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.RightTurn.class)
        {
            var8 = StructureStrongholdPieces.RightTurn.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.RoomCrossing.class)
        {
            var8 = StructureStrongholdPieces.RoomCrossing.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.StairsStraight.class)
        {
            var8 = StructureStrongholdPieces.StairsStraight.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.Stairs.class)
        {
            var8 = StructureStrongholdPieces.Stairs.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.Crossing.class)
        {
            var8 = StructureStrongholdPieces.Crossing.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.ChestCorridor.class)
        {
            var8 = StructureStrongholdPieces.ChestCorridor.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.Library.class)
        {
            var8 = StructureStrongholdPieces.Library.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }
        else if (p_175954_0_ == StructureStrongholdPieces.PortalRoom.class)
        {
            var8 = StructureStrongholdPieces.PortalRoom.getComponent(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
        }

        return (StructureStrongholdPieces.Stronghold)var8;
    }



		// Used for calculating positons and stuff for ajacent Components ... I think ;)
    private static StructureComponent func_175953_c(StructureStrongholdPieces.Stairs2 p_175953_0_, List p_175953_1_, Random p_175953_2_, int p_175953_3_, int p_175953_4_, int p_175953_5_, EnumFacing p_175953_6_, int p_175953_7_)
    {
        if (p_175953_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_175953_3_ - p_175953_0_.getBoundingBox().minX) <= 112 && Math.abs(p_175953_5_ - p_175953_0_.getBoundingBox().minZ) <= 112)
        {
            StructureStrongholdPieces.Stronghold var8 = func_175955_b(p_175953_0_, p_175953_1_, p_175953_2_, p_175953_3_, p_175953_4_, p_175953_5_, p_175953_6_, p_175953_7_ + 1);

            if (var8 != null)
            {
                p_175953_1_.add(var8);
                p_175953_0_.field_75026_c.add(var8);
            }

            return var8;
        }
        else
        {
            return null;
        }
    }
    
    private static StructureStrongholdPieces.Stronghold func_175955_b(StructureStrongholdPieces.Stairs2 p_175955_0_, List p_175955_1_, Random p_175955_2_, int p_175955_3_, int p_175955_4_, int p_175955_5_, EnumFacing p_175955_6_, int p_175955_7_)
    {
        if (!canAddStructurePieces())
        {
            return null;
        }
        else
        {
            if (strongComponentType != null)
            {
                StructureStrongholdPieces.Stronghold var8 = func_175954_a(strongComponentType, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
                strongComponentType = null;

                if (var8 != null)
                {
                    return var8;
                }
            }

            int var13 = 0;

            while (var13 < 5)
            {
                ++var13;
                int var9 = p_175955_2_.nextInt(totalWeight);
                Iterator var10 = structurePieceList.iterator();

                while (var10.hasNext())
                {
                    StructureStrongholdPieces.PieceWeight var11 = (StructureStrongholdPieces.PieceWeight)var10.next();
                    var9 -= var11.pieceWeight;

                    if (var9 < 0)
                    {
                        if (!var11.canSpawnMoreStructuresOfType(p_175955_7_) || var11 == p_175955_0_.strongholdPieceWeight)
                        {
                            break;
                        }

                        StructureStrongholdPieces.Stronghold var12 = func_175954_a(var11.pieceClass, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);

                        if (var12 != null)
                        {
                            ++var11.instancesSpawned;
                            p_175955_0_.strongholdPieceWeight = var11;

                            if (!var11.canSpawnMoreStructures())
                            {
                                structurePieceList.remove(var11);
                            }

                            return var12;
                        }
                    }
                }
            }

            StructureBoundingBox var14 = StructureStrongholdPieces.Corridor.getComponent(p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_);

            if (var14 != null && var14.minY > 1)
            {
                return new StructureStrongholdPieces.Corridor(p_175955_7_, p_175955_2_, var14, p_175955_6_);
            }
            else
            {
                return null;
            }
        }
    }
    
    
    static class PieceWeight
    {
        public Class pieceClass;
        public final int pieceWeight;
        public int instancesSpawned;
        public int instancesLimit;
        private static final String __OBFID = "CL_00000492";

        public PieceWeight(Class p_i2076_1_, int p_i2076_2_, int p_i2076_3_)
        {
            this.pieceClass = p_i2076_1_;
            this.pieceWeight = p_i2076_2_;
            this.instancesLimit = p_i2076_3_;
        }

        public boolean canSpawnMoreStructuresOfType(int p_75189_1_)
        {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }

        public boolean canSpawnMoreStructures()
        {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
    }
    
    //===========================================================================================================================================================================================

    public static class ChestCorridor extends StructureStrongholdPieces.Stronghold
    {
        public ChestCorridor(int p_i45582_1_, Random p_i45582_2_, StructureBoundingBox p_i45582_3_, EnumFacing p_i45582_4_)
        {
            super(p_i45582_1_);
            this.coordBaseMode = p_i45582_4_;
            this.field_143013_d = this.getRandomDoor(p_i45582_2_);
            this.boundingBox = p_i45582_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static StructureStrongholdPieces.ChestCorridor getComponent(List p_175868_0_, Random p_175868_1_, int p_175868_2_, int p_175868_3_, int p_175868_4_, EnumFacing p_175868_5_, int p_175868_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175868_2_, p_175868_3_, p_175868_4_, -1, -1, 0, 5, 5, 7, p_175868_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175868_0_, var7) == null ? new StructureStrongholdPieces.ChestCorridor(p_175868_6_, p_175868_1_, var7, p_175868_5_) : null;
        }

    }

    public static class Corridor extends StructureStrongholdPieces.Stronghold
    {
        private int field_74993_a;

        public Corridor(int p_i45581_1_, Random p_i45581_2_, StructureBoundingBox p_i45581_3_, EnumFacing p_i45581_4_)
        {
            super(p_i45581_1_);
            this.coordBaseMode = p_i45581_4_;
            this.boundingBox = p_i45581_3_;
            this.field_74993_a = p_i45581_4_ != EnumFacing.NORTH && p_i45581_4_ != EnumFacing.SOUTH ? p_i45581_3_.getXSize() : p_i45581_3_.getZSize();
        }

        public static StructureBoundingBox getComponent(List p_175869_0_, Random p_175869_1_, int p_175869_2_, int p_175869_3_, int p_175869_4_, EnumFacing p_175869_5_)
        {
            boolean var6 = true;
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, 4, p_175869_5_);
            StructureComponent var8 = StructureComponent.findIntersecting(p_175869_0_, var7);

            if (var8 == null)
            {
                return null;
            }
            else
            {
                if (var8.getBoundingBox().minY == var7.minY)
                {
                    for (int var9 = 3; var9 >= 1; --var9)
                    {
                        var7 = StructureBoundingBox.func_175897_a(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, var9 - 1, p_175869_5_);

                        if (!var8.getBoundingBox().intersectsWith(var7))
                        {
                            return StructureBoundingBox.func_175897_a(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, var9, p_175869_5_);
                        }
                    }
                }

                return null;
            }
        }

    }

    public static class Crossing extends StructureStrongholdPieces.Stronghold
    {
        private boolean continue_x_p;
        private boolean continue_x_n;
        private boolean continue_z_p;
        private boolean continue_z_n;

        public Crossing(int p_i45580_1_, Random p_i45580_2_, StructureBoundingBox p_i45580_3_, EnumFacing p_i45580_4_)
        {
            super(p_i45580_1_);
            this.coordBaseMode = p_i45580_4_;
            this.field_143013_d = this.getRandomDoor(p_i45580_2_);
            this.boundingBox = p_i45580_3_;
            this.continue_x_p = p_i45580_2_.nextBoolean();
            this.continue_x_n = p_i45580_2_.nextBoolean();
            this.continue_z_p = p_i45580_2_.nextBoolean();
            this.continue_z_n = p_i45580_2_.nextInt(3) > 0;
        }

        public void buildComponent(StructureComponent baseComp, List components, Random rnd)
        {
            int var4 = 3;
            int var5 = 5;

            if (this.coordBaseMode == EnumFacing.WEST || this.coordBaseMode == EnumFacing.NORTH)
            {
                var4 = 8 - var4;
                var5 = 8 - var5;
            }

            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)baseComp, components, rnd, 5, 1);

            if (this.continue_x_p)
            {
                this.getNextComponentX((StructureStrongholdPieces.Stairs2)baseComp, components, rnd, var4, 1);
            }

            if (this.continue_x_n)
            {
                this.getNextComponentX((StructureStrongholdPieces.Stairs2)baseComp, components, rnd, var5, 7);
            }

            if (this.continue_z_p)
            {
                this.getNextComponentZ((StructureStrongholdPieces.Stairs2)baseComp, components, rnd, var4, 1);
            }

            if (this.continue_z_n)
            {
                this.getNextComponentZ((StructureStrongholdPieces.Stairs2)baseComp, components, rnd, var5, 7);
            }
        }

        public static StructureStrongholdPieces.Crossing getComponent(List p_175866_0_, Random p_175866_1_, int p_175866_2_, int p_175866_3_, int p_175866_4_, EnumFacing p_175866_5_, int p_175866_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175866_2_, p_175866_3_, p_175866_4_, -4, -3, 0, 10, 9, 11, p_175866_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175866_0_, var7) == null ? new StructureStrongholdPieces.Crossing(p_175866_6_, p_175866_1_, var7, p_175866_5_) : null;
        }


    }

    public static class LeftTurn extends StructureStrongholdPieces.Stronghold
    {
        public LeftTurn(int p_i45579_1_, Random p_i45579_2_, StructureBoundingBox p_i45579_3_, EnumFacing p_i45579_4_)
        {
            super(p_i45579_1_);
            this.coordBaseMode = p_i45579_4_;
            this.field_143013_d = this.getRandomDoor(p_i45579_2_);
            this.boundingBox = p_i45579_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST)
            {
                this.getNextComponentZ((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
            else
            {
                this.getNextComponentX((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
        }

        public static StructureStrongholdPieces.LeftTurn getComponent(List p_175867_0_, Random p_175867_1_, int p_175867_2_, int p_175867_3_, int p_175867_4_, EnumFacing p_175867_5_, int p_175867_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175867_2_, p_175867_3_, p_175867_4_, -1, -1, 0, 5, 5, 5, p_175867_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175867_0_, var7) == null ? new StructureStrongholdPieces.LeftTurn(p_175867_6_, p_175867_1_, var7, p_175867_5_) : null;
        }

    }
    
    public static class RightTurn extends StructureStrongholdPieces.LeftTurn
    {

    	public RightTurn(int p_i45579_1_, Random p_i45579_2_, StructureBoundingBox p_i45579_3_, EnumFacing p_i45579_4_) {
			super(p_i45579_1_, p_i45579_2_, p_i45579_3_, p_i45579_4_);
		}

		public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.EAST)
            {
                this.getNextComponentX((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
            else
            {
                this.getNextComponentZ((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
            }
        }
    }




    public static class Library extends StructureStrongholdPieces.Stronghold
    {
        private boolean isLargeRoom;

        public Library(int p_i45578_1_, Random p_i45578_2_, StructureBoundingBox p_i45578_3_, EnumFacing p_i45578_4_)
        {
            super(p_i45578_1_);
            this.coordBaseMode = p_i45578_4_;
            this.field_143013_d = this.getRandomDoor(p_i45578_2_);
            this.boundingBox = p_i45578_3_;
            this.isLargeRoom = p_i45578_3_.getYSize() > 6;
        }

        public static StructureStrongholdPieces.Library getComponent(List p_175864_0_, Random p_175864_1_, int p_175864_2_, int p_175864_3_, int p_175864_4_, EnumFacing p_175864_5_, int p_175864_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 11, 15, p_175864_5_);

            if (!canStrongholdGoDeeper(var7) || StructureComponent.findIntersecting(p_175864_0_, var7) != null)
            {
                var7 = StructureBoundingBox.func_175897_a(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 6, 15, p_175864_5_);

                if (!canStrongholdGoDeeper(var7) || StructureComponent.findIntersecting(p_175864_0_, var7) != null)
                {
                    return null;
                }
            }

            return new StructureStrongholdPieces.Library(p_175864_6_, p_175864_1_, var7, p_175864_5_);
        }
 
    }

 

    public static class PortalRoom extends StructureStrongholdPieces.Stronghold
    {
        private boolean hasSpawner;

        public PortalRoom(int p_i45577_1_, Random p_i45577_2_, StructureBoundingBox p_i45577_3_, EnumFacing p_i45577_4_)
        {
            super(p_i45577_1_);
            this.coordBaseMode = p_i45577_4_;
            this.boundingBox = p_i45577_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (p_74861_1_ != null)
            {
                ((StructureStrongholdPieces.Stairs2)p_74861_1_).strongholdPortalRoom = this;
            }
        }

        public static StructureStrongholdPieces.PortalRoom getComponent(List p_175865_0_, Random p_175865_1_, int p_175865_2_, int p_175865_3_, int p_175865_4_, EnumFacing p_175865_5_, int p_175865_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175865_2_, p_175865_3_, p_175865_4_, -4, -1, 0, 11, 8, 16, p_175865_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175865_0_, var7) == null ? new StructureStrongholdPieces.PortalRoom(p_175865_6_, p_175865_1_, var7, p_175865_5_) : null;
        }

    }


    
    public static class Prison extends StructureStrongholdPieces.Stronghold
    {
        public Prison(int p_i45576_1_, Random p_i45576_2_, StructureBoundingBox p_i45576_3_, EnumFacing p_i45576_4_)
        {
            super(p_i45576_1_);
            this.coordBaseMode = p_i45576_4_;
            this.field_143013_d = this.getRandomDoor(p_i45576_2_);
            this.boundingBox = p_i45576_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static StructureStrongholdPieces.Prison getComponent(List p_175860_0_, Random p_175860_1_, int p_175860_2_, int p_175860_3_, int p_175860_4_, EnumFacing p_175860_5_, int p_175860_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175860_2_, p_175860_3_, p_175860_4_, -1, -1, 0, 9, 5, 11, p_175860_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175860_0_, var7) == null ? new StructureStrongholdPieces.Prison(p_175860_6_, p_175860_1_, var7, p_175860_5_) : null;
        }

    }

    public static class RoomCrossing extends StructureStrongholdPieces.Stronghold
    {
        protected int roomType;

        public RoomCrossing(int p_i45575_1_, Random p_i45575_2_, StructureBoundingBox p_i45575_3_, EnumFacing p_i45575_4_)
        {
            super(p_i45575_1_);
            this.coordBaseMode = p_i45575_4_;
            this.field_143013_d = this.getRandomDoor(p_i45575_2_);
            this.boundingBox = p_i45575_3_;
            this.roomType = p_i45575_2_.nextInt(5);
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 4, 1);
            this.getNextComponentX((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
            this.getNextComponentZ((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
        }

        public static StructureStrongholdPieces.RoomCrossing getComponent(List p_175859_0_, Random p_175859_1_, int p_175859_2_, int p_175859_3_, int p_175859_4_, EnumFacing p_175859_5_, int p_175859_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175859_2_, p_175859_3_, p_175859_4_, -4, -1, 0, 11, 7, 11, p_175859_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175859_0_, var7) == null ? new StructureStrongholdPieces.RoomCrossing(p_175859_6_, p_175859_1_, var7, p_175859_5_) : null;
        }
    }

    public static class Stairs extends StructureStrongholdPieces.Stronghold
    {
        private boolean field_75024_a;

        public Stairs(int p_i2081_1_, Random p_i2081_2_, int p_i2081_3_, int p_i2081_4_)
        {
            super(p_i2081_1_);
            this.field_75024_a = true;
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(p_i2081_2_);
            this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;

            switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()])
            {
                case 1:
                case 2:
                    this.boundingBox = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
                    break;

                default:
                    this.boundingBox = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
            }
        }

        public Stairs(int p_i45574_1_, Random p_i45574_2_, StructureBoundingBox p_i45574_3_, EnumFacing p_i45574_4_)
        {
            super(p_i45574_1_);
            this.field_75024_a = false;
            this.coordBaseMode = p_i45574_4_;
            this.field_143013_d = this.getRandomDoor(p_i45574_2_);
            this.boundingBox = p_i45574_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            if (this.field_75024_a)
            {
                StructureStrongholdPieces.strongComponentType = StructureStrongholdPieces.Crossing.class;
            }

            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static StructureStrongholdPieces.Stairs getComponent(List p_175863_0_, Random p_175863_1_, int p_175863_2_, int p_175863_3_, int p_175863_4_, EnumFacing p_175863_5_, int p_175863_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175863_2_, p_175863_3_, p_175863_4_, -1, -7, 0, 5, 11, 5, p_175863_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175863_0_, var7) == null ? new StructureStrongholdPieces.Stairs(p_175863_6_, p_175863_1_, var7, p_175863_5_) : null;
        }


    }

    public static class Stairs2 extends StructureStrongholdPieces.Stairs
    {
        public StructureStrongholdPieces.PieceWeight strongholdPieceWeight;
        public StructureStrongholdPieces.PortalRoom strongholdPortalRoom;
        public List field_75026_c = Lists.newArrayList();

        public Stairs2(int p_i2083_1_, Random p_i2083_2_, int p_i2083_3_, int p_i2083_4_)
        {
            super(0, p_i2083_2_, p_i2083_3_, p_i2083_4_);
        }

        public Vec3i getPosition()
        {
            return this.strongholdPortalRoom != null ? this.strongholdPortalRoom.getPosition() : super.getPosition();
        }
    }

    public static class StairsStraight extends StructureStrongholdPieces.Stronghold
    {
        public StairsStraight(int p_i45572_1_, Random p_i45572_2_, StructureBoundingBox p_i45572_3_, EnumFacing p_i45572_4_)
        {
            super(p_i45572_1_);
            this.coordBaseMode = p_i45572_4_;
            this.field_143013_d = this.getRandomDoor(p_i45572_2_);
            this.boundingBox = p_i45572_3_;
        }

        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }

        public static StructureStrongholdPieces.StairsStraight getComponent(List p_175861_0_, Random p_175861_1_, int p_175861_2_, int p_175861_3_, int p_175861_4_, EnumFacing p_175861_5_, int p_175861_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175861_2_, p_175861_3_, p_175861_4_, -1, -7, 0, 5, 11, 8, p_175861_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175861_0_, var7) == null ? new StructureStrongholdPieces.StairsStraight(p_175861_6_, p_175861_1_, var7, p_175861_5_) : null;
        }
    }

    public static class Straight extends StructureStrongholdPieces.Stronghold
    {
        private boolean expandsX;
        private boolean expandsZ;

        public Straight(int p_i45573_1_, Random p_i45573_2_, StructureBoundingBox p_i45573_3_, EnumFacing p_i45573_4_)
        {
            super(p_i45573_1_);
            this.coordBaseMode = p_i45573_4_;
            this.field_143013_d = this.getRandomDoor(p_i45573_2_);
            this.boundingBox = p_i45573_3_;
            this.expandsX = p_i45573_2_.nextInt(2) == 0;
            this.expandsZ = p_i45573_2_.nextInt(2) == 0;
        }


        public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
        {
            this.getNextComponentNormal((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);

            if (this.expandsX)
            {
                this.getNextComponentX((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
            }

            if (this.expandsZ)
            {
                this.getNextComponentZ((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
            }
        }

        public static StructureStrongholdPieces.Straight getComponent(List p_175862_0_, Random p_175862_1_, int p_175862_2_, int p_175862_3_, int p_175862_4_, EnumFacing p_175862_5_, int p_175862_6_)
        {
            StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175862_2_, p_175862_3_, p_175862_4_, -1, -1, 0, 5, 5, 7, p_175862_5_);
            return canStrongholdGoDeeper(var7) && StructureComponent.findIntersecting(p_175862_0_, var7) == null ? new StructureStrongholdPieces.Straight(p_175862_6_, p_175862_1_, var7, p_175862_5_) : null;
        }

     }

    abstract static class Stronghold extends StructureComponent
    {
        protected StructureStrongholdPieces.Stronghold.Door field_143013_d;

        protected Stronghold(int p_i2087_1_)
        {
            super(p_i2087_1_);
        }


        protected StructureStrongholdPieces.Stronghold.Door getRandomDoor(Random p_74988_1_)
        {
            p_74988_1_.nextInt(5); // needed to keep nextInt order
  
            return StructureStrongholdPieces.Stronghold.Door.OPENING;
        }

        protected StructureComponent getNextComponentNormal(StructureStrongholdPieces.Stairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_) // Don't ask me what it does ... I don't know ether (komes from MC / MCP)
        {
            if (this.coordBaseMode != null)
            {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ - 1, this.coordBaseMode, this.getComponentType());

                    case 2:
                        return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX + p_74986_4_, this.boundingBox.minY + p_74986_5_, this.boundingBox.maxZ + 1, this.coordBaseMode, this.getComponentType());

                    case 3:
                        return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, this.coordBaseMode, this.getComponentType());

                    case 4:
                        return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74986_5_, this.boundingBox.minZ + p_74986_4_, this.coordBaseMode, this.getComponentType());
                }
            }

            return null;
        }

        protected StructureComponent getNextComponentX(StructureStrongholdPieces.Stairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_)
        {
            if (this.coordBaseMode != null)
            {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, EnumFacing.WEST, this.getComponentType());

                    case 2:
                        return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ + p_74989_5_, EnumFacing.WEST, this.getComponentType());

                    case 3:
                        return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());

                    case 4:
                        return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.boundingBox.minX + p_74989_5_, this.boundingBox.minY + p_74989_4_, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
            }

            return null;
        }

        protected StructureComponent getNextComponentZ(StructureStrongholdPieces.Stairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_)
        {
            if (this.coordBaseMode != null)
            {
                switch (StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.coordBaseMode.ordinal()])
                {
                    case 1:
                        return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, EnumFacing.EAST, this.getComponentType());

                    case 2:
                        return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74987_4_, this.boundingBox.minZ + p_74987_5_, EnumFacing.EAST, this.getComponentType());

                    case 3:
                        return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());

                    case 4:
                        return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.boundingBox.minX + p_74987_5_, this.boundingBox.minY + p_74987_4_, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
            }

            return null;
        }

        protected static boolean canStrongholdGoDeeper(StructureBoundingBox p_74991_0_)
        {
            return p_74991_0_ != null && p_74991_0_.minY > 10;
        }

        public static enum Door
        {
            OPENING("OPENING", 0),
            WOOD_DOOR("WOOD_DOOR", 1),
            GRATES("GRATES", 2),
            IRON_DOOR("IRON_DOOR", 3);

            private static final StructureStrongholdPieces.Stronghold.Door[] $VALUES = new StructureStrongholdPieces.Stronghold.Door[]{OPENING, WOOD_DOOR, GRATES, IRON_DOOR};
            private static final String __OBFID = "CL_00000504";

            private Door(String p_i2086_1_, int p_i2086_2_) {}
        }
    }

    static final class SwitchEnumFacing
    {
        static final int[] doorEnum;

        static final int[] field_175951_b = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00001970";

        static
        {
            try
            {
                field_175951_b[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError var8)
            {
                ;
            }

            try
            {
                field_175951_b[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var7)
            {
                ;
            }

            try
            {
                field_175951_b[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                field_175951_b[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            doorEnum = new int[StructureStrongholdPieces.Stronghold.Door.values().length];

            try
            {
                doorEnum[StructureStrongholdPieces.Stronghold.Door.OPENING.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                doorEnum[StructureStrongholdPieces.Stronghold.Door.WOOD_DOOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                doorEnum[StructureStrongholdPieces.Stronghold.Door.GRATES.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                doorEnum[StructureStrongholdPieces.Stronghold.Door.IRON_DOOR.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
