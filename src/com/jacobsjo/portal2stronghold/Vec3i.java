package com.jacobsjo.portal2stronghold;

public class Vec3i {
	int x,y,z;
	public Vec3i(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3i(Vec3i vec){
		this.x = vec.x;
		this.y = vec.y;
		this.z = vec.z;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int getZ(){return z;}
}