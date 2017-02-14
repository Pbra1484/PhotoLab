package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Patrick Brashear
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  
	  
	  for(int row = pixels.length -1; row >= 0; row--)
	  {
		  for (int col = width / 2 -1; col >= 0; col--)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width -1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorBottomToTop()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  int height = pixels.length;
	  
	  for(int col = 0; col < pixels[0].length; col++)
	  {
		  for(int row = pixels.length / 2 -1; row >=0; row--)
		  {
			  topPixel = pixels[row][col];
			  botPixel = pixels[height - row - 1][col];
			  topPixel.setColor(botPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  
  public void copyCustom(Picture basePic, int startRow, int endRow, int startCol, int endCol)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel [][] toPicture = this.getPixels2D();
	  Pixel [][] fromPicture = basePic.getPixels2D();
	  for(int fromRow = 0, toRow = startRow; fromRow < fromPicture.length && toRow < toPicture.length && toRow < endRow; fromRow++, toRow++)
	  {
		  for(int fromCol = 0, toCol = startCol; fromCol < fromPicture[0].length && toCol < toPicture[0].length && toCol < endCol; fromCol++, toCol++)
		  {
			  fromPixel = fromPicture[fromRow][fromCol];
			  toPixel = toPicture[toRow][toCol];
			  toPixel.setColor(fromPixel.getColor());
		  }
	  }
  }
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void createSpecialCollage()
  {
    Picture left = new Picture("left.jpg");
    Picture right = new Picture("right.jpg");
    this.copy(left,0,0);
    this.copy(right,100,500);
    this.copy(left,200,0);
    this.copy(right,300,500);
    this.copy(left,400,0);
    this.copy(right,500,500);
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void mirrorDiagonal()
  {
	  
	  
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel tR = null;
	  Pixel bL = null;
	  int limit = Math.min(pixels.length, pixels[0].length);
	 
//	  if(pixels.length > pixels[0].length)
//	  {
//		  limit = pixels[0].length;
//	  }
//	  else if(pixels.length < pixels[0].length)
//	  {
//		  limit = pixels.length;
//	  }
//	  else
//	  {
//		  limit = pixels.length;
//	  }
	 
	  for(int row = 0; row < limit; row++)
	  {
		  for(int col = 0; col < limit; col++)
		  {
			  tR = pixels[row][col];
			  bL = pixels[col][row];
			 
			  bL.setColor(tR.getColor());
		  }
	  }
	  
	  
  }
  
  public void mirrorDiagonalLeftUp()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel tL = null;
	  Pixel bR = null;
	  
	  int shortest = Math.min(pixels.length, pixels[0].length);
	  
	  for(int row = 0; row < shortest; row++)
	  {
		  for(int col = 0; col < shortest; col++)
		  {
			  if(row + col != shortest -1)
			  {
				  tL = pixels[row][col];
				  bR = pixels[shortest - col - 1][shortest - row - 1];
				  tL.setColor(bR.getColor());
			  }
		  }
	  }
	  
	  
  }
  
  public void mirrorGull()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel gull = null;
	  Pixel mirror = null;
	  
	  for(int row = 230; row < 330; row++)
	  {
		  for(int col = 230; col < 345; col++)
		  {
			  gull = pixels[row][col];
			  mirror = pixels[row][col - 115];
			  
			  mirror.setColor(gull.getColor());
		  }
	  }
  }
  
  public void mirrorArms()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel arm = null;
	  Pixel mirror = null;
	  
	  for(int row = 191 ; row > 157; row--)
	  {
		  for(int col = 104 ; col < 300; col++)
		  {
			  arm = pixels[row][col];
			  mirror = pixels[row + 60][col];
			  
			  mirror.setColor(arm.getColor());
			  
			  
			  
		  }
	  }
  }
  
  public void edgDetecsion(int edgeDist)
  {
	Pixel mainPixel = null;
    Pixel rightPixel = null;
    Pixel botomPixel = null;
    Pixel diagonalPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color botomColor = null;
    Color diagonalColor = null;
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; col < pixels[0].length - 2; col++)
      {
        mainPixel = pixels[row][col];
        rightPixel = pixels[row][col + 1];
        botomPixel = pixels[row + 1][col];
        diagonalPixel = pixels[row + 1][col + 1];
        rightColor = rightPixel.getColor();
        botomColor = botomPixel.getColor();
        diagonalColor = diagonalPixel.getColor();
        
        
        if (mainPixel.colorDistance(rightColor) > edgeDist || mainPixel.colorDistance(botomColor) > edgeDist || mainPixel.colorDistance(diagonalColor) > edgeDist)
        {
          mainPixel.setColor(Color.BLACK);
        }
        else
        {
          mainPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  public void fullRandom()
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int red = (int)(Math.random() * 256);
			  int green = (int)(Math.random() * 256);
			  int blue = (int)(Math.random() * 256);
			  
			  currentPixel.setColor(new Color(red, green, blue));
		  }
	  }
  }
  
  public void fullRandomGreen()
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int green = (int)(Math.random() * 256);
			  
			  currentPixel.setGreen(green);
		  }
	  }
  }

  public void sadMeme()
  {
	  Picture sadMeme = new
	  sadMeme.addMessage();
  }
  
  public void  gLiTcH()
  {
	  Pixel[][]  picture = this.getPixels2D();
	  Pixel main  =  null;
	  Pixel second = null;
	  for(int times = 0; times < 4; times++)
	  {
		  int randRow =  (int)Math.random()*picture.length;
		  int randCol =  (int)Math.random()*picture[0].length;
		  
		  
		  
		  for(int row = randRow ; row < randRow + 100; row++)
		  {
			  for(int col = randCol ; col < randCol + 100; col++)
			  {
				  if(row <  picture.length - 10 && col < picture[0].length - 20 )
				  {
					  main = picture[row + 10][col + 20];
					  
					  if(row <  picture.length && col < picture[0].length)
					  {
						  second = picture[row][col];
					  
						  second.setColor(main.getColor());
						  if(Math.random() < 0.1)
						  {
							  int red = (int)(Math.random() * 256);
							  int green = (int)(Math.random() * 256);
							  int blue = (int)(Math.random() * 256);
							 second.setColor(new Color(red, green, blue));
						  }
					  }
				  }
			  }
		  }
	  }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("kitten2.jpg");
    beach.explore();    
    beach.mirrorGull();
     beach.mirrorArms();   
     beach.mirrorDiagonal();
    beach.mirrorDiagonalLeftUp();
    beach.zeroBlue();

//    beach.edgDetecsion(10);
    beach.explore();
    beach.write("caterfly.jpg");
  }
  
} // this } is the end of class Picture, put all new methods before this
