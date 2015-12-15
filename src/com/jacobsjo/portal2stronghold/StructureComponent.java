package com.jacobsjo.portal2stronghold;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class StructureComponent
{
    protected StructureBoundingBox boundingBox;

    /** switches the Coordinate System base off the Bounding Box */
    protected EnumFacing coordBaseMode;

    /** The type ID of this component. */
    protected int componentType;
    private static final String __OBFID = "CL_00000511";

    public StructureComponent() {}

    protected StructureComponent(int p_i2091_1_)
    {
        this.componentType = p_i2091_1_;
    }


    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {}

    public StructureBoundingBox getBoundingBox()
    {
        return this.boundingBox;
    }

    /**
     * Returns the component type ID of this component.
     */
    public int getComponentType()
    {
        return this.componentType;
    }

    /**
     * Discover if bounding box can fit within the current bounding box object.
     */
    public static StructureComponent findIntersecting(List p_74883_0_, StructureBoundingBox p_74883_1_)
    {
        Iterator var2 = p_74883_0_.iterator();
        StructureComponent var3;

        do
        {
            if (!var2.hasNext())
            {
                return null;
            }

            var3 = (StructureComponent)var2.next();
        }
        while (var3.getBoundingBox() == null || !var3.getBoundingBox().intersectsWith(p_74883_1_));

        return var3;
    }

    public Vec3i getPosition()
    {
        return new Vec3i(this.boundingBox.func_180717_f());
    }

    protected int getXWithOffset(int p_74865_1_, int p_74865_2_)
    {
        if (this.coordBaseMode == null)
        {
            return p_74865_1_;
        }
        else
        {
            switch (StructureComponent.SwitchEnumFacing.field_176100_a[this.coordBaseMode.ordinal()])
            {
                case 1:
                case 2:
                    return this.boundingBox.minX + p_74865_1_;

                case 3:
                    return this.boundingBox.maxX - p_74865_2_;

                case 4:
                    return this.boundingBox.minX + p_74865_2_;

                default:
                    return p_74865_1_;
            }
        }
    }

    protected int getYWithOffset(int p_74862_1_)
    {
        return this.coordBaseMode == null ? p_74862_1_ : p_74862_1_ + this.boundingBox.minY;
    }

    protected int getZWithOffset(int p_74873_1_, int p_74873_2_)
    {
        if (this.coordBaseMode == null)
        {
            return p_74873_2_;
        }
        else
        {
            switch (StructureComponent.SwitchEnumFacing.field_176100_a[this.coordBaseMode.ordinal()])
            {
                case 1:
                    return this.boundingBox.maxZ - p_74873_2_;

                case 2:
                    return this.boundingBox.minZ + p_74873_2_;

                case 3:
                case 4:
                    return this.boundingBox.minZ + p_74873_1_;

                default:
                    return p_74873_2_;
            }
        }
    }

    static final class SwitchEnumFacing
    {
        static final int[] field_176100_a = new int[EnumFacing.values().length];

        static
        {
            try
            {
                field_176100_a[EnumFacing.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_176100_a[EnumFacing.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_176100_a[EnumFacing.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_176100_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
