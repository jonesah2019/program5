/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc220.program5.jonesah2019;

import csc220.program5.GameCharacter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
    Andrew Jones
    4/28/2017
    Description: Class Robot extends GameCharacter and accepts over, down, side,
     and moveInterval into its constructor. The super constructor is also called
     and given over, down, side, moveInterval, and the new  
     csc220.program5.jonesah2019.List<>()) that is given points via add() calls
     in the constructor and also with the addBeforeNext() method that is used
     while the program is running. 
     
     The actual character is a "box-like" robot that has body of the color 
     'bodyColor', eyes that are the color of 'eyeColor', and limbs the color of
     'limbColor'.

     Note: This character only calls the clickAction when it is clicked on its 
      head. The body will not register any clicks.

 */
public class Robot extends GameCharacter {

    private Color bodyColor, eyeColor, limbColor;
    
    public Robot(Color bodyColor,  Color eyeColor, Color limbColor,int over, 
        int down, int side, int moveInterval) {
        
        super(over, down, side, side, moveInterval, new csc220.program5.jonesah2019.List<>());
        this.animationPath.add(new Point(over, down));
        animationPath.add(new Point(400, 20));
        animationPath.add(new Point(250, 250));
        
        this.bodyColor = bodyColor;
        this.eyeColor = eyeColor;
        this.limbColor = limbColor;
    }

    @Override
    public void draw(Graphics g) {
        
        // Head
        g.setColor(bodyColor);
        g.fillRect(getOver(), getDown(), getWidth(), getHeight());
        
        // Eyes
        int eyeHeight = getDown() + (getHeight()/4);
        int eyeHor1 = getOver() + (getWidth()/3);
        int eyeHor2 = getOver() + (2*getWidth()/3);
        int sideEye = getHeight()/8;
        g.setColor(eyeColor);
        g.fillRect(eyeHor1 - sideEye, eyeHeight, sideEye, sideEye);
        g.fillRect(eyeHor2, eyeHeight, sideEye, sideEye);
        
        // Smile
        int smileY = getDown() + (3*getHeight()/4);
        int smileX = getOver() + (getWidth()/4);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(smileX, smileY, (getWidth()/2), getHeight()/8);
        g.setColor(Color.BLACK);
        g.drawRect(smileX, smileY, (getWidth()/2), getHeight()/8);
        int toothX = smileX + getWidth()/8;
        g.drawRect(toothX, smileY, getWidth()/4, getHeight()/8);
        
        // Neck
        g.setColor(limbColor);
        int neckX = getOver() + (7*getWidth()/16);
        int neckY = getDown() + getHeight();
        g.fillRect(neckX, neckY, (getWidth()/8), getHeight()/8);
        
        // Body
        int bodyX = getOver() + (getWidth()/10);
        int bodyY = neckY + (getHeight()/8);
        g.setColor(bodyColor);
        g.fillRect(bodyX, bodyY, (4*getWidth()/5), (4*getHeight()/5));
        
        // Arms
        g.setColor(limbColor);
        int armY = bodyY + (getHeight()/10);
        g.fillRect(bodyX - (getWidth()/2), armY, getWidth()/2, getHeight()/10);
        g.fillRect(bodyX - (getWidth()/2), armY, getWidth()/10, getHeight()/2);
        
        int lArmX = bodyX + (4*getWidth()/5);
        g.fillRect(lArmX, armY, getWidth()/2, getHeight()/10);
        g.fillRect(lArmX + (2*getWidth()/5), armY, getWidth()/10, getHeight()/2);
        
        // Legs
        int legY = bodyY + (4*getHeight()/5);
        int rLegX = bodyX + (getWidth()/10);
        g.fillRect(rLegX, legY, getWidth()/5, getHeight()/3);
        
        int lLegX = bodyX + (getWidth()/2);
        g.fillRect(lLegX, legY, getWidth()/5, getHeight()/3);
        
    }
    
}
