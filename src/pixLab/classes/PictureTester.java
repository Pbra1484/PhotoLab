package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Patrick Brashear
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorVerticalRightToLeft()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.mirrorVerticalRightToLeft();
	  arch.explore();
	  
  }
  
  public static void testMirrorBottomToTop()
  {
	  Picture  flower = new Picture("flower1.jpg");
	  flower.explore();
	  flower.mirrorBottomToTop();
	  flower.explore();
	  
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testCopyCustom()
  {
	  Picture picture = new Picture("snowman.jpg");
	  Picture copyed = new Picture("swan.jpg");
	  picture.copyCustom(copyed, 30, 100, 2, 150);
	  picture.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void  testMirrorDiagonal()
  {
	  String fileName = FileChooser.pickAFile();
	   Picture caterpillar = new Picture(fileName);
	   Picture flower = new Picture("flower1.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorDiagonal();
	    caterpillar.explore();
	    flower.explore();
	    flower.mirrorDiagonalLeftUp();
	    flower.explore();
 }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snow = new Picture("snowman.jpg");
	  snow.explore();
	  snow.mirrorArms();
	  snow.explore();
  }

  public static void testEdgDetecsion()
  {
	  Picture swan = new Picture("swan.jpg");
	  swan.edgDetecsion(20);
	  swan.explore();
	
  }
  

  public static void sadMeme()
  {
	  Picture sadMeme = new Picture("meh.jpg");
	  sadMeme.addMessage("Singles Awarness Day", 60, 20);
	  sadMeme.addMessage("The day that reminds you", 55, 40);
	  sadMeme.addMessage("Its not worth the bad code", 55, 200);
	  sadMeme.explore();
	  sadMeme.write("SADMeme.jpg");
  }

  public static void testSpecialCollage()
  {
	  Picture base = new Picture("600x600.jpg");
	  base.createSpecialCollage();
	  base.explore();

  }
  
  public static void testGlitch()
  {
	  Picture glitch = new Picture("beach.jpg");
	  glitch.gLiTcH();
	  glitch.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
	 
	//testMirrorDiagonal();
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	//testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
	//testMirrorVertical();
	//testMirrorVerticalRightToLeft();
	//testMirrorBottomToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
	//testCopyCustom();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testEdgDetecsion();
	//sadMeme();
	  testGlitch();
	//testSpecialCollage();
  }
}