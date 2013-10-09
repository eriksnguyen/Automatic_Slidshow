package player;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Erik
 */
public class ImagePanel extends JPanel implements ActionListener{
	
	private final FileNameExtensionFilter filter;
	private File[] allImages;
	private BufferedImage image;
	private int imageIndex;
	private boolean pause;
	private boolean forward;
	private long MIN_WAIT_LENGTH;
	private long waitLength;
	private int size;
	
	public ImagePanel(){
		filter = new FileNameExtensionFilter("PNG images", "png");
		image = new BufferedImage(200, 200, 1);
		allImages = new File[0];
		imageIndex = 0;
		pause = false;
		forward = true;
		MIN_WAIT_LENGTH = 50;
		waitLength = 250;
		size = 0;
	}
	
	/**
	 * Sets the directory of png images that the panel will try to display.
	 * @param directory the file directory to look into for images
	 * @throws IOException 
	 */
	public void setDirectory(File directory){
		int num = 0;
		for(File f : directory.listFiles()){
			if(f.isDirectory())
				continue;
			if(filter.accept(f))
				num++;
		}
		allImages = new File[num];
		
		num = 0;
		for(File f : directory.listFiles()){
			if(f.isDirectory())
				continue;
			if(filter.accept(f)){
				allImages[num++] = f;
			}
		}
		
		size = allImages.length;
	}
	
	public int numFiles(){
		return size;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
        // Center image in this component.
        int x = (getWidth() - image.getWidth()) / 2;
        int y = (getHeight() - image.getHeight()) / 2;
        g.drawImage(image, x, y, this);
	}
	
	/**
	 * Updates the displayed image
	 * @param i the new image
	 */
	private void update(int index){
		try {
			image = ImageIO.read(allImages[index]);
			repaint();
		} catch (IOException ex) {
		}
	}
	
	public void changeMultiplier(double multiplier){
		waitLength = MIN_WAIT_LENGTH + (long) (400 * multiplier);
	}
	
	/**
	 * Displays the images in sequential order
	 */
	public void play(){
		while(true){
			if(imageIndex == -1){
				imageIndex++;
			}
			if(imageIndex == allImages.length){
				imageIndex--;
			}
			update(imageIndex);
			autoPause();
			if(!pause){//Pausing ends the playback
				imageIndex += forward ? 1 : -1;
			}
		}
	}
	
	/**
	 * Adds a time gap inbetween displayed frames.
	 */
	private void autoPause(){
		try {
			Thread.sleep(waitLength);
		} catch (InterruptedException ex) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		switch(ae.getActionCommand()){
			case "pause":
				pause = true;
				break;
			case "play":
				pause = false;
				break;
			case "forward":
				forward = true;
				break;
			case "rewind":
				forward = false;
				break;
			case "first":
				update(imageIndex = 0);
				break;
			case "last":
				update(imageIndex = allImages.length - 1);
				break;
		}
	}
}
